package basic.data.structure.heap;


/**
 * 数组实现的堆(大顶堆）
 * @author wangxin
 * 2020/5/9 08:14
 * @since
 **/
public class ArrayHeap {

    private int[] elementDatas;
    /** 元素容量*/
    private int n;
    /** 已经存储的元素个数*/
    private int count;

    public ArrayHeap(int capacity) {
        this.elementDatas = new int[capacity];
        n = capacity;
        count = 0;
    }

    /**
     * 堆化
     * @param data
     */
    public void insert(int data) {
        if (count >= n) {
            return;
        }
        count++;
        elementDatas[count] = data;
        int i = count;
        while (i / 2 > 0 && elementDatas[i] > elementDatas[i / 2]) {
            swap(elementDatas, i, i / 2);
            i = i / 2;
        }
    }

    public void removeMax() {
        if (count == 0) {
            // 堆中没有元素
            return;
        }
        count--;
        heapify(elementDatas, count, 1);
    }

    /**
     * 自上向下堆化 O(logN)
     * @param elementDatas
     * @param n 当前堆化的范围
     * @param i 堆化的起点
     */
    public static void heapify(int[] elementDatas, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && elementDatas[i] < elementDatas[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && elementDatas[maxPos] < elementDatas[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(elementDatas, i, maxPos);
            i = maxPos;
        }
    }

    public static void swap(int[] elementDatas, int i, int j) {
        int temp = elementDatas[i];
        elementDatas[i] = elementDatas[j];
        elementDatas[j] = temp;
    }





}
