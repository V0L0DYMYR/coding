package com.coding.dp;

public class Stocks {
  public int maxProfit(int[] prices, int k) {
    if (prices == null || prices.length == 0)
      return 0;

    int[] local = new int[k+1];
    int[] global = new int[k+1];

    for (int i = 0; i < prices.length - 1; i++) {
      int diff = prices[i + 1] - prices[i];

      for (int j = k; j >= 1; j--) {
        local[j] = Math.max(global[j - 1] + (diff > 0 ? diff : 0), local[j] + diff);
        global[j] = Math.max(local[j], global[j]);

      }
      //System.out.print(global[i] + " | ");
    }

    return global[k];
  }
}
