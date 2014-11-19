package com.coding.interview.dijkstra;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Problem: Given a robot on a matrix.
 * At the beginning robot settled down at top-left cell of matrix.
 * He can move and visit <b>any</b> out of 4 neighbor cell (top, right, bottom, left).
 * Robot spends some energy each time he visit cell.
 * You need to find path to bottom-left cell spending min total energy.
 */
public class RobotOnMatrix {

    public int minPathSum(int[][] matrix) {
        int res = -1;
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int height = matrix.length;
            int width = matrix[0].length;

            Queue<Cell> q = new PriorityQueue<>();
            Set<Cell> visited = new HashSet<>();

            Cell cur = Cell.create(0, 0, matrix[0][0]);
            Cell target = Cell.create(height - 1, width - 1);

            while (!cur.equals(target)) {
                visited.add(cur);
                q.addAll(neighbors(cur, matrix, visited));
                cur = q.poll();
            }
            res = cur.cost;
        }
        return res;
    }

    private Set<Cell> neighbors(Cell cur, int[][] matrix, Set<Cell> visited) {
        int[][] deltas = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Set<Cell> result = new HashSet<>();
        for (int[] delta : deltas) {
            int newI = cur.i + delta[0];
            int newJ = cur.j + delta[1];
            if (newI >= 0 && newI < matrix.length && newJ >= 0 && newJ < matrix[0].length) {
                Cell cell = Cell.create(newI, newJ, cur.cost + matrix[newI][newJ]);
                if (!visited.contains(cell)) {
                    result.add(cell);
                }
            }
        }
        return result;
    }

    private static class Cell implements Comparable<Cell> {

        private final int cost;
        private final int i;
        private final int j;

        public Cell(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }

        public static Cell create(int i, int j) {
            return new Cell(i, j, 0);
        }

        public static Cell create(int i, int j, int cost) {
            return new Cell(i, j, cost);
        }

        @Override
        public int compareTo(Cell o) {
            return this.cost > o.cost ? 1 : -1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Cell cell = (Cell) o;

            if (i != cell.i) return false;
            if (j != cell.j) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }

        @Override
        public String toString() {
            return String.format("[%d, %d]:%d", i, j, cost);
        }
    }
}
