package com.coding.dp;

public class FindDistance {

  public static int find(int[] array) {

    int distance = (array.length > 1) ? 1 : 0;

    if (array.length > 1) {
      int min1 = array[0], min2 = array[1],
          index1 = 0, index2 = 1;

      for (int i = 2; i < array.length; i++) {
        if (array[i] <= Math.min(min1, min2)) {
          if (min1 == min2) {
            if (index1 > index2) {
              index2 = index1;
              index1 = i;
              min1 = array[i];
            } else {
              index1 = index2;
              index2 = i;
              min2 = array[i];
            }

            if (min1 == min2) {
              distance = Math.min(distance, Math.abs(index1 - index2));
            } else {
              distance = Math.abs(index1 - index2);
            }


          } else if (min1 < min2) {
            min2 = array[i];
            index2 = i;
            distance = Math.abs(index1 - index2);
          } else {
            min1 = array[i];
            index1 = i;
            distance = Math.abs(index1 - index2);
          }
        } else if (array[i] < Math.max(min1, min2)) {
          if (min1 < min2) {
            index2 = i;
            min2 = array[i];
            distance = Math.abs(index1 - index2);
          } else {
            index1 = i;
            min1 = array[i];
            distance = Math.abs(index1 - index2);
          }
        }
      }
    }
    return distance;
  }
}