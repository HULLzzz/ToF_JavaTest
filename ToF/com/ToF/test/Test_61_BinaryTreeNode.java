package com.ToF.test;

import com.sun.org.apache.bcel.internal.generic.BIPUSH;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author:
 * @Description: 题目：实现一个函数，按照之字形打印二叉树，第一行从左到右打印，下一行从右向左打印
 *
 *               思路：需要两个栈，打印某一行的节点的时候，把下一层的子节点保存到相应的栈中
 *                    如果当前打印的是奇数层，先保存左子节点再保存右子节点到第一个栈里，如果当前打印的是偶数层，先保存右子节点再保存左子节点到第二个栈里
 * @params:
 * @Data: Created in  11:00 2018/7/30
 * @Modified By:
 */
public class Test_61_BinaryTreeNode {
    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;

        print(n1);
    }
    public static class BinaryTreeNode{
        private int val;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode(){ }
        public BinaryTreeNode(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return val+"";
        }
    }

    public static void print(BinaryTreeNode root){
        if (root == null){
            return;
        }

        List<BinaryTreeNode> current = new LinkedList<>();
        List<BinaryTreeNode> reverse = new LinkedList<>();
        int flag = 0;
        BinaryTreeNode node;
        current.add(root);

        while (current.size()>0){
            //从最后一个开始取
            node = current.remove(current.size() - 1);
            System.out.print("----"+node.val);

            //当前是从左往右打印的，那就按照从左往右入站
            if (flag == 0){
                if (node.left!=null){
                    reverse.add(node.left);
                }
                if (node.right!=null){
                    reverse.add(node.right);
                }
            }
            //当前是从右往左打印的，就按照从右往左入栈
            else {
                if (node.right!=null){
                    reverse.add(node.right);
                }
                if (node.left!=null){
                    reverse.add(node.left);
                }
            }
            if (current.size()==0){
                flag = 1-flag;
                List<BinaryTreeNode> tmp = current;
                current = reverse;
                reverse = tmp;
                System.out.println();
            }
        }
    }



}
