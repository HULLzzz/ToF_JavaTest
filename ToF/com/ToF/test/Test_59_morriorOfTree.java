package com.ToF.test;

import jdk.nashorn.internal.ir.BinaryNode;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @Author:
 * @Description:题目：请实现一个函数来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * @params:
 * @Data: Created in  11:32 2018/8/12
 * @Modified By:
 */
public class Test_59_morriorOfTree {
    public static class BinaryTreeNode{
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        public BinaryTreeNode(){}
        public BinaryTreeNode(int val){this.val = val;}

        @Override
        public String toString() {
            return val+"";
        }
    }

    public static boolean isSymmetrical(BinaryTreeNode root){
        return isSymmetrical(root,root);
    }

    private static boolean isSymmetrical(BinaryTreeNode left, BinaryTreeNode right) {
        if (left == null || right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetrical(left.left,right.right)&&isSymmetrical(left.right,right.left);
    }

}
