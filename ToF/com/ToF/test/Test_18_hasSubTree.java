package com.ToF.test;

import com.sun.javafx.charts.ChartLayoutAnimator;

/**
 * @Author:
 * @Description:题目：输入两棵二叉树A 和B，判断B 是不是A 的子结构。
 * @params:
 * @Data: Created in  11:39 2018/8/8
 * @Modified By:
 */
public class Test_18_hasSubTree {
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }



    public static boolean hasSubtree(BinaryTreeNode root1,BinaryTreeNode root2){
        //如果是同一个对象，返回true
        if (root1==root2){
            return true;
        }
        //b的根节点为空，返回true
        if (root2 == null){
            return true;
        }
        //b的根节点不为空，如果A的根节点为空就返回false
        if (root1==null){
            return false;
        }

        boolean result = false;

        //如果节点的值相等，调用匹配方法
        if (root1.value==root2.value){
            result = match(root1,root2);
        }


        if (result){
            return true;
        }
        //如果不匹配就找A的左子节点和右子节点进行判断
        return hasSubtree(root1.left,root2)|| hasSubtree(root1.right,root2);
    }

    private static boolean match(BinaryTreeNode root1, BinaryTreeNode root2) {
        //两个对象是同一个就返回true
        if (root1==root2){
            return true;
        }
        //b的根节点为空就返回true
        if (root2 == null) {
            return true;
        }
        if (root1==null){
            return false;
        }

        //两个节点的值相同，则分别判断其左子节点和右子节点的值
        if (root1.value==root2.value){
            return match(root1.left,root2.left)&&match(root1.right,root2.left);
        }

        //节点的值不相等就返回false
        return false;
    }
    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode();
        root1.value = 8;
        root1.right = new BinaryTreeNode();
        root1.right.value = 7;
        root1.left = new BinaryTreeNode();
        root1.left.value = 8;
        root1.left.left = new BinaryTreeNode();
        root1.left.left.value = 9;
        root1.left.right = new BinaryTreeNode();
        root1.left.right.value = 2;
        root1.left.right.left = new BinaryTreeNode();
        root1.left.right.left.left = new BinaryTreeNode();
        root1.left.right.left.left.value = 4;
        root1.left.right.left.right = new BinaryTreeNode();
        root1.left.right.left.right.value = 7;

        BinaryTreeNode root2 = new BinaryTreeNode();
        root2.value = 8;
        root2.left = new BinaryTreeNode();
        root2.left.value = 9;
        root2.right = new BinaryTreeNode();
        root2.right.value = 2;

        System.out.println(hasSubtree(root1, root2));
        System.out.println(hasSubtree(root2, root1));
        System.out.println(hasSubtree(root1, root1.left));
        System.out.println(hasSubtree(root1, null));
        System.out.println(hasSubtree(null, root2));
        System.out.println(hasSubtree(null, null));
    }
}


