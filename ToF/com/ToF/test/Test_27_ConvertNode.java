package com.ToF.test;

/**
 * @Author:
 * @Description:
 * @params:
 * @Data: Created in  14:40 2018/8/9
 * @Modified By:
 */
public class Test_27_ConvertNode {
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static BinaryTreeNode convert(BinaryTreeNode root){
        BinaryTreeNode[] lastNode = new BinaryTreeNode[1]; //保存处理过程中的双向链表的尾节点
        convertNode(root,lastNode);

        //找到双向链表的头节点
        BinaryTreeNode head = lastNode[0];
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    private static void convertNode(BinaryTreeNode node, BinaryTreeNode[] lastNode) {
        if (node != null) {
            //有左子树先处理左子树
            if (node.left!=null) {
                convertNode(node.left,lastNode);
            }
            //将当前节点的前驱指向已经处理好的双向链表（由当前节点的左子树构成）的尾节点
            node.left = lastNode[0];

            //左子树转换成的双向链表不为空，设置尾节点的后继
            if (lastNode[0] != null) {
                lastNode[0].right = node;
            }
            //记录当前节点为尾节点
            lastNode[0] = node;

            //处理右子树
            if (node.right != null) {
                convertNode(node.right,lastNode);
            }
        }

    }
    public static void printList(BinaryTreeNode head){
        while (head != null) {
            System.out.print(head.value+" ->");
            head = head.right;
        }
        System.out.println("null");
    }
    public static void printTree(BinaryTreeNode root){
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value+" ->");
            printTree(root.right);
        }
    }

    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    private static void test01() {
        BinaryTreeNode node10 = new BinaryTreeNode();
        node10.value = 10;

        BinaryTreeNode node6 = new BinaryTreeNode();
        node6.value = 6;

        BinaryTreeNode node14 = new BinaryTreeNode();
        node14.value = 14;

        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.value = 4;

        BinaryTreeNode node8 = new BinaryTreeNode();
        node8.value = 8;

        BinaryTreeNode node12 = new BinaryTreeNode();
        node12.value = 12;

        BinaryTreeNode node16 = new BinaryTreeNode();
        node16.value = 16;

        node10.left = node6;
        node10.right = node14;

        node6.left = node4;
        node6.right = node8;

        node14.left = node12;
        node14.right = node16;

        System.out.print("Before convert: ");
        printTree(node10);
        System.out.println("null");
        BinaryTreeNode head = convert(node10);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();

    }

    public static void main(String[] args) {
        test01();
    }

}


