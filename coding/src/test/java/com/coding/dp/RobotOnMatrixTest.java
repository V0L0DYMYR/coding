package com.coding.dp;

import org.junit.Assert;
import org.junit.Test;

public class RobotOnMatrixTest {

    @Test
    public void nullTest() {
        int minPathMam = new RobotOnMatrix().minPathSum(null);
        Assert.assertEquals(-1, minPathMam);
    }

    @Test
    public void fullyEmptyArray() {
        int[][] matrix = {};
        int minPathMam = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(-1, minPathMam);
    }

    @Test
    public void innerEmptyArray() {
        int[][] matrix = {{}};
        int minPathMam = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(-1, minPathMam);
    }

    @Test
    public void twoInnerEmptyArrays() {
        int[][] matrix = {{}, {}};
        int minPathMam = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(-1, minPathMam);
    }

    @Test
    public void oneCellMatrix() {
        int[][] matrix = {{3}};
        int minPathMam = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(3, minPathMam);
    }

    @Test
    public void rawMatrix() {
        int[][] matrix = {{2, 3, 2, 1}};
        int minPathMam = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(8, minPathMam);
    }

    @Test
    public void columnMatrix() {
        int[][] matrix = {{2}, {4}, {3}, {1}};
        int minPathMam = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(10, minPathMam);
    }

    @Test
    public void simpleMatrix() {
        int[][] matrix = {
                {5, 3, 1, 1},
                {2, 1, 4, 1},
                {1, 4, 1, 2}
        };
        int minPathMam = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(13, minPathMam);
    }

    @Test
    public void maxIntegerValue() {
        int[][] matrix = {
                {2147483642, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        int minPathMam = new RobotOnMatrix().minPathSum(matrix);
        Assert.assertEquals(2147483647, minPathMam);
    }

}
