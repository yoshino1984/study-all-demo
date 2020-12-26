package basic.algorithm.dynamic.programming;

import java.util.Arrays;
import java.util.Objects;

/**
 * 01 背包问题，包含价值
 *
 * @author wangxin
 * 2020/5/12 23:59
 * @since
 **/
public class Knapsack {

    /**
     * knapsack3
     *
     * @param weight 每个物品所对应的价值
     * @param value 每个物品所对应的价值
     * @param n 物品数量
     * @param w 背包重量限制
     * @return int 最大价值
     * author: wangxin
     * date: 2020/5/13 00:00
     */
    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j] > 0) {
                    // 不选择某件物品时的状态转移
                    states[i][j] = states[i - 1][j];
                }
            }
            // 选择第i个物品
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        }
        // 找到最大值
        int maxValue = -1;
        for (int j = 0; j <= w; j++) {
            maxValue = Math.max(maxValue, states[n - 1][j]);
        }
        return maxValue;
    }

    /**
     * 状态转移方程 states[j + weight[i]] = Math.max(states[j] + value[i], states[j + weight[i]]);
     */
    public static int knapsack31(int[] weight, int[] value, int n, int w) {
        int[] states = new int[w + 1];
        Arrays.fill(states, -1);

        states[0] = 0;
        if (weight[0] <= w) {
            states[weight[0]] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = w - weight[i]; j >= 0; j--) {
                if (states[j] >= 0) {
                    states[j + weight[i]] = Math.max(states[j] + value[i], states[j + weight[i]]);
                }
            }
        }

        // 找到最大值
        int maxValue = -1;
        for (int j = 0; j <= w; j++) {
            maxValue = Math.max(maxValue, states[j]);
        }
        return maxValue;
    }



}
