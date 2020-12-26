package basic.algorithm.binary.search;

import java.util.Arrays;

/**
 * 二分查找
 * @author wangxin
 * 2020/5/5 20:29
 * @since
 **/
public class BinarySearchMore {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 10, 2, 3, 3, 44, 44, 12, 0, 0, 99, 324};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(new BinarySearchMore().firstItemBinarySearch(nums, 3));
        System.out.println(new BinarySearchMore().firstItemBinarySearch(nums, 44));
        System.out.println(new BinarySearchMore().lastItemBinarySearch(nums, 3));
        System.out.println(new BinarySearchMore().lastItemBinarySearch(nums, 44));
        System.out.println(new BinarySearchMore().findFirstGreaterOrEqualBinarySearch(nums, 3));
        System.out.println(new BinarySearchMore().findFirstGreaterOrEqualBinarySearch(nums, 44));
        System.out.println(new BinarySearchMore().findFirstLessOrEqualBinarySearch(nums, 3));
        System.out.println(new BinarySearchMore().findFirstLessOrEqualBinarySearch(nums, 44));

    }

    /** 查找第一个值等于给定值的元素*/
    public int firstItemBinarySearch(int[] nums, int val) {
        return firstItemBinarySearch(nums, 0, nums.length - 1, val);
    }

    public int firstItemBinarySearch(int[] nums, int low, int high, int val) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] == val && (mid == 0 || nums[mid - 1] != val)) {
            return mid;
        } else if (nums[mid] < val){
            return firstItemBinarySearch(nums, mid + 1, high, val);
        } else {
            return firstItemBinarySearch(nums, low, mid - 1, val);
        }
    }

    /** 查找最后一个值等于给定值的元素*/
    public int lastItemBinarySearch(int[] nums, int val) {
        return lastItemBinarySearch(nums, 0, nums.length - 1, val);
    }

    private int lastItemBinarySearch(int[] nums, int low, int high, int val) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (nums[mid] < val) {
            low = mid + 1;
        } else if (nums[mid] > val) {
            high = mid - 1;
        } else {
            if (mid == nums.length - 1 || nums[mid + 1] != val) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return lastItemBinarySearch(nums, low, high, val);
    }

    public int findFirstGreaterOrEqualBinarySearch(int[] nums, int val) {
        return findFirstGreaterOrEqualBinarySearch(nums, 0, nums.length - 1, val);
    }

    private int findFirstGreaterOrEqualBinarySearch(int[] nums, int low, int high, int val) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (nums[mid] < val) {
            low = mid + 1;
        } else {
            if (mid == 0 || nums[mid - 1] < val) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return findFirstGreaterOrEqualBinarySearch(nums, low, high, val);
    }

    public int findFirstLessOrEqualBinarySearch(int[] nums, int val) {
        return findFirstLessOrEqualBinarySearch(nums, 0, nums.length - 1, val);
    }

    private int findFirstLessOrEqualBinarySearch(int[] nums, int low, int high, int val) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (nums[mid] > val) {
            high = mid - 1;
        } else {
            if (mid == nums.length - 1 || nums[mid + 1] > val) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return findFirstLessOrEqualBinarySearch(nums, low, high, val);
    }


}
