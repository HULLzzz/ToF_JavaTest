package com.ToF.test;

import java.util.LinkedList;

/**
 * @Author:
 * @Description:  题目：链表中包含环，如何找到环的入口节点
 *                思路： 用两个指针来解决这类问题
 *                     先定义两个指针都指向链表的头节点，链表环有n个节点，让第二个指针先移动n步
 *                     两个指针以相同的速度进行移动的时候，当第二个指针指向入口节点的时候，第一个指针已经围绕环走了一圈并指向入口节点了
 *                     本题的关键在于如何得到环的节点数目：定义两个节点，一快一慢的速度进行移动,快指针比慢指针多走一步，两个指针相遇的时候，快指针比慢指针要多走n步，也就是说慢指针走过的步数就是环的节点的个数
 *                     如果两个指针能相遇，则链表中存在环，从当前节点出发，一边移动一边计数，当再次回到原节点的是时候，计数值就是环中节点的个数
 * @params:
 * @Data: Created in  17:49 2018/7/31
 * @Modified By:
 */
public class Test_56_FindMeetingNode {
    //定义节点
    private static class ListNode{
        private int val ;
        private ListNode next;

        public ListNode(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return val+"";
        }
    }

    public static ListNode meetingNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow)
                break;
        }
        if (fast==null&&fast.next==null){
            return null; //链表中没有环
        }

        //fast重新指向第一个节点
        fast = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }
    public static void main(String[] args) {
        test01();
//        test02();
//        test03();
    }

    // 1->2->3->4->5->6
    private static void test01() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        System.out.println(meetingNode(n1));
    }

    // 1->2->3->4->5->6
    //       ^        |
    //       |        |
    //       +--------+
//    private static void test02() {
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        ListNode n6 = new ListNode(6);
//
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n3;
//
//        System.out.println(meetingNode(n1));
//    }

    // 1->2->3->4->5->6 <-+
    //                |   |
    //                +---+
//    private static void test03() {
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        ListNode n6 = new ListNode(6);
//
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n6;
//
//        System.out.println(meetingNode(n1));
//    }


}
