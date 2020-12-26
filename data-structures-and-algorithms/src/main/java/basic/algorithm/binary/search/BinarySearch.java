package basic.algorithm.binary.search;

import java.util.Arrays;

/**
 * 二分查找
 * @author wangxin
 * 2020/5/5 20:29
 * @since
 **/
public class BinarySearch {

    public static void main(String[] args) {
//        int[] nums = new int[] {1, 10, 2, 3, 3, 44, 12, 0, 99, 324};
//        Arrays.sort(nums);
//        System.out.println(new BinarySearch().simpleSearch(nums, 324));
        System.out.println(new BinarySearch().searchForSqrt(12, 6));
        System.out.println(Math.pow(3.464101, 2));

    }

    public int simpleSearch(int[] nums, int value) {
        return binarySearch(nums, 0, nums.length - 1, value);
    }

    private int binarySearch(int[] nums, int low, int high, int val) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] == val) {
            return mid;
        } else if (nums[mid] > val){
           return binarySearch(nums, low, mid - 1, val);
        } else {
            return binarySearch(nums, mid + 1, high, val);
        }
    }

    public double searchForSqrt(int num, int precisionBit) {
        double precision = Math.pow(10, - precisionBit);
        double low = 0, high = num;
        for (int i = 0; i < 1000; i++) {
            double mid = low + (high - low) / 2;
            if (Math.pow(mid, 2) <= num && Math.pow(mid + precision, 2) > num) {
                return mid;
            } else if (Math.pow(mid, 2) > num) {
                high = mid - precision;
            } else {
                low = mid + precision;
            }
        }
        return num;
    }

}
