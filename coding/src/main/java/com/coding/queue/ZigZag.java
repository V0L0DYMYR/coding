package com.coding.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ZigZag {
  /**
   * https://oj.leetcode.com/problems/zigzag-conversion/
   * @param s
   * @param nRows
   * @return
   */
  public String convert(String s, int nRows) {
    Queue<Queue<Integer>> q = new LinkedList<>();
    int len = nRows;
    len+= nRows -2 < 0 ? 0 : nRows -2;
    for (int i = 0; i < nRows; i++) {
      Queue<Integer> level = new LinkedList<>();
      level.add(i);
      if (i != 0 && i != len-1 && i+1 < s.length() && i != len-i) {
        level.add(len - i);
      }
      q.add(level);
    }
    StringBuilder buf = new StringBuilder();
    while(!q.isEmpty()) {
      Queue<Integer> level = q.poll();
      Integer index;

      while((index = level.poll()) < s.length()) {
        buf.append(s.charAt(index));
        index += len;
        level.add(index);
      }
    }
    return buf.toString();
  }
}
