package com.ToF.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Description:题目：输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @params:
 * @Data: Created in  10:42 2018/8/9
 * @Modified By:
 */
public class Test_25_FindPath {
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
    public static void findPath(BinaryTreeNode root,int expectedSum){
        //创建一个链表，存放根节点到当前处理节点所经过的节点
        List<Integer> list = new ArrayList<>();

        if (root != null) {
            findPath(root,0,expectedSum,list);
        }
    }

    private static void findPath(BinaryTreeNode root, int curSum, int expectedSum, List<Integer> result){
        if (root != null) {
            curSum += root.value;
            result.add(root.value);
            if (curSum<expectedSum){
                findPath(root.left,curSum,expectedSum,result);
                findPath(root.right,curSum,expectedSum,result);
            }
            //如果当前的和与期望的和相等
            else if (curSum == expectedSum) {
                //当前节点是叶节点，输出结果
                if (root.left == null && root.right == null) {
                    System.out.println(result);
                }
            }
            result.remove(result.size()-1);

        }
    }

    public static void main(String[] args) {
        //            10
        //         /      \
        //        5        12
        //       /\
        //      4  7
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 10;
        root.left = new BinaryTreeNode();
        root.left.value = 5;
        root.left.left = new BinaryTreeNode();
        root.left.left.value = 4;
        root.left.right = new BinaryTreeNode();
        root.left.right.value = 7;
        root.right = new BinaryTreeNode();
        root.right.value = 12;

        // 有两条路径上的结点和为22
        System.out.println("findPath(root, 22);");
        findPath(root, 22);
    }
}
