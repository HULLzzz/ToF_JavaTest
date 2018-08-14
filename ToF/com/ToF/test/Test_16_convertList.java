package com.ToF.test;

/**
 * @Author:
 * @Description:定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 * @params:
 * @Data: Created in  9:40 2018/8/8
 * @Modified By:
 */
public class Test_16_convertList {
    //在单链表的表头临时接入一个节点，然后进行尾插入法反转单链表
    public static class ListNode{
        int value;
        ListNode next;
    }
    public static ListNode reverseList(ListNode head){
        ListNode root = new ListNode();
        //创建一个临时节点作为尾插法的逻辑头节点
        root.next = null;

        //记录下一个要处理的节点
        ListNode next;
        //当前的处理节点不为空
        while (head!=null){
            //记录下一个要处理的节点
            next = head.next;
            //当前节点的下一个节点指向逻辑头节点的下一个节点
            head.next = root.next;
            //逻辑头节点的下一个节点指向当前处理的节点
            root.next = head;

            //上面的操作完成了一个节点的头插

            head = next;
        }
        //逻辑头节点的下一个节点就是返回后的头节点
        return root.next;
    }

    //书上的方法：不使用逻辑头节点
    public static ListNode reverseList2(ListNode head){
        //记录反转后链表的头节点
        ListNode reverseHead = null;
        ListNode curr = head;
        //记录前驱节点，前驱节点开始为null，因为他是反转后的节点的下一个节点
        ListNode prev = null;
        ListNode next;

        //对链表进行尾插法操作
        while (curr!=null){
            //记录反转链表的头节点
            reverseHead = curr;
            //记录当前节点的下一个节点
            next = curr.next;
            //当前节点的下一个节点指向前驱节点，这样当前节点就插入到反转链表哦的头部
            curr.next = prev;
            //记录当前节点为前驱节点
            prev = curr;
            //当前节点移动到下一个节点
            curr = next;
        }
        return reverseHead;

    }

    public static void printList(ListNode head){
        while(head!=null){
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

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        printList(head);
        head = reverseList(head);
        printList(head);
//        head = reverseList2(head);
//        printList(head);

    }

}
