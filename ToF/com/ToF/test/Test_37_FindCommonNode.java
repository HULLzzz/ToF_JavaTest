package com.ToF.test;

import java.util.List;

/**
 * @Author:
 * @Description:题目：输入两个链表，找出它们的第一个公共结点。
 * @params:
 * @Data: Created in  17:00 2018/8/10
 * @Modified By:
 */
public class Test_37_FindCommonNode {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val+"";
        }
    }

    //找两个链表的公共节点
    public static ListNode findFirstCommonNode(ListNode head1,ListNode head2){
        int len1 = getListLength(head1);
        int len2 = getListLength(head2);

        int diff = len1 - len2;
        ListNode longListHead = head1;
        ListNode shortListHead = head2;

        if (diff < 0) {
            longListHead = head2;
            shortListHead = head1;
            diff = len2 - len1;
        }
        for (int i = 0 ;i<diff;i++){
            longListHead = longListHead.next;
        }
        while (longListHead != null && shortListHead != null && longListHead != shortListHead) {
            longListHead = longListHead.next;
            shortListHead = shortListHead.next;
        }
        return longListHead;
    }

    private static int getListLength(ListNode head) {
        int result = 0;
        while (head != null) {
            head = head.next;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        test1();
    }
    private static void test1() {
        // 第一个公共结点在链表中间
        // 1 - 2 - 3 \
        //            6 - 7
        //     4 - 5 /
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n6.next = n7;

        n4.next = n5;
        n5.next = n6;

        System.out.println(findFirstCommonNode(n1, n4)); // 6
    }


}
