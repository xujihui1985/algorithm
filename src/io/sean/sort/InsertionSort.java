package io.sean.sort;

/**
 * Created by sean on 10/22/15.
 */
public class InsertionSort {

    public static <T extends Comparable<T>>
    void sort(T[] list) {

        if (list.length <= 1) {
            return;
        }

        for (int i = 1; i < list.length; i++) {

            T itemToInsert = list[i];
            int j = i;
            while (j > 0 && (list[j - 1].compareTo(itemToInsert) > 0)) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = itemToInsert;
        }
    }
}
