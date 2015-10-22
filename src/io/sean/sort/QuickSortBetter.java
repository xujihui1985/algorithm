package io.sean.sort;

/**
 * Created by sean on 10/22/15.
 */
public class QuickSortBetter {

    public static <T extends Comparable<T>>
    void sort(T[] list) {
        if (list.length <= 1) return;
        sort(list, 0, list.length - 1);
    }

    private static <T extends  Comparable<T>>
    void swap(T[] list, int left, int right) {
        T tmp = list[left];
        list[left] = list[right];
        list[right] = tmp;
    }

    private static <T extends Comparable<T>>
    T getPrivot(T[] list, int low, int high) {
        int middle = (high + low) / 2;
        if (list[low].compareTo(list[middle]) > 0) {
            swap(list,low, middle);
        }
        if (list[low].compareTo(list[high]) > 0) {
            swap(list,low, high);
        }
        if (list[middle].compareTo(list[high]) > 0) {
            swap(list,middle, high);
        }
        // move the privot to last - 1 position,
        // because the last element is greater then the privot
        // so it's already sorted
        swap(list, middle, high - 1);
        return list[high-1];
    }

    private static <T extends Comparable<T>>
    void sort(T[] list, int low, int high) {
        if (low >= high) {
            return;
        }
        // consider use quick sort if length of list is less then 20
        T pivot = getPrivot(list, low, high);
        // in getPrivot, the list has already sorted base on privot
        // that means the left most element must less then privot
        // and the right most element must greater then privot
        // so we start from low+1 and high -2
        int left = low;
        int right = high - 2;

        // start to move from left to right if left element is less then privot
        for (;;) {
            while (list[left].compareTo(pivot) < 0) {
                left++;
            }
            while (list[right].compareTo(pivot) > 0) {
                right--;
            }
            if(left > right) {
                break;
            }
            T tmp = list[left];
            list[left] = list[right];
            list[right] = tmp;
            left++;
            right--;
        }
        // restore pivot
        T tmp = list[left];
        list[left] = pivot;
        list[high - 1] = tmp;

        sort(list, low, left-2);
        sort(list, left+1, high);
    }
}
