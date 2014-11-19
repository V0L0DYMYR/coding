package com.coding.interview.dijkstra;

import org.junit.Assert;
import org.junit.Test;

public class RobotOnMatrixTest {

    @Test
    public void nullTest() {
        int minPathSum = new RobotOnMatrix().minPathSum(null);
        Assert.assertEquals(-1, minPathSum);
    }

    @Test
    public void fullyEmptyArray() {
        int[][] matrix = {};
        int minPathSum = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(-1, minPathSum);
    }

    @Test
    public void innerEmptyArray() {
        int[][] matrix = {{}};
        int minPathSum = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(-1, minPathSum);
    }

    @Test
    public void twoInnerEmptyArrays() {
        int[][] matrix = {{}, {}};
        int minPathSum = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(-1, minPathSum);
    }

    @Test
    public void oneCellMatrix() {
        int[][] matrix = {{3}};
        int minPathSum = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(3, minPathSum);
    }

    @Test
    public void rawMatrix() {
        int[][] matrix = {{2, 3, 2, 1}};
        int minPathSum = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(8, minPathSum);
    }

    @Test
    public void columnMatrix() {
        int[][] matrix = {{2}, {4}, {3}, {1}};
        int minPathSum = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(10, minPathSum);
    }

    @Test
    public void simpleMatrix() {
        int[][] matrix = {
                {5, 3, 1, 1},
                {2, 1, 4, 1},
                {1, 4, 1, 2}
        };
        int minPathSum = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(13, minPathSum);
    }

    @Test
    public void snakeMatrixLeftRight() {
        int[][] matrix = {
                {1, 1, 1},
                {9, 9, 1},
                {1, 1, 1},
                {1, 9, 9},
                {1, 1, 1}
        };
        int minPathSum = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(11, minPathSum);
    }

    @Test
    public void snakeMatrixTopDown() {
        int[][] matrix = {
                {1, 9, 1, 1, 1},
                {1, 9, 1, 9, 1},
                {1, 1, 1, 9, 1}
        };
        int minPathSum = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(11, minPathSum);
    }

    @Test
    public void maxIntegerValue() {
        int[][] matrix = {
                {2147483642, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        int minPathSum = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(2147483647, minPathSum);
    }
}
