package com.coding.unionfind;

public class ShapeCounter {

  public static int count(int[][] matrix) {
    int result = 0;

    if (matrix != null && matrix.length > 0) {
      int height = matrix.length;
      int width = matrix[0].length;
      int[] tree = new int[height * width + 1];

      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          int index = i * width + j + 1;

          if (matrix[i][j] == 1) {

            boolean single = true;

            boolean checkTop = i > 0 && matrix[i - 1][j] == 1;
            boolean checkBottom = i < height - 1 && matrix[i + 1][j] == 1;
            boolean checkRight = j < width - 1 && matrix[i][j + 1] == 1;
            boolean checkLeft = j > 0 && matrix[i][j - 1] == 1;

            if (checkTop) {
              int cellIndex = (i - 1) * width + j + 1;
              single &= checkNear(tree, index, cellIndex);
            }

            if (checkBottom) {
              int cellIndex = (i + 1) * width + j + 1;
              single &= checkNear(tree, index, cellIndex);
            }

            if (checkLeft) {
              int cellIndex = i * width + (j - 1) + 1;
              single &= checkNear(tree, index, cellIndex);
            }

            if (checkRight) {
              int cellIndex = i * width + (j + 1) + 1;
              single &= checkNear(tree, index, cellIndex);
            }

            if (single) {
              tree[index] = index;
              result++;
            }
          }
        }
      }
    }
    return result;
  }

  private static boolean checkNear(int[] tree, int index, int cellIndex) {
    boolean single = true;
    if (tree[cellIndex] == 0) {
      tree[cellIndex] = tree[index] == 0 ? index : tree[index];
    } else {
      int rootIndex = findRoot(tree, cellIndex);
      tree[index] = rootIndex;
      single = false;
    }
    return single;
  }

  private static int findRoot(int[] array, int cellIndex) {
    while (array[cellIndex] != cellIndex) {
      cellIndex = array[cellIndex];
    }
    return cellIndex;
  }
}
