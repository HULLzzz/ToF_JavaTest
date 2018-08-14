package com.ToF.test;


import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * @Author:
 * @Description:给出一个链表的头节点和需要删除的节点指针，在O（1）时间删除链表结点
 *              思路：将后一个元素的值赋值给需要删除的节点，再将后一个节点删除即可。
 * @params:
 * @Data: Created in  11:25 2018/8/7
 * @Modified By:
 */
public class Test_13_deleteNode {
    //链表节点
    public static class ListNode{
        int val ;
        ListNode next;
    }

    public static ListNode deleteNode(ListNode head,ListNode toBeDelete){
        if (head==null||toBeDelete==null){
            return head;
        }

        //删除的是头节点
        if (head==toBeDelete){
            return head.next;
        }

        //多个节点的情况下，如果删除的是最后一个元素
        if (toBeDelete.next==null){
            //找到待删除元素的前驱 时间O(N)
            ListNode tmp = head;
            while (tmp.next!=toBeDelete){
                tmp = tmp.next;
            }
            tmp.next = null;
        }

        //删除的是某个中间节点
        else {
            toBeDelete.val = toBeDelete.next.val;
            toBeDelete.next = toBeDelete.next.next;
        }

        return head;
    }

    //打印链表
    public static void printList(ListNode head){
        while (head!=null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("end");
    }

    public static void main(String[] args) {


        ListNode head = new ListNode();
        head.val = 1;

        head.next = new ListNode();
        head.next.val = 2;

        head.next.next = new ListNode();
        head.next.next.val = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.val = 4;

        ListNode middle = head.next.next.next.next = new ListNode();
        head.next.next.next.next.val = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.val= 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.val = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.val = 8;

        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.val = 9;

        head = deleteNode(head, null); // 删除的结点为空
        printList(head);
        ListNode node = new ListNode();
        node.val = 12;

        head = deleteNode(head, head); // 删除头结点
        printList(head);
        head = deleteNode(head, last); // 删除尾结点
        printList(head);
        head = deleteNode(head, middle); // 删除中间结点
        printList(head);

        head = deleteNode(head, node); // 删除的结点不在链表中
        printList(head);
    }

}
