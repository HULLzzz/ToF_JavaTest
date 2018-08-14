package com.ToF.test;

/**
 * @Author:
 * @Description:题目一：输入一棵二叉树的根结点，求该树的深度。
 *              从根结点到叶子点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @params:
 * @Data: Created in  14:35 2018/8/10
 * @Modified By:
 */
public class test_39_FindTheDeepthOfTree {
    public static class BinaryTreeNode{
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        public BinaryTreeNode(){}
        public BinaryTreeNode(int val){
            this.val = val;
        }
    }

    public static int treeDepth(BinaryTreeNode root){
        if (root == null) {
            return 0;
        }

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return left>right?(left+1):(right+1);
    }

    //判断是否为平衡二叉树 第一种解法
    public static boolean isBalanced(BinaryTreeNode root){
        if (root == null) {
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int diff = left - right;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    //第二种解法 后序遍历的方式遍历树
    public static boolean isBalanced2(BinaryTreeNode root){
        int[] depth = new int[1];
        return isBalancedHepler(root,depth);
    }

    private static boolean isBalancedHepler(BinaryTreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
      //  System.out.println("left----: "+left[0]+"right----: "+right[0]);
        if (isBalancedHepler(root.left, left) && isBalancedHepler(root.right, right)) {
            int diff = left[0] - right[0];
//            System.out.println("left: "+left[0]+"right: "+right[0]);
            if (diff >= -1 && diff <= 1) {
              //  System.out.println(root.val+"---->>");

                depth[0] = 1+(left[0]>right[0]?left[0]:right[0]);
//                System.out.println("left1: "+left[0]+"right1: "+right[0]);
//                System.out.println(depth[0]+"-->depth");
                return true;
                //此时返回true 传参即depth，depth也是right和left
            }
        }

        return false;
    }

    // 完全二叉树
    //             1
    //         /      \
    //        2        3
    //       /\       / \
    //      4  5     6   7
    private static void test1() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(1);
        BinaryTreeNode n3 = new BinaryTreeNode(1);
        BinaryTreeNode n4 = new BinaryTreeNode(1);
        BinaryTreeNode n5 = new BinaryTreeNode(1);
        BinaryTreeNode n6 = new BinaryTreeNode(1);
        BinaryTreeNode n7 = new BinaryTreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

     //   System.out.println(isBalanced(n1));
        System.out.println(isBalanced2(n1));
        System.out.println("----------------");

    }

    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    private static void test5() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(1);
        BinaryTreeNode n3 = new BinaryTreeNode(1);
        BinaryTreeNode n4 = new BinaryTreeNode(1);
      //  BinaryTreeNode n5 = new BinaryTreeNode(1);
       // BinaryTreeNode n6 = new BinaryTreeNode(1);
        BinaryTreeNode n7 = new BinaryTreeNode(1);

        n1.right = n2;
      //  n2.right = n3;
       // n3.right = n4;
       // n4.right = n5;


        System.out.println(isBalanced(n1));
        System.out.println(isBalanced2(n1));
        System.out.println("----------------");
    }

    public static void main(String[] args) {
       // test1();
        test5();
    }


}
