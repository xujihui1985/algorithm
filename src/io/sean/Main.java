package io.sean;

import io.sean.sort.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] list = new Integer[]{1, 12, 5, 26, 7, 14, 8, 3, 7, 2};
        SelectionSort.sort(list);
        //InsertionSort.sort(list);
        //MergeSort.sort(list);
        //QuickSortBetter.sort(list);
        print(list);
    }

    private static void print(Integer[] list) {
        System.out.print("[");
        Arrays.asList(list).stream().forEach((item) -> System.out.print(item + ","));
        System.out.print("]");
    }
}
