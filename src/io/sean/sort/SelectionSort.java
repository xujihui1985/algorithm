package io.sean.sort;

/**
 * Created by sean on 10/22/15.
 */
public class SelectionSort {

    public static <T extends Comparable<T>>
    void sort(T[] list) {
        if (list.length <= 1) {
            return;
        }
        int minIndex;

        for (int i = 0; i < list.length - 1; i++) {
            minIndex = i;
            for(int j = i+1; j < list.length; j++) {
                if (list[j].compareTo(list[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                T tmp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = tmp;
            }

        }
    }
}
