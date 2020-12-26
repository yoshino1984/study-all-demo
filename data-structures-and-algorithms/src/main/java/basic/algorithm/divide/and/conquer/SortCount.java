package basic.algorithm.divide.and.conquer;

/**
 * 求逆序度（在归并排序的基础上，进行计算逆序对）可以在合并的时候进行计算
 *
 * @author wangxin
 * 2020/5/11 22:29
 * @since
 **/
public class SortCount {
    private int num = 0;
    public int count(int[] nums) {
        num = 0;
        mergeSortCounting(nums, 0, nums.length - 1);
        return num;
    }

    private void mergeSortCounting(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSortCounting(nums, low, mid);
        mergeSortCounting(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int i1 = low, i2 = mid + 1, curIndex = 0;
        int[] temp = new int[high - low + 1];
        while (i1 <= mid && i2 <= high) {
            if (nums[i1] <= nums[i2]) {
                temp[curIndex++] = nums[i1++];
            } else {
                // 计算逆序对个数
                num += (mid - i1 + 1);
                temp[curIndex++] = nums[i2++];
            }
        }
        while (i1 <= mid) {
            temp[i1++] = nums[curIndex++];
        }
        while (i2 <= high) {
            temp[i2++] = nums[curIndex++];
        }
        System.arraycopy(temp, 0, nums, low, temp.length);
    }
}
