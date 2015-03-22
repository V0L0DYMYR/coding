package com.coding.dp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PaintRegions {

  public char[][] paint(char[][] board) {
    boolean[][] visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        Point point = Point.of(i, j);
        if (board[i][j] == 'O' && !visited[point.i][point.j]) {
          findAndFillRegion(board, point, visited);
        }
      }
    }
    return board;
  }

  void findAndFillRegion(char[][] board, Point point, boolean[][] visited) {
    boolean isRegion = true;
    int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    HashSet<Point> region = new HashSet<>();
    Queue<Point> border = new LinkedList<>();
    border.add(point);


    while (!border.isEmpty()) {

      Point p = border.poll();
      region.add(p);
      visited[p.i][p.j] = true;

      for (int i = 0; i < deltas.length; i++) {
        Point next = Point.of(p.i + deltas[i][0], p.j + deltas[i][1]);

        if (next.i >= 0 && next.i < board.length
            && next.j >= 0 && next.j < board[0].length) {

          if (!visited[next.i][next.j]) {
            if (board[next.i][next.j] == 'O') {
              border.add(next);
            }
            visited[next.i][next.j] = true;
          }
          visited[next.i][next.j] = true;
        } else {
          isRegion = false;
        }
      }
    }

    if (isRegion) {
      for (Point p : region) {
        board[p.i][p.j] = 'X';
      }
    }
  }

  static void print(Set<Point> points) {
    for (int i = 0; i < 20; i++) {
      for (int j = 0; j < 20; j++) {
        Point p = Point.of(i, j);
        if (points.contains(p)) {
          System.out.print('x');
        } else {
          System.out.print('.');
        }
      }
      System.out.println();
    }
  }

  static class Point {
    int i, j;

    public static Point of(int x, int y) {
      Point p = new Point();
      p.i = x;
      p.j = y;
      return p;
    }

    public int hashCode() {
      return i * 10001 + j;
    }

    public boolean equals(Object o) {
      Point other = (Point) o;
      return other.i == this.i && other.j == this.j;
    }

    public String toString() {
      return String.format("[%d, %d]", i, j);
    }
  }
}
