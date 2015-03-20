package com.coding.dp.strings;

/**
 *
 */
public class Strings {

  private Strings() {
  }

  /**
   * @param one
   * @param two
   * @return
   */
  public static String lcs(String one, String two) {
    String result = null;
    if (one != null && two != null) {
      result = "";
    }
    return result;
  }

  public static boolean isInterleave(String s1, String s2, String s3) {
    boolean res = false;
    int len1 = s1.length(), len2 = s2.length();
    boolean[][] interleaves = new boolean[len1+1][len2+1];

    if (len1+len2 == s3.length()) {

      for (int i = 0; i < interleaves.length; i++) {
        for (int j = 0; j < interleaves[0].length; j++) {

          if (i == 0 && j == 0) {
            interleaves[i][j] = true;
          } else if(i == 0) {
            interleaves[i][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && interleaves[i][j-1];
          } else if(j == 0) {
            interleaves[i][j] = s1.charAt(i-1) == s3.charAt(i - 1) && interleaves[i-1][j];
          } else {
            char c1 = s1.charAt(i-1);
            char c2 = s2.charAt(j-1);
            char c3 = s3.charAt(i+j -1);

            interleaves[i][j] |= (c2 == c3) && (interleaves[i][j-1]);
            interleaves[i][j] |= (c1 == c3) && (interleaves[i-1][j]);
          }
        }
      }
      res = interleaves[len1][len2];
      for (boolean[] interleaf : interleaves) {
        for (int i = 0; i < interleaf.length; i++) {
          System.out.print(interleaf[i] ? 'x' : '.');
        }
        System.out.println();
      }
    }
    return res;
  }


  public static int minEditDistanceLevenshtain(String one, String two) {
    int length1 = one.length();
    int length2 = two.length();
    if (length1 == 0 || length2 == 0) return Math.max(length1, length2);
    int[][] distances = new int[length1][length2];

    for (int i = 0; i < distances.length; i++) {
      for (int j = 0; j < distances[0].length; j++) {

      }
    }
    return distances[length1 - 1][length2 - 1];
  }

  /**
   * Implementation of Levenshtein's min edit  distance algorithm.
   * Returns number of edit operations(insert, delete, change)
   * for string one to make it string two.
   *
   * @param one
   * @param two
   * @return could be between 0 and max(one.length, two.length)
   */
  public static int minDistance(String one, String two) {
    int length1 = one.length();
    int length2 = two.length();
    if (length1 == 0 || length2 == 0) return Math.max(length1, length2);
    int[][] distances = new int[length1][length2];

    for (int i = 0; i < distances.length; i++) {
      for (int j = 0; j < distances[0].length; j++) {
        char c1 = one.charAt(i);
        char c2 = two.charAt(j);

        if (i == 0 && j == 0) {
          distances[i][j] = c1 == c2 ? 0 : 1;
        } else if (i == 0) {
          int dist = distances[i][j - 1];
          distances[i][j] = Math.min(dist + 1, c1 == c2 ? j : j + 1);
        } else if (j == 0) {
          int dist = distances[i - 1][j];
          distances[i][j] = Math.min(dist + 1, c1 == c2 ? i : i + 1);
        } else {
          int dial = c1 == c2 ? distances[i - 1][j - 1] : distances[i - 1][j - 1] + 1;
          int top = distances[i - 1][j] + 1;
          int left = distances[i][j - 1] + 1;
          distances[i][j] = Math.min(dial, Math.min(top, left));
        }
      }
    }
    return distances[length1 - 1][length2 - 1];
  }


  /**
   * Check if String match pattern.
   * Time and space complexity O(m * n).
   *
   * @param s any string
   * @param p pattern that can contains alphabetic characters or '.' or '*'.
   * @return boolean
   */
  public static boolean isMatch(String s, String p) {
    boolean result = true;
    if (s != null && p != null) {
      int slen = s.length();
      int plen = p.length();

      boolean[][] matches = new boolean[slen + 1][plen + 1];

      for (int i = 0; i < matches.length; i++) {
        for (int j = 0; j < matches[0].length; j++) {

          if (i == 0 && j == 0) {
            matches[i][j] = true;
          } else if (i == 0) {
            char cp = p.charAt(j - 1);
            matches[i][j] = cp == '*' && matches[i][j - 2];
          } else if (j == 0) {
            matches[i][j] = false;
          } else {

            char cs = s.charAt(i - 1);
            char cp = p.charAt(j - 1);

            if (cs == cp || cp == '.') {
              matches[i][j] = matches[i - 1][j - 1];
            } else if (cp == '*') {
              char cpp = p.charAt(j - 2);
              boolean isAlphabeticPrevPatterChar = cpp == cs || cpp == '.';
              boolean matchPrev = matches[i][j - 1]
                  || matches[i - 1][j - 1]
                  || matches[i - 1][j];
              matches[i][j] = matches[i][j - 2] || (isAlphabeticPrevPatterChar && matchPrev);
            } else {
              matches[i][j] = false;
            }
          }
        }
      }
      result = matches[slen][plen];
    }
    return result;
  }
}
