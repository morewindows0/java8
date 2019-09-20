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
       /* Node list = createSimpleList();
        Node node = createNode(2);
        Node newNode = addNode(list, node);
        printList(newNode);*/
//        circleTest();
//        mergeTest();
//        deleteNodeTest();
        findMiddleTest();
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
     * 测试链表是否有环
     */
    private static void circleTest() {
        Node list = createSimpleList();

        System.out.println("是否有环：" + checkCircle(list));
    }

    /**
     * 链表合并测试
     */
    private static void mergeTest() {
        Node listOne = createSimpleList();
        Node listTwo = createSimpleList();
        Node node = mergeList(listOne, listTwo);
        printList(node);
    }

    /**
     * 结点删除测试
     */
    private static void deleteNodeTest() {
        Node list = createSimpleList();
        Node node = deleteLastKth(list, 5);
        printList(node);
    }

    /**
     * 寻找链表中间点
     */
    private static void findMiddleTest() {
        Node list = createSimpleList();
        Node node = findMiddleNode(list);
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
     * 检测链表中是否有环
     * 检查环的思想：通过两个指针：快慢指针，进行追击，如果快慢指针相遇则说明有环。
     *
     * @param list
     * @return true-有环  false-没有
     */
    private static boolean checkCircle(Node list) {
        if (list == null) {
            return false;
        }
        Node fast = list.getNext();
        Node slow = list;
        while (fast != null && slow != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 合并有序链表
     *
     * @param listOne
     * @param listTwo
     * @return
     */
    private static Node mergeList(Node listOne, Node listTwo) {
        Node soldier = new Node(0, null);
        Node p = soldier;
        /**
         * 循环链表1和链表2 对每个值进行连接
         */
        while (listOne != null && listTwo != null) {
            if (listOne.getData() < listTwo.getData()) {
                p.setNext(listOne);
                listOne = listOne.getNext();
            } else {
                p.setNext(listTwo);
                listTwo = listTwo.getNext();
            }
            // 注意这里需进行移动
            p = p.getNext();
        }
        // 如果链表1还有值，则直接拼接在后面
        if (listOne != null) {
            p.setNext(listOne);
        }
        // 如果链表2还有值，则直接拼接在后面
        if (listTwo != null) {
            p.setNext(listTwo);
        }
        return soldier.getNext();
    }

    /**
     * 删除倒数第K个结点 <br/>
     * 思路：用快慢两个指针，让快指针先走K步，然后慢指针开始走，直到快指针走到链表尾，则此时慢指针的下一个结点即为要删除的结点
     * 因为这样快慢指针之间相差的距离使用是K个距离，但是第K个还需慢指针向下移动一个位置
     *
     * @param list
     * @param k    个数
     * @return
     */
    private static Node deleteLastKth(Node list, int k) {
        if (k < 0) {
            return list;
        }
        // 快速指针，先走k个位置
        Node fast = list;
        Node slow = list;
        int i = 0;
        while (fast != null && i < k) {
            fast = fast.getNext();
            i++;
        }
        // 快指针走到底，则说明删除的就是第一个结点，前提是删除的位置有效
        if (fast == null) {
            return slow.getNext();
        }
        while (fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        slow.setNext(slow.getNext().getNext());
        return list;
    }

    /**
     * 求链表的中间结点
     * 思路：还是利用快慢指针，快指针一次走2步，慢指针一次走1步，当快指针到链表尾的时候，慢指针就处于中间
     *
     * @param list
     * @return
     */
    private static Node findMiddleNode(Node list) {
        if (list == null) {
            return null;
        }
        Node fast = list;
        Node slow = list;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
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
        Node four = createNode(5);
        head.setNext(first);
        first.setNext(second);
        second.setNext(third);
        third.setNext(four);
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
