package com.ToF.test;

import java.util.ArrayList;

/**
 * @Author:
 * @Description:  题目：给定一二叉搜索树，找出它第K大的节点
 *                思路：如果按照中序遍历的顺序遍历一颗二叉搜索树，遍历的数值是递增排序的，只需要用中序遍历算法遍历一颗二叉树很容易找到第K大节点
 * @params:
 * @Data: Created in  13:30 2018/7/30
 * @Modified By:
 */
public class Test_63_FindTheKNum {
    private static class BinaryTreeNode{
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

    public static BinaryTreeNode kthNode(BinaryTreeNode root,int k){
        if (root == null||k<1){
            return null;
        }
        int[] tmp = {k};
        return kthNodeCOre(root,tmp);
    }

    private static BinaryTreeNode kthNodeCOre(BinaryTreeNode root,int[] k){
        BinaryTreeNode result = null;
        //现在左子树找
        if (root.left != null){
            result = kthNodeCOre(root.left,k);
        }


        //若左子树没有找到说明当前的根节点是所要找的节点
        if (result == null){
            if (k[0]==1){
                result = root;
            }
            //当前节点不是要找的节点,但已经找过了，计数器减一
            else {
                k[0]--;
            }
        }

        //根节点以及根节点的左子树都没有找到，则找右节点
        if (result == null&&root.right!=null){
            result = kthNodeCOre(root.right,k);
        }
        return result;
    }
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
        System.out.println();

        for (int i = 0; i <= 10; i++) {
            System.out.printf(kthNode(n1, i) + ", ");
        }

    }

    //中序遍历一棵树
    private static void print(BinaryTreeNode root){
        if (root!=null){
            print(root.left);
            System.out.printf("%-3d",root.val);
            print(root.right);
        }
    }


}
