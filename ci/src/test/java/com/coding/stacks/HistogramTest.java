package com.coding.stacks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HistogramTest {

  @Test
  public void largestRectangleTest() {
    int[] histogram = {2, 1, 5, 6, 2, 3};
    //assertThat(new Histogram().largestRectangle(histogram), is(10));

    histogram = new int[]{1, 1};
    //assertThat(new Histogram().largestRectangle(histogram), is(2));

    histogram = new int[]{5,5,1,7,1,1,5,2,7,6};
    assertThat(new Histogram().largestRectangle(histogram), is(12));
  }
}
