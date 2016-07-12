package com.coding.stacks;

import java.util.Deque;
import java.util.LinkedList;

public class ReversePolishNotation {

  public static Integer evaluate(String s) {
    Integer result = null;
    Deque<Integer> stack = new LinkedList<>();

    if (s != null && s.length() > 0) {
      Integer num = null;

      for (char c : s.toCharArray()) {

        if (c == ' ') {
          if (num != null) {
            stack.push(num);
            num = null;
          }
        } else if (isDigit(c)) {
          int digit = c - '0';

          if (num == null) {
            num = digit;
          } else {
            num = num * 10 + digit;
          }
        } else {
          Integer num2 = stack.pop();
          Integer num1 = stack.pop();

          if (c == '+') {
            stack.push(num1 + num2);
          } else if (c == '-') {
            stack.push(num1 - num2);
          } else if (c == '*') {
            stack.push(num1 * num2);
          } else if (c == '/') {
            stack.push(num1 / num2);
          }
        }
      }
      result = stack.pop();
    }
    return result;
  }

  private static boolean isDigit(char c) {
    int digit = c - '0';
    return 0 <= digit && digit <= 9;
  }
}
