package io.sean.sort;

/**
 * Created by sean on 10/21/15.
 */

//http://www.algolist.net/Algorithms/Sorting/Quicksort
public class Quicksort {

    private static <T extends Comparable<T>>
    int split(T[] list, int low, int high) {
        int left = low + 1;
        int right = high;
        T pivot = list[low];

        while (true) {
            while (left <= right) {
                if (list[left].compareTo(pivot) < 0) {
                    left++;
                } else {
                    break;
                }
            }
            while (right > left) {
                if (list[right].compareTo(pivot) < 0) {
                    break;
                } else {
                    right--;
                }
            }

            if (left >= right) {
                break;
            }

            // swap left and right

            T tmp = list[left];
            list[left] = list[right];
            list[right] = tmp;

            left++;
            right--;
        }

        // swap privot with left-1 position

        list[low] = list[left-1];
        list[left-1] = pivot;

        // return the split point

        return left-1;
    }

    private static <T extends Comparable<T>>
    void sort(T[] list, int low, int high) {
        if (high - low <= 0) { //fewer then 2
            return;
        }
        int splitPoint = split(list, low, high);
        sort(list, low, splitPoint - 1);
        sort(list, splitPoint + 1, high);
    }

    public static <T extends Comparable<T>>
    void sort(T[] list) {
        if (list.length <= 1) {
            return;
        }
        sort(list, 0, list.length - 1);
    }


}
