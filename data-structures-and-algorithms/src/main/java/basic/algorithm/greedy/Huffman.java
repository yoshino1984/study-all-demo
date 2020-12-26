package basic.algorithm.greedy;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 霍夫曼编码
 *
 * @author wangxin
 * 2020/5/11 00:13
 * @since
 **/
public class Huffman {

    public Map<Character, String> genHuffmanCode(String str) {
        if (str.isBlank()) {
            return Collections.emptyMap();
        }
        Queue<Node> charSet = genSet(str);
        while (charSet.size() > 1) {
            Node left = charSet.poll();
            Node right = charSet.poll();
            Node newNode = new Node(left.item, left.count + right.count, false);
            newNode.leftChild = left;
            newNode.rightChild = right;
            charSet.add(newNode);
        }
        Node node = charSet.poll();
        Map<Character, String> ret = new LinkedHashMap<>();
        genCode(node, ret, "");
        return ret;
    }

    private void genCode(Node node, Map<Character, String> ret, String prefix) {
        if (node == null) {
            return;
        }
        if (node.isEndChar) {
            ret.put(node.item, prefix);
            return;
        }

        genCode(node.rightChild, ret, prefix + "1");
        genCode(node.leftChild, ret, prefix + "0");
    }


    public Queue<Node> genSet(String str) {
        Map<Character, AtomicInteger> charCountMap = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char item : chars) {
            charCountMap.computeIfAbsent(item, k -> new AtomicInteger()).incrementAndGet();
        }
        Queue<Node> charSet = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));
        charCountMap.forEach((k, v) -> charSet.add(new Node(k, v.get())));
        return charSet;
    }

    private class Node {
        private final char item;
        private final int count;
        private String code;
        private Node leftChild;
        private Node rightChild;
        private boolean isEndChar;

        public Node(Character item, int count) {
            this(item, count, true);
        }

        public Node(Character item, int count, boolean isEndChar) {
            this.item = item;
            this.count = count;
            this.isEndChar = isEndChar;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return item == node.item;
        }

        @Override
        public int hashCode() {
            return Objects.hash(item);
        }

    }

    public static void main(String[] args) {
        Huffman huffman = new Huffman();
        Map<Character, String> codes = huffman.genHuffmanCode("hsldfjsldjlfjsldjflsjdfljsdfhghsldjflsjd");
        System.out.println(JSON.toJSONString(codes));
    }

}
