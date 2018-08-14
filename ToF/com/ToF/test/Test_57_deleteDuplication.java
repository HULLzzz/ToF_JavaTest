package com.ToF.test;


import sun.rmi.log.LogInputStream;

/**
 * @Author:
 * @Description:题目：在一个排序的链表中，如何删除重复的结点？
 * @params:
 * @Data: Created in  13:14 2018/8/12
 * @Modified By：
 */


public class Test_57_deleteDuplication {
    public static class ListNode{
        private int val;
         ListNode next;
        public ListNode(){}
        public ListNode(int val){this.val = val;}

        @Override
        public String toString() {
            return val+"";
        }
    }

    public static ListNode deleteDuplication(ListNode head){
        if (head == null) {
            return null;
        }
        //临时的头节点
        ListNode root = new ListNode();
        root.next = head;
        //前驱节点
        ListNode prev = root;
        //记录当前处理的节点
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                //找到下一个不同值的节点，注意其也有可能是重复的节点
                while (node.next != null && node.next.val == node.val) {
                    node = node.next;
                }
                //指向下一个节点 prev.next也有可能是重复的节点，所以Prevb不要移动到下一个节点
                prev.next = node.next;

            }else {
                prev.next = node;
                prev = prev.next;
            }
            node = node.next;
        }
        return root.next;
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head + "->");
            head = head.next;
        }
        System.out.println("null");
    }
    // 1->2->3->3->4->4->5
    private static void test01() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        print(result);
    }

    public static void main(String[] args) {
        test01();
    }


}
