package com.ToF.test;

/**
 * @Author:
 * @Description:题目：输入一个链表，输出该链表中倒数第k 个结点．为了符合大多数人的习惯，本题从1 开始计数，即链表的尾结点是倒数第1 个结点．例如一个链表有6 个结点，从头结点开始它们的值依次是1 、2、3、4、5 、6。这个个链表的倒数第3 个结点是值为4 的结点．
 *              要点：注意代码的健壮性：输入空指针的时候，链表的长度小于k的时候等
 * @params:
 * @Data: Created in  14:01 2018/8/7
 * @Modified By:
 */
public class Test_15_FindKthToTail {
    public static class ListNode {
        int value;
        ListNode next;
    }
    public static ListNode findKthToTail(ListNode head,int k ){
        if (k < 1 || head == null) {
            return null;
        }
        //指向头节点
        ListNode pointer = head;
        //倒数第k个节点和倒数第一个节点相隔k-1个位置
        for (int i = 1;i<k;i++){
            //说明还有点
            if (pointer.next!=null){
                pointer = pointer.next;
            }
            //已经没有节点了但是i还没有到达k-1说明k太大
            else {
                return null;
            }
        }
        while (pointer.next!=null){
            head = head.next;
            pointer = pointer.next;
        }
        return head;

    }
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;

        head.next = new ListNode();
        head.next.value = 2;

        head.next.next = new ListNode();
        head.next.next.value = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;

        head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        System.out.println(findKthToTail(head, 1).value); // 倒数第一个
        System.out.println(findKthToTail(head, 5).value); // 中间的一个
        System.out.println(findKthToTail(head, 9).value); // 倒数最后一个就是顺数第一个

        System.out.println(findKthToTail(head, 10));
    }
}
