package basic.data.structure.binary.tree;

import com.sun.source.tree.Tree;

/**
 * 二叉查找树（完全二叉树 链表实现）
 * 当前实现没有对相等节点做处理（可以考虑将相等节点扩展为链表存储在相同节点 或者将相等节点存储在右节点，并且修改查找和删除逻辑（增加右子树遍历））
 * 左子树中的么个节点的值，都要小于这个节点的值
 * （ps:平衡二叉查找树：时间复杂度比较稳定的二叉查找树 比如红黑树（非严格定义的）、完全二叉查找树）
 *
 * @author wangxin
 * 2020/5/7 23:05
 * @since
 **/
public class BinarySearchTree {
    private Node tree;

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (p.data == data) {
                return p;
            } else if (p.data < data){
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data) {
        // p指向要删除的节点，初始为根节点
        Node p = tree;
        // 要删除节点的父节点
        Node pp = null;

        while (p != null) {
            if (p.data == data) {
                break;
            } else if (p.data < data){
                pp = p;
                p = p.right;
            } else {
                pp = p;
                p = p.left;
            }
        }

        if (p == null) {
            System.out.println("没有找到对应节点");
            return;
        }

        if (p.left != null && p.right != null) {
            Node minP = p.right;
            Node minPp = p;
            while (minP.left != null) {
                minPp = minP;
                minP = minP.left;
            }
            // 交换两个节点数据（因为数据）
            p.data = minP.data;
            p = minP;
            pp = minPp;
        }

        Node child = null;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        }

        if (pp == null) {
            // 删除的是根节点
            tree = child;
        } else if (pp.left == p){
            pp.left = child;
        } else {
            pp.right = child;
        }

    }

    public int getHeight() {
        return getHeight(tree) + 1;
    }

    private int getHeight(Node node) {
        if (node == null) {
            return -1;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(1);
        tree.insert(1);
        tree.insert(1);
        System.out.println(tree.find(0));
        System.out.println(tree.find(1));
        System.out.println(tree.getHeight());
    }
}
