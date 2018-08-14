package com.ToF.test;

import jdk.internal.org.objectweb.asm.tree.LdcInsnNode;

import java.util.List;
import java.util.Stack;

/**
 * @Author:
 * @Description:  输入链表的头节点，从尾到头打印链表
 * @params:
 * @Data: Created in  13:56 2018/8/6
 * @Modified By:
 */
public class Test_05_PrintLinkNode {
    //节点对象
    public static class ListNode{
        int val;
        ListNode next;
    }

    //从尾到头打印链表，用栈的方式

    public static void printListInverse(ListNode root){
        Stack<ListNode> stack = new Stack<>();
        while (root!=null){
            stack.push(root);
            root = root.next;
        }
        ListNode tmp;
        while (!stack.isEmpty()){
            tmp = stack.pop();
            System.out.println(tmp.val+" ");
        }
    }

    public static void printList(ListNode root){
        if (root!=null){
            printListInverse(root.next);
            System.out.println(root.val+" ");
        }
    }
    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.val = 1;
        root.next = new ListNode();
        root.next.val = 2;
        root.next.next = new ListNode();
        root.next.next.val = 3;
        root.next.next.next = new ListNode();
        root.next.next.next.val = 4;
        root.next.next.next.next = new ListNode();
        root.next.next.next.next.val = 5;

        printListInverse(root);
        System.out.println();
        printList(root);
    }


}
