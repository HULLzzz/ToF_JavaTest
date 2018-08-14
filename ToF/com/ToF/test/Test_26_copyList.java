package com.ToF.test;

/**
 * @Author:
 * @Description:题目：请实现函数ComplexListNode clone(ComplexListNode head),复制一个复杂链表。
 *                   在复杂链表中，每个结点除了有一个next 域指向下一个结点外，还有一个sibling 指向链表中的任意结点或者null。
 * @params:
 * @Data: Created in  11:01 2018/8/9
 * @Modified By:
 */
public class Test_26_copyList {
    public static class ComplexListNode{
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }

    public static ComplexListNode clone(ComplexListNode head){
        if (head == null) {
            return null;
        }
        //clone 节点
        cloneNodes(head);
        //连接sibling字段
        connectNodes(head);
        //将整个链表拆分，返回复制链表的头节点
        return reconnectNodes(head);
    }
    public static void printList(ComplexListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    /**
     * 判断两个链表是否是同一个链表，不是值相同
     *
     * @param h1 链表头1
     * @param h2 链表头2
     * @return true：两个链表是同一个链表，false：不是
     */
    public static boolean isSame(ComplexListNode h1, ComplexListNode h2) {
        while (h1 != null && h2 != null) {
            if (h1 == h2) {
                h1 = h1.next;
                h2 = h2.next;
            } else {
                return false;
            }
        }

        return h1 == null && h2 == null;
    }

    private static ComplexListNode reconnectNodes(ComplexListNode head) {
        if (head == null) {
            return null;
        }
        //记录复制链表的头节点
        ComplexListNode newHead = head.next;
        //记录当前处理的复制节点
        ComplexListNode pointer = newHead;
        //被复制节点的next指向下一个被复制的节点
        head.next = newHead.next;
        head = head.next;
        while (head != null) {
            pointer.next = head.next;
            pointer = pointer.next;
            head.next = pointer.next;
            head = pointer.next;
        }
        return newHead;

    }

    private static void connectNodes(ComplexListNode head) {
        while (head != null) {
            if (head.sibling != null) {
                head.next.sibling = head.sibling.next;
            }
            head = head.next.next;
        }
    }

    private static void cloneNodes(ComplexListNode head) {
        while (head != null) {
            ComplexListNode tmp = new ComplexListNode();
            //为了区分复制链表将值都+100
            tmp.value = head.value+100;
            tmp.next = head.next;
            head.next = tmp;
            head = tmp.next;
        }

    }

    public static void main(String[] args) {
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //  |       |      /|\             /|\
        //  --------+--------               |
        //          -------------------------
        ComplexListNode head = new ComplexListNode();
        head.value = 1;
        head.next = new ComplexListNode();
        head.next.value = 2;
        head.next.next = new ComplexListNode();
        head.next.next.value = 3;
        head.next.next.next = new ComplexListNode();
        head.next.next.next.value = 4;
        head.next.next.next.next = new ComplexListNode();
        head.next.next.next.next.value = 5;

        head.sibling = head.next.next;
        head.next.sibling = head.next.next.next.next.next;
        head.next.next.next.sibling = head.next;

        ComplexListNode tmp = head;
        printList(head);
        ComplexListNode newHead = clone(head);
        printList(head);
        System.out.println(isSame(head, tmp));
        printList(newHead);
        System.out.println(isSame(head, newHead));
    }
}
