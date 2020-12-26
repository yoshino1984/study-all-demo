package basic.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 冒泡排序
 * @author wangxin
 * 2020/5/3 21:54
 * @since
 **/
public class Sort {
    /** 冒泡排序*/
    public void bubbleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            boolean updateFlag = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                // 将最大值换到末尾去
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    updateFlag = true;
                }
            }
            if (!updateFlag) {
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /** 插入排序*/
    public void insertionSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > value) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
    }

    /** 选择排序
     * 不稳定排序，时间复杂度O(N^2)
     */
    public void selectionSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 1, 0, 10, 8, 9, 6, 5, 4, 7, 11, 1, 2};
//        new Sort().bubbleSort(nums);
//        new Sort().insertionSort(nums);
//        new Sort().selectionSort(nums);
//        new Sort().mergeSort(nums);
        new Sort().quickSort(nums);
        System.out.println(JSON.toJSON(nums));
        int[] nums2 = new int[] {1, 3, 5, 2, 4, 6, 9, 6, 5, 4, 7};
        merge(nums2, 0, 2, 6);
        System.out.println(JSON.toJSON(nums2));
    }

    /**
     * 归并排序
     * 稳定排序，时间复杂度O(NlogN)
     * 非原地排序
     */
    public void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = (end + begin - 1) / 2;
        mergeSort(nums, begin, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, begin, mid, end);
    }

    private static void merge(int[] nums, int begin, int mid, int end) {
        int[] tempNums = new int[end - begin + 1];
        int point1 = begin, point2 = mid + 1;
        int i;
        for (i = 0; i < tempNums.length; i++) {
            if (point1 > mid || point2 > end) {
                break;
            }
            if (nums[point1] <= nums[point2]) {
                tempNums[i] = nums[point1];
                point1++;
            } else {
                tempNums[i] = nums[point2];
                point2++;
            }
        }
        if (i < tempNums.length) {
            if (point1 <= mid) {
                System.arraycopy(nums, point1, tempNums, i, mid - point1 + 1);
            } else {
                System.arraycopy(nums, point2, tempNums, i, end - point2 + 1);
            }
        }
        System.arraycopy(tempNums, 0, nums, begin, tempNums.length);
    }


    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int q = partition(nums, low, high);
        quickSort(nums, low, q - 1);
        quickSort(nums, q + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = low;
        while (low < high) {
            while (low < high && nums[high] > nums[pivot]) {
                high--;
            }
            if (low < high && nums[high] <= nums[pivot]) {
                swap(nums, high, pivot);
                pivot = high;
            }

            while (low < high && nums[low] <= nums[pivot]) {
                low++;
            }
            if (low < high && nums[low] > nums[pivot]) {
                swap(nums, low, pivot);
                pivot = low;
            }
        }
        return pivot;
    }


}
