package basic.data.structure.heap;

import java.util.Arrays;

import static basic.data.structure.heap.ArrayHeap.swap;

/**
 * 堆排序：建堆和排序
 *
 * @author wangxin
 * 2020/5/9 08:38
 * @since
 **/
public class HeapSort {
//    /**
//     * 堆排序：建堆和排序 从1开始的数组排序
//     * @param items
//     */
//    public static void sort(int[] items) {
//        buildHeap(items);
//        sortHeap(items);
//    }
//
//    private static void sortHeap(int[] items) {
//        int k = items.length - 1;
//        while (k > 1) {
//            swap(items, k, 1);
//            k--;
//            heapify(items, k, 1);
//        }
//    }
//
//    private static void buildHeap(int[] items) {
//        int n = items.length - 1;
//        for (int i = n / 2; i > 0; i--) {
//            heapify(items, items.length - 1, i);
//        }
//    }

    public static void main(String[] args) {
        int[] items = new int[] {-1, 4, 2, 1, 1, 3, 3, 5, 6, 5};
        sort(items);
        System.out.println(Arrays.toString(items));
    }

    /**
     * 堆排序 = 建堆+排序 从0开始的数组排序
     * 时间复杂度 O(NlogN) = 建堆 O(N) 排序 O(logN)
     * @param items
     */
    private static void sort(int[] items) {
        buildHeap(items);
        sortHeap(items);
    }

    private static void sortHeap(int[] items) {
        int k = items.length - 1;
        while (k > 0) {
            swap(items, k, 0);
            k--;
            heapify(items, k, 0);
        }
    }

    private static void buildHeap(int[] items) {
        int i = (items.length - 1) / 2;
        int maxIndex = items.length - 1;
        for (; i >= 0; i--) {
            heapify(items, maxIndex, i);
        }
    }

    private static void heapify(int[] items, int maxIndex, int index) {
        while (true) {
            int maxPos = index;
            if ((index * 2 + 1) <= maxIndex && items[index * 2 + 1] > items[index]) {
                maxPos = index * 2 + 1;
            }
            if ((index * 2 + 2) <= maxIndex && items[index * 2 + 2] > items[maxPos]) {
                maxPos = index * 2 + 2;
            }
            if (maxPos == index) {
                break;
            }
            swap(items, maxPos, index);
            index = maxPos;
        }
    }

}
