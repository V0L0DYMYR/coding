package com.coding.recursive;

public class ScrambleString {
  public boolean isScramble(String s1, String s2) {
    if (s1.equals(s2)) return true;
    int len = s1.length();
    if (len != s2.length() || len == 1) return false;

    int i = len/2;
    String s11 = s1.substring(0, i),
        s12 = s1.substring(i),
        s21 = s2.substring(0, i),
        s22 = s2.substring(i);

    if (s2.equals(s12 + s11)) return true;

    if (isScramble(s11, s21) &&
        isScramble(s12, s22)) return true;

    if (isScramble(s11, s22) &&
        isScramble(s12, s21)) return true;

    if (len % 2 == 1) {
      i++;
      s11 = s1.substring(0, i);
      s12 = s1.substring(i);
      s21 = s2.substring(0, i);
      s22 = s2.substring(i);

      if (s2.equals(s12 + s11)) return true;

      if (isScramble(s11, s21) &&
          isScramble(s12, s22)) return true;

      s21 = s2.substring(0, i-1);
      s22 = s2.substring(i-1);

      if (s2.equals(s12 + s11)) return true;

      if (isScramble(s11, s21) &&
          isScramble(s12, s22)) return true;

      if (isScramble(s11, s22) &&
          isScramble(s12, s21)) return true;
    }
    return false;
  }
}
