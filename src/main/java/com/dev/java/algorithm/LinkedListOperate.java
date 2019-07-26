package com.dev.java.algorithm;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author: dengxin.chen
 * @date: 2019-07-26 17:59
 * @description:链表操作
 */
public class LinkedListOperate {

    public static void main(String[] args) {
        Node list = createSimpleList();
        Node node = createNode(2);
        Node newNode = addNode(list, node);
        printList(newNode);
    }

    /**
     * 单链表翻转测试
     */
    private static void reverseTest() {
        Node list = createSimpleList();
        Node node = reverse(list);
        printList(node);
    }

    /**
     * 增加结点
     * 注：原list链表为有序链表
     *
     * @param list
     * @param node
     * @return
     */
    private static Node addNode(Node list, Node node) {
        if (list == null || node == null) {
            return null;
        }
        Node head = list;
        Node curr = head;
        if (head.getData() >= node.getData()) {
            node.setNext(head);
            return node;
        }
        boolean isAdd = false;
        while (curr.getNext() != null) {
            Node next = curr.getNext();
            // 插入next结点的后面
            if (next.getData() >= node.getData()) {
                node.setNext(next.getNext());
                next.setNext(node);
                isAdd = true;
                return head;
            }
            curr = next;
        }
        if (!isAdd) {
            curr.setNext(node);
        }
        return head;
    }

    /**
     * 单链表翻转
     *
     * @param list
     * @return
     */
    private static Node reverse(Node list) {
        if (list == null) {
            return null;
        }
        Node curr = list;
        // 记录前一个结点
        Node pre = null;
        while (curr != null) {
            // 记录下一个结点
            Node next = curr.getNext();
            // 将当前结点的下一个结点赋值为前一个结点
            curr.setNext(pre);
            // 将当前结点赋值给前一个结点 相当于移动结点
            pre = curr;
            // 将next结点赋值给当前结点，继续移动
            curr = next;
        }
        return pre;
    }


    /**
     * 创建单链表
     *
     * @return
     */
    private static Node createSimpleList() {
        Node head = createNode(1);
        Node first = createNode(2);
        Node second = createNode(3);
        Node third = createNode(4);
        head.setNext(first);
        first.setNext(second);
        second.setNext(third);
        return head;
    }

    /**
     * 测试链表基本方法
     */
    private static void testList() {
        Node simpleList = createSimpleList();
        printList(simpleList);
    }


    /**
     * 打印链表
     *
     * @param list
     */
    public static void printList(Node list) {
        if (list == null) {
            System.out.println("链表为空");
            return;
        }
        Node p = list;
        List<Integer> data = Lists.newArrayList();
        while (p != null) {
            data.add(p.getData());
            p = p.getNext();
        }
        if (CollectionUtils.isNotEmpty(data)) {
            String showList = Joiner.on("->").join(data);
            System.out.println(showList);
        }
    }

    /**
     * 创建结点
     *
     * @param value
     * @return
     */
    public static Node createNode(int value) {
        return new Node(value, null);
    }

}

class Node {
    private int data;
    private Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public int getData() {
        return data;
    }
}
