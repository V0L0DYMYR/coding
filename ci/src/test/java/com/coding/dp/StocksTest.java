package com.coding.dp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StocksTest {

  @Test
  public void maxProfit() {
    int[] prices = {3, 1, 2, 3, 0, 5, 1, 3};
    assertThat(new Stocks().maxProfit(prices, 1), is(5));
    assertThat(new Stocks().maxProfit(prices, 2), is(7));
    assertThat(new Stocks().maxProfit(prices, 3), is(9));
  }
}
