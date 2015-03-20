package com.coding.stacks;

import com.coding.base.Pair;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 */
public class Histogram {

  /**
   *
   * @param histogram
   * @return
   */
  public int largestRectangle(int[] histogram) {
    int max = 0, prev = Integer.MIN_VALUE;
    Deque<Pair<Integer, Integer>> stack = new LinkedList<>();

    if (histogram != null && histogram.length > 0) {

      for (int i = 0; i < histogram.length; i++) {
        int cur = histogram[i];
        if (prev < cur) {
          stack.push(Pair.of(i, cur));
        } else if (cur < prev) {
          max = calculateMax(max, stack, i, cur);
        }
        prev = cur;
      }
      max = calculateMax(max, stack, histogram.length, 0);
    }
    return max;
  }

  private int calculateMax(int max, Deque<Pair<Integer, Integer>> stack, int i, int cur) {
    int start = i;
    while (!stack.isEmpty() && stack.peek().getSecond() >= cur) {
      Pair<Integer, Integer> pair = stack.pop();
      start = pair.getFirst();
      int len = i - start;

      int s = len * pair.getSecond();
      max = Math.max(max, s);
    }
    stack.push(Pair.of(start, cur));
    return max;
  }
}
