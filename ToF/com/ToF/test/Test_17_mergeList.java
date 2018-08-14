package com.ToF.test;

import sun.rmi.log.LogInputStream;

/**
 * @Author:
 * @Description:题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
 * @params:
 * @Data: Created in  11:23 2018/8/8
 * @Modified By:
 */
public class Test_17_mergeList {
    public static class ListNode{
        int value;
        ListNode next;
    }

    public static ListNode merge(ListNode head1,ListNode head2){
        if (head1==null){
            return head2;
        }
        if (head2==null){
            return head1;
        }

        //创建一个临时节点添加元素
        ListNode root = new ListNode();
        //用于指向合并后的新链表的尾节点
        ListNode pointer = root;

        //两个链表均不为空就进行合并操作
        while (head1!=null&&head2!=null){
            //下面的操作合并较小的元素
            if (head1.value<head2.value){
                pointer.next = head1;
                head1 = head2.next;
            }
            else {
                pointer.next = head2;
                head2 = head2.next;
            }
            //指针移动到合并后链表的末尾
            pointer = pointer.next;
        }
        //如果第一个链表没有处理完
        if (head1!=null){
            pointer.next = head1;
        }
        if (head2!=null){
            pointer.next = head2;
        }

        //返回处理结果
        return root.next;


    }


    //使用递归的方法，不推荐，递归调用的时候会有方法入栈，消耗更多内存
    public static ListNode merge2(ListNode head1,ListNode head2){
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        //记录两个链表中头部较小的节点
        ListNode tmp = head1;
        if (tmp.value<head2.value){
            tmp.next = merge2(head1.next,head2);
        }else {
            tmp = head2;
            tmp.next = merge2(head1,head2.next);
        }
        return tmp;

    }

    public static void printList(ListNode head){
        while (head!=null){
            System.out.print(head.value+"->");
            head = head.next;
        }
        System.out.println("null");
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


        ListNode head2 = new ListNode();
        head2.value = 1;

        head2.next = new ListNode();
        head2.next.value = 3;

        head2.next.next = new ListNode();
        head2.next.next.value = 5;

        head2.next.next.next = new ListNode();
        head2.next.next.next.value = 6;

        head2.next.next.next.next = new ListNode();
        head2.next.next.next.next.value = 7;

//        head = merge(head, head2);
        head = merge2(head, head2);
        printList(head);
    }
}
