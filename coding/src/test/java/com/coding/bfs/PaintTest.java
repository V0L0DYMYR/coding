package com.coding.bfs;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PaintTest {

  @Test
  public void simple() {
    int[][] matrix = {
        {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0,},
        {0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0,},
        {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0,},
        {0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0,},
        {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0,},
        {0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0,},
        {0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0,},
        {0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0,},
        {0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0,},
        {0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,},
    };

    int[][] expectedResult = {
        {0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0,},
        {0, 0, 1, 1, 1, 2, 1, 0, 0, 0, 0, 0,},
        {0, 0, 1, 2, 2, 2, 1, 0, 0, 0, 0, 0,},
        {0, 0, 1, 2, 1, 1, 1, 1, 1, 1, 0, 0,},
        {0, 0, 1, 2, 2, 2, 2, 2, 2, 1, 0, 0,},
        {0, 0, 1, 1, 2, 1, 1, 1, 2, 1, 0, 0,},
        {0, 1, 1, 1, 2, 1, 0, 1, 2, 1, 0, 0,},
        {0, 1, 2, 2, 2, 1, 0, 1, 2, 1, 0, 0,},
        {0, 1, 2, 1, 2, 1, 0, 1, 1, 1, 0, 0,},
        {0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,},
    };

    Paint.fill(matrix, 2, 8, 2);
    assertArrayEquals(expectedResult, matrix);
  }
}