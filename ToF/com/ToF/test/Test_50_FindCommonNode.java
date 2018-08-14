package com.ToF.test;

import sun.reflect.generics.tree.Tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:
 * @Description:
 * @params:
 * @Data: Created in  13:36 2018/8/14
 * @Modified By:
 */
public class Test_50_FindCommonNode {
    public static class TreeNode{
        int val;
        List<TreeNode> children = new LinkedList<>();
        public TreeNode(){}
        public TreeNode(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return val+"";
        }
    }

    //找节点的路径 root:根节点 target：目标节点 path：经过的路径
    public static void getNodePath(TreeNode root,TreeNode target,List<TreeNode> path){
        if (root == null) {
            return;
        }
        //添加当前节点
        path.add(root);
        List<TreeNode> children = root.children;
        //处理子节点
        for (TreeNode node:children){
            if (node == target) {
                path.add(node);
                return;
            }else {
                getNodePath(node,target,path);
            }
        }
        path.remove(path.size()-1);
    }
    //找两个路径的最后一个共同的节点
    public static TreeNode getLastCommonNode(List<TreeNode> p1,List<TreeNode> p2){
        Iterator<TreeNode> ite1 = p1.iterator();
        Iterator<TreeNode> ite2 = p2.iterator();
        TreeNode last = null;
        while (ite1.hasNext()&&ite1.hasNext()){
            TreeNode tmp = ite1.next();
            if (tmp == ite2.next()) {
                last = tmp;
            }
        }
        return last;
    }

    //找两个树的最低公共祖先 root:树的根节点 p1:节点1 p2:节点2
    public static TreeNode getLastCommonParent(TreeNode root,TreeNode p1,TreeNode p2){
        if (root == null || p1 == null || p2 == null) {
            return null;
        }
        List<TreeNode> path1 = new LinkedList<>();
        getNodePath(root,p1,path1);
        List<TreeNode> path2 = new LinkedList<>();
        getNodePath(root,p2,path2);

        return getLastCommonNode(path1,path2);
    }

    //注意普通的树没有左右子树，视为链表，二叉树是每个节点最多有两个分支，二叉搜索树是排好序的二叉树
    // 形状普通的树
    //             1
    //           /   \
    //         2      3
    //        /         \
    //      4            5
    //     / \        /  |  \
    //    6   7      8   9  10
    public static void test01() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);

        n1.children.add(n2);
        n1.children.add(n3);

        n2.children.add(n4);

        n4.children.add(n6);
        n4.children.add(n7);

        n3.children.add(n5);

        n5.children.add(n8);
        n5.children.add(n9);
        n5.children.add(n10);

        System.out.println(getLastCommonParent(n1, n6, n8));
    }

    public static void main(String[] args) {
        test01();
    }



}
