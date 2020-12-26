package basic.data.structure.binary.tree;

import java.util.Objects;

/**
 * 二叉树节点
 * @author wangxin
 * 2020/5/7 22:55
 * @since
 **/
public class BinaryTreeNode<T> {
    private T data;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    /**
     * 前序遍历
     * @param node
     */
    public void preOrder(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        }
        print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     * @param node
     */
    public void inOrder(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        print(node.data);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     * @param node
     */
    public void postOrder(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        print(node.data);
    }

    void print(T node) {
        System.out.println(node);
    }
}
