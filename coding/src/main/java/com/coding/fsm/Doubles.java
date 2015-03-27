package com.coding.fsm;

public class Doubles {

  public static Double tryParse(String s) {
    Double result = null;

    if (s != null && s.length() > 0) {

      StateMachine sm = new StateMachine();

      for (char c : s.toCharArray()) {
        sm.next(c);
      }

      result = sm.getResult();
    }

    return result;
  }

  private static class StateMachine {

    private State state = State.INIT;
    private ParserData data = new ParserData();

    public void next(char c) {
      state = state.next(c, data);
    }

    public Double getResult() {
      state = state.terminate();
      Double result = null;

      if (state == State.VALID_END) {
        result = data.getDouble();
      }

      return result;
    }

    private enum State {

      INIT {
        @Override
        public State next(char c, ParserData data) {
          State result = INVALID_END;
          result = handleDigit(c, data, result);
          if (c == '-' || c == '+') {
            data.setNegativeNumber(c == '-');
            result = SIGN;
          }
          result = handleInitSpace(c, result);
          return result;
        }
      },
      SIGN {
        @Override
        public State next(char c, ParserData data) {
          State result = INVALID_END;
          result = handleDigit(c, data, result);
          return result;
        }
      },
      NUMBER {
        @Override
        public State next(char c, ParserData data) {
          State result = INVALID_END;
          result = handleDigit(c, data, result);
          result = handleEndSpace(c, result);
          if (c == '.') {
            result = POINT_AFTER;
          }
          return result;
        }
      },
      POINT_AFTER {
        @Override
        public State next(char c, ParserData data) {
          State result = INVALID_END;
          result = handleEndSpace(c, result);
          result = handleDecimal(c, data, result);
          return result;
        }
      },
      DECIMAL {
        @Override
        public State next(char c, ParserData data) {
          State result = INVALID_END;
          result = handleDecimal(c, data, result);
          result = handleEndSpace(c, result);
          return result;
        }
      },
      VALID_END {
        @Override
        public State next(char c, ParserData data) {
          State result = INVALID_END;
          result = handleEndSpace(c, result);
          return result;
        }
      },
      INVALID_END {
        @Override
        public State next(char c, ParserData data) {
          return INVALID_END;
        }
      };

      private static State handleInitSpace(char c, State result) {
        if (c == ' ') {
          result = INIT;
        }
        return result;
      }

      private static State handleEndSpace(char c, State result) {
        if (c == ' ') {
          result = VALID_END;
        }
        return result;
      }

      private static State handleDecimal(char c, ParserData data, State result) {
        if (isDigit(c)) {
          data.pushDigitToDecimal(c - '0');
          result = DECIMAL;
        }
        return result;
      }

      private static State handleDigit(char c, ParserData data, State result) {
        if (isDigit(c)) {
          data.pushDigitToNumber(c - '0');
          result = NUMBER;
        }
        return result;
      }

      private static boolean isDigit(char c) {
        int digit = c - '0';
        return 0 <= digit && digit <= 9;
      }

      public abstract State next(char c, ParserData data);

      public State terminate() {
        State result = INVALID_END;
        if (this == NUMBER || this == VALID_END) {
          result = VALID_END;
        }
        return result;
      }
    }

    private class ParserData {
      private boolean negativeNumber = false;
      private int number = 0;
      private int decimal = 0;
      private int decimalDigits = 0;

      public void pushDigitToNumber(int digit) {
        number = number * 10 + digit;
      }

      public void setNegativeNumber(boolean b) {
        negativeNumber = b;
      }

      public void pushDigitToDecimal(int digit) {
        decimal = decimal * 10 + digit;
        decimalDigits++;
      }

      public Double getDouble() {
        int number = data.number;
        if (data.negativeNumber) {
          number *= -1;
        }
        double result = number;
        result += decimal / Math.pow(10, decimalDigits);
        return result;
      }
    }
  }
}


