package com.coding.unionfind;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ShapeCounterTest {

  @Test
  public void startTest() {
    int[][] matrix = {
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0},
    };
    assertEquals(1, ShapeCounter.count(matrix));
  }

  @Test
  public void allShapesTest() {
    int[][] matrix = {
        {1, 1, 0, 0, 0, 0, 1, 0},
        {0, 1, 0, 0, 0, 0, 1, 1},
        {1, 0, 0, 1, 0, 0, 0, 1},
        {0, 0, 1, 1, 1, 0, 1, 1},
        {0, 0, 0, 1, 0, 0, 1, 0},
        {1, 0, 0, 0, 0, 0, 0, 0},
    };
    assertEquals(5, ShapeCounter.count(matrix));
  }

  @Test
  public void sides() {
    int[][] matrix = {
        {0, 1, 1, 1, 0},
        {1, 0, 0, 0, 1},
        {1, 0, 0, 0, 1},
        {1, 0, 0, 0, 1},
        {0, 1, 1, 1, 0},
    };
    assertEquals(4, ShapeCounter.count(matrix));
  }

  @Test
  public void circle() {
    int[][] matrix = {
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 1, 0},
        {0, 0, 0, 1, 1, 0, 1, 1},
        {0, 0, 0, 1, 0, 0, 0, 1},
        {0, 0, 0, 1, 1, 0, 1, 1},
        {0, 0, 0, 0, 1, 1, 1, 0},
    };
    assertEquals(1, ShapeCounter.count(matrix));
  }
}
