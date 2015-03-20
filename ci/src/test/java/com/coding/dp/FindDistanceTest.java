package com.coding.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindDistanceTest {

  @Test
  public void quickTest() {
    int[] array = new int[]{1};
    assertEquals("0", 0, FindDistance.find(array));

    array = new int[] {1, 2, 1, 2, 2, 1, 1};
    assertEquals("1", 1, FindDistance.find(array));

    array = new int[] {1, 2, 2, 1, 2, 2, 2, 1, 2, 2, 1, 1, 2};
    assertEquals("3", 1, FindDistance.find(array));

    array = new int[] {1, 1, 1, 1};
    assertEquals("4", 1, FindDistance.find(array));

    array = new int[] {6, 5, 3, 3, 1, 1, 0, -6};
    assertEquals("5", 1, FindDistance.find(array));
  }

  @Test
  public void test2() {
    int[] array = new int[] { 2, 2, 3, 1 };
    assertEquals("2", 2, FindDistance.find(array));
  }

  @Test
  public void test3() {
    int[] array = new int[] { 1, 3, 2 };
    assertEquals( 2, FindDistance.find(array));
  }

  @Test
  public void test4() {
    int[] array = new int[] { 1, 2, 1, 2, 2, 1 };
    assertEquals( 2, FindDistance.find(array));
  }

  @Test
  public void hardTest() {
    int[] array = new int[] {2, 1, 4, 3, 7, 5, 7, 4, 9, 2, 51, 3, 2};
    assertEquals("4", 1, FindDistance.find(array));
  }

}
