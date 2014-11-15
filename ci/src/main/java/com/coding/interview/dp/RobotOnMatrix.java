package com.coding.interview.dp;

public class RobotOnMatrix {
    public int minPathMam(int[][] matrix) {
        int res = -1;
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int height = matrix.length;
            int width = matrix[0].length;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i == 0 && j == 0) {
                        // just skip
                    } else if (i == 0) {
                        matrix[i][j] += matrix[i][j - 1];
                    } else if (j == 0) {
                        matrix[i][j] += matrix[i - 1][j];
                    } else {
                        int top = matrix[i - 1][j];
                        int left = matrix[i][j - 1];

                        int min = Math.min(top, left);
                        matrix[i][j] += min;
                    }
                }
            }
            res = matrix[height - 1][width - 1];
        }
        return res;
    }
}
