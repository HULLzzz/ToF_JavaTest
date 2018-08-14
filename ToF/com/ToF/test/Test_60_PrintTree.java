package com.ToF.test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author:
 * @Description:题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印一行。
 * @params:
 * @Data: Created in  11:17 2018/8/12
 * @Modified By:
 */
public class Test_60_PrintTree {

    private static class BinaryTreeNode{
        private int val;
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        public BinaryTreeNode(){}
        public BinaryTreeNode(int val){this.val = val;}

        @Override
        public String toString() {
            return val + "";
        }
    }

    public static void print(BinaryTreeNode root){
        if (root == null) {
            return ;
        }
        List<BinaryTreeNode> list = new LinkedList<>();
        BinaryTreeNode node;
        //当前层数的节点个数
        int current = 1;
        //下一层的节点个数
        int next = 0;
        list.add(root);
        while (list.size() > 0) {
            node = list.remove(0);
            current--;
            System.out.printf("%-3d",node.val);

            if (node.left != null) {
                list.add(node.left);
                next++;
            }
            if (node.right != null) {
                list.add(node.right);
                next++;
            }
            if (current == 0) {
                System.out.println();
                current = next;
                next = 0;
            }
        }

    }
}
