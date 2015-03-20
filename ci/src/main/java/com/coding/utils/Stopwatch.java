package com.coding.utils;

import java.util.concurrent.TimeUnit;

public class Stopwatch {
  private long startTime = System.nanoTime();

  public long getMillis() {
    return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 2, 3, 4, 4};
    int[] bits = new int[32];
    for (int num : arr) {
      for (int i = 0; i < bits.length; i++) {
        int oneBitNum = 1 << i;
        if ((num & oneBitNum) > 0) {
          bits[i] += 1;
        }
      }
    }
    int result = 0;
    for (int i = 0; i < bits.length; i++) {
      if (bits[i] % 2 == 1) {
        result |= 1 << i;
      }
    }
    System.out.println(result);
  }
}
