package com.ToF.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:
 * @Description:题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左向右的顺序打印。
 *              think:利用一个容器，将节点的值装进容器，取出一个节点时将这个节点的子节点装入容器，同级节点应该在子节点之前，因此这个容器时先进先出的容器，即队列
 *
 * @params:
 * @Data: Created in  9:45 2018/8/9
 * @Modified By:
 */
public class Test_23_PrintFromTopToBottom {
    public static class BinaryTree{
        int value;
        BinaryTree left;
        BinaryTree right;
    }

    public static void printFromTopToBottom(BinaryTree root){
        if (root != null) {
            Queue<BinaryTree> list = new LinkedList<>(); //存放未遍历的元素
            list.add(root); //根节点入队
            //记录当前处理的节点
            BinaryTree curNode;

            //队列非空的时候进行处理
            while (!list.isEmpty()){
                //删除队首元素
                curNode = list.remove();
                System.out.print(curNode.value+" ");
                //左子节点不为空，子节点入队
                if (curNode.left!=null){
                    list.add(curNode.left);
                }
                if (curNode.right != null) {
                    list.add(curNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {

        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        BinaryTree root = new BinaryTree();
        root.value = 8;
        root.left = new BinaryTree();
        root.left.value = 6;
        root.left.left = new BinaryTree();
        root.left.left.value = 5;
        root.left.right = new BinaryTree();
        root.left.right.value = 7;
        root.right = new BinaryTree();
        root.right.value = 10;
        root.right.left = new BinaryTree();
        root.right.left.value = 9;
        root.right.right = new BinaryTree();
        root.right.right.value = 11;
        printFromTopToBottom(root);
    }

}
