package basic.data.structure.trie.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Trie 树
 * 字符串的公共前缀，将重复的前缀合并在一起
 *
 * @author wangxin
 * 2020/5/10 17:28
 * @since
 **/
public class TrieTree {
    private TrieNode root = new TrieNode('/');

    /**
     * 插入字符串
     * @param text
     */
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            if (p.childMap.containsKey(text[i])) {
                p = p.childMap.get(text[i]);
            } else {
                TrieNode newNode = new TrieNode(text[i]);
                p.childMap.put(text[i], newNode);
                p = newNode;
            }
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; i++) {
            if (p.childMap.containsKey(pattern[i])) {
                p = p.childMap.get(pattern[i]);
            } else {
                return false;
            }
        }
        System.out.println("find");
        return p.isEndingChar;
    }


    public class TrieNode {
        private char data;
        private Map<Character, TrieNode> childMap;
        private boolean isEndingChar;

        public TrieNode(char data) {
            this.data = data;
            this.childMap = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        TrieTree trie = new TrieTree();
        trie.insert("dasdf".toCharArray());
        trie.insert("how".toCharArray());
        trie.insert("hello".toCharArray());

        System.out.println(trie.find("ho".toCharArray()));
        System.out.println(trie.find("how".toCharArray()));
        System.out.println(trie.find("hw".toCharArray()));
    }
}
