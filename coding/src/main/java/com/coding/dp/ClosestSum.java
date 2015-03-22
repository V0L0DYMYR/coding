package com.coding.dp;

import java.util.Arrays;

public class ClosestSum {

  public int threeSumClosest(int[] num, int target) {
    Arrays.sort(num);
    int len = num.length;
    int res = len > 0 ? num[0] : 0;
    res = len > 1 ? res + num[1] : res;
    res = len > 2 ? res + num[2] : res;

    for (int i = 0; i < len - 2; i++) {
      int s = i+1, e = len-1;

      while (s < e) {
        int sum = num[i] + num[s] + num[e];
        if (Math.abs(target- sum) < Math.abs(target-res)) {
          res = sum;
        }
        if (target - sum < 0) {
          e--;
        } else {
          s++;
        }
      }
    }
    return res;
  }
}

