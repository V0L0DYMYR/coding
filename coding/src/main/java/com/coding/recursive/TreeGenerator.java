package com.coding.recursive;

import com.coding.utils.Stopwatch;

import java.util.*;

public class TreeGenerator {
  Object[][] subRes;

  public List<TreeNode> generateTrees(int n) {
    subRes = new Object[n+1][n+1];
    Set<TreeNode> res = generateTrees(1, n);
    if (res.size() > 1) {
      res.remove(null);
      res = (Set<TreeNode>)subRes[1][n];
    } else {

    }

    return new ArrayList<TreeNode>(res);
  }

  public Set<TreeNode> generateTrees(int s, int n) {
    Set<TreeNode> res = new HashSet<>();
    res.add(null);
    if (s <= n) {
      if (subRes[s][n] != null) {
        return (Set<TreeNode>)subRes[s][n];
      }
      int nodeNumber = n - s+1;
      Map<String, TreeNode> resMap = new HashMap<>();

      for (int i = s; i <= n; i++) {
        Set<TreeNode> lefts = generateTrees(s, i - 1);

        Set<TreeNode> rights = generateTrees(i + 1, n);

        for (TreeNode left : lefts) {

          for (TreeNode right : rights) {
            TreeNode root = new TreeNode(i);
            root.left = left;
            root.right = right;

            boolean rightNull = right == null;
            boolean leftNull = left == null;

            if (rightNull && leftNull ) {
              if (nodeNumber == 1) {
                resMap.put(toString(root), root);
              }
            } else if (!rightNull && !leftNull) {
                resMap.put(toString(root), root);
            } else {

            }
          }
        }
      }
      res.addAll(resMap.values());
      subRes[s][n] = res;
    }

    return res;
  }

  public static String toString(TreeNode treeNode) {
    StringBuilder buf = new StringBuilder().append('[');
    Queue<TreeNode> q = new LinkedList<>();
    q.add(treeNode);
    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      if (node != null) {
        buf.append(node.val);
        q.add(node.left);
        q.add(node.right);
      } else {
        buf.append('#');
      }
      buf.append(", ");
    }
    return buf.append(']').toString();
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
      left = null;
      right = null;
    }

    public String toString() {
      StringBuilder buf = new StringBuilder().append('[');
      Queue<TreeNode> q = new LinkedList<>();
      q.add(this);
      while (!q.isEmpty()) {
        TreeNode node = q.poll();
        if (node != null) {
          buf.append(node.val);
          q.add(node.left);
          q.add(node.right);
        } else {
          buf.append('#');
        }
        buf.append(", ");
      }
      return buf.append(']').toString();
    }
  }

  public static void main(String[] args) {
    Stopwatch stopwatch = new Stopwatch();
    TreeGenerator treeGenerator = new TreeGenerator();
    List<TreeNode> treeNodes = treeGenerator.generateTrees(3);
    long millis = stopwatch.getMillis();
    for (TreeNode node : treeNodes) {
      System.out.println(toString(node));
    }
    System.out.println("time : " + millis);
  }
}
