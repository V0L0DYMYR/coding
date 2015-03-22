package com.coding.dp;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClosestSumTest {

  @Test
  public void sum3Test() {
    int[] num = {1, 2, 4, 8, 16, 32, 64, 128};
    assertThat(new ClosestSum().threeSumClosest(num, 82), is(82));
  }
}
