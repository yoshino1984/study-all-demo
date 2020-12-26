package basic.algorithm.sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @author wangxin
 * 2020/5/5 06:48
 * @since
 **/
public class CountingSort {

    public void sort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        int max = Arrays.stream(a).max().getAsInt();
        int[] c = new int[max + 1];
        for (int item : a) {
            c[item]++;
        }
        for (int i = 1; i <= max; i++) {
            c[i] += c[i - 1];
        }

        int[] temp = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            int index = c[a[i]] - 1;
            temp[index] = a[i];
            c[a[i]]--;
        }
        System.arraycopy(temp, 0, a, 0, a.length);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 1, 0, 10, 8, 9, 6, 5, 4, 7, 11, 1, 2};
        new CountingSort().sort(nums);
        System.out.println(JSON.toJSON(nums));
    }
}
