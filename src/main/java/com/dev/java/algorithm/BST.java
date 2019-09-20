package com.dev.java.algorithm;

import lombok.Data;

/**
 * @author: dengxin.chen
 * @date: 2019-09-17 10:51
 * @description: 二叉查找树
 */
public class BST {


    public static void main(String[] args) {
        BSTNode bstNode = init();
        BSTNode node = new BSTNode(9);

        BSTNode newNode = bstNode.insert(bstNode, node);
        new BSTNode().printNode(newNode);
    }

    public static BSTNode init() {
        BSTNode rootTmp = new BSTNode(9);
        BSTNode left = new BSTNode(8);
        BSTNode right = new BSTNode(10);

        BSTNode root = new BSTNode(9, left, right);
        root.setRoot(rootTmp);
        return root;
    }
}

@Data
class BSTNode {

    /**
     * 节点值
     */
    private Integer value;

    /**
     * 根节点
     */
    private BSTNode root;

    /**
     * 左子树
     */
    private BSTNode left;

    /**
     * 右子树
     */
    private BSTNode right;

    public BSTNode(Integer value) {
        this(value, null, null);
    }

    public BSTNode(Integer value, BSTNode left, BSTNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BSTNode() {

    }

    /**
     * 插入节点
     *
     * @param root
     * @param x
     * @return
     */
    public BSTNode insert(BSTNode root, BSTNode x) {
        if (root == null) {
            root = x;
        }
        if (x.value < root.value) {
            root.left = insert(root.left, x);
        } else if (x.value >root.value) {
            root.right = insert(root.right, x);
        }
        return root;
    }

    /**
     * 前序遍历打印二叉查找树
     *
     * @param node
     */
    public void printNode(BSTNode node) {
        if (node != null) {
            // 先打印根节点
            System.out.print(node.value);
            // 打印左子树
            printNode(node.left);
            // 打印右子树
            printNode(node.right);
        }

    }

}
