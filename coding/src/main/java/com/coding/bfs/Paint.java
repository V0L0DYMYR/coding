package com.coding.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Paint {
  public static void fill(int[][] matrix, int x, int y, int color) {

    if (matrix != null && matrix.length > 0 && y < matrix.length) {

      if (matrix[0].length > 0 && x < matrix[0].length) {

        int oldColor = matrix[y][x];
        Queue<Point> q = new LinkedList<>();
        Set<Point> visited = new HashSet<>();
        Point center = Point.at(x, y, oldColor);
        q.add(center);
        visited.add(center);

        while (!q.isEmpty()) {

          Point point = q.poll();

          Set<Point> neighbors = getNeighbors(point, matrix, visited);
          visited.addAll(neighbors);
          q.addAll(neighbors);

          matrix[point.y][point.x] = color;
        }
      }
    }
  }

  private static Set<Point> getNeighbors(Point point, int[][] matrix, Set<Point> visited) {
    Set<Point> result = new HashSet<>();
    int x = point.x;
    int y = point.y;

    int color = point.color;
    Point p = Point.at(x - 1, y, color);

    if (x > 0 && p.isColor(matrix[y][x - 1]) && !visited.contains(p)) {
      result.add(p);
    }

    p = Point.at(x + 1, y, color);
    if (x < matrix[0].length - 1 && p.isColor(matrix[y][x + 1]) && !visited.contains(p)) {
      result.add(p);
    }

    p = Point.at(x, y - 1, color);
    if (y > 0 && p.isColor(matrix[y - 1][x]) && !visited.contains(p)) {
      result.add(p);
    }

    p = Point.at(x, y + 1, color);
    if (y < matrix.length - 1 && p.isColor(matrix[y + 1][x]) && !visited.contains(p)) {
      result.add(p);
    }

    return result;
  }

  static class Point {
    int x;
    int y;
    int color;

    Point(int x, int y, int color) {
      this.x = x;
      this.y = y;
      this.color = color;
    }

    static Point at(int x, int y, int color) {
      return new Point(x, y, color);
    }

    public boolean isColor(int c) {
      return color == c;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Point point = (Point) o;

      if (x != point.x) return false;
      if (y != point.y) return false;

      return true;
    }

    @Override
    public int hashCode() {
      int result = x;
      result = 31 * result + y;
      return result;
    }
  }
}
