package io.sean.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sean on 10/22/15.
 */

public class MergeSort {

    public static <T extends Comparable<T>>
    void sort(T[] list) {
        if (list.length <= 1) return;
        int low = 0;
        int high = list.length - 1;
        // create a temp array to save sorted items
        T[] tmpArray = (T[]) Array.newInstance(Comparable.class, list.length);
        sort(list, tmpArray, low, high);
    }

    private static <T extends Comparable<T>>
    void sort(T[] list, T[] tmp, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;   // get the middle element
            sort(list, tmp, low, middle);    // sort left part
            sort(list, tmp, middle + 1, high); // sort right part
            merge(list, tmp, low, middle + 1, high); // merge then to list
        }
    }

    private static <T extends Comparable<T>>
    void merge(T[] list, T[] tmp, int low, int middle, int high) {
        int startPosition = low;
        int leftStart = low;
        int leftEnd = middle - 1;
        int rightStart = middle;
        int rightEnd = high;
        int numOfElement = high - low + 1;

        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (list[leftStart].compareTo(list[rightStart]) < 0) {
                tmp[startPosition++] = list[leftStart++];
            } else {
                tmp[startPosition++] = list[rightStart++];
            }
        }
        while (leftStart <= leftEnd) {
            tmp[startPosition++] = list[leftStart++];
        }
        while (rightStart <= rightEnd) {
            tmp[startPosition++] = list[rightStart++];
        }
        for (int i = 0; i < numOfElement; i++, rightEnd--) {
            list[rightEnd] = tmp[rightEnd];
        }

    }

}
