package basic.data.structure.skiplist;

import basic.data.structure.skiplist.sample.SkipList;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 跳表实现
 *
 * @author wangxin
 * 2020/5/6 22:33
 * @since
 **/
public class MySkipList {

    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;
    /**
     * 链表头部
     */
    private Node head = new Node();

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        int level = randomLevel();
        level = Math.min(level, levelCount + 1);
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node[] update = new Node[level];
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }

        // 记录每一层插入位置前的节点
        Node p = head;
        for (int i = level - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        for (int i = 0; i < level; i++) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        if (levelCount < level) {
            levelCount = level;
        }
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;

        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            // 找到各层的前一节点
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; i--) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }

        while (levelCount > 1 && head.forwards[levelCount] == null) {
            levelCount--;
        }
    }

    /**
     * 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
     *     // 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
     *     // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
     *     //        50%的概率返回 1
     *     //        25%的概率返回 2
     *     //      12.5%的概率返回 3 ...
     * @return
     */
    private int randomLevel() {
        int level = 1;

        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL) {
            level += 1;
        }

        return level;
    }

    /**
     * 跳表的节点，每个节点记录了当前节点数据和所在层数数据
     */
    public class Node {
        private int data = -1;
        /**
         * 表示当前节点在各个层的下一个节点
         */
        private Node forwards[];

        private int maxLevel = 0;

        public Node() {
            this(MAX_LEVEL);
        }

        public Node(int level) {
            forwards = new Node[level];
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        MySkipList skipList = new MySkipList();
        skipList.insert(1);
        int[] count = new int[17];
        IntStream.rangeClosed(1, 100000).forEach(i -> count[skipList.randomLevel()]++);
        System.out.println(Arrays.toString(count));
    }


}
