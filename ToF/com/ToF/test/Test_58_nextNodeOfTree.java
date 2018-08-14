package com.ToF.test;

/**
 * @Author:
 * @Description:题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父节点的指针。
 * @params:
 * @Data: Created in  12:54 2018/8/12
 * @Modified By:
 */
public class Test_58_nextNodeOfTree {
    private static class BinaryTree{
        int val;
        private BinaryTree left;
        private BinaryTree right;
        private BinaryTree parent;
        public BinaryTree(){}
        public BinaryTree(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return val+"";
        }
    }

    public static BinaryTree getNext(BinaryTree node){
        if (node == null) {
            return null;
        }
        //保存要查找的下一个节点
        BinaryTree target = null;
        if (node.right != null) {
            target = node.right;
            while (target.left != null) {
                target = target.left;
            }
            return target;
        } else if (node.parent != null) {
            target = node.parent;
            BinaryTree cur = node;
            //父节点不为空，子节点不是父节点的左孩子
            while (target != null && target.left != cur) {
                cur = target;
                target = target.parent;
            }
            return target;
        }
        return null;
    }
    private static void assemble(BinaryTree node,
                                 BinaryTree left,
                                 BinaryTree right,
                                 BinaryTree parent) {
        node.left = left;
        node.right = right;
        node.parent = parent;
    }
    public static void test01() {
        BinaryTree n1 = new BinaryTree(1); // 12
        BinaryTree n2 = new BinaryTree(2); // 10
        BinaryTree n3 = new BinaryTree(3); // 14
        BinaryTree n4 = new BinaryTree(4); // 9
        BinaryTree n5 = new BinaryTree(5); // 11
        BinaryTree n6 = new BinaryTree(6); // 13
        BinaryTree n7 = new BinaryTree(7); // 15
        BinaryTree n8 = new BinaryTree(8); // 4
        BinaryTree n9 = new BinaryTree(9); // 2
        BinaryTree n10 = new BinaryTree(10); // 5
        BinaryTree n11 = new BinaryTree(11); // 1
        BinaryTree n12 = new BinaryTree(12); // 6
        BinaryTree n13 = new BinaryTree(13); // 3
        BinaryTree n14 = new BinaryTree(14); // 7
        BinaryTree n15 = new BinaryTree(15); // null

        assemble(n1, n2, n3, null);
        assemble(n2, n4, n5, n1);
        assemble(n3, n6, n7, n1);
        assemble(n4, n8, n9, n2);
        assemble(n5, n10, n11, n2);
        assemble(n6, n12, n13, n3);
        assemble(n7, n14, n15, n3);
        assemble(n8, null, null, n4);
        assemble(n9, null, null, n4);
        assemble(n10, null, null, n5);
        assemble(n11, null, null, n5);
        assemble(n12, null, null, n6);
        assemble(n13, null, null, n6);
        assemble(n14, null, null, n7);
        assemble(n15, null, null, n7);

        System.out.println(getNext(n1));
        System.out.println(getNext(n2));
        System.out.println(getNext(n3));
        System.out.println(getNext(n4));
        System.out.println(getNext(n5));
        System.out.println(getNext(n6));
        System.out.println(getNext(n7));
        System.out.println(getNext(n8));
        System.out.println(getNext(n9));
        System.out.println(getNext(n10));
        System.out.println(getNext(n11));
        System.out.println(getNext(n12));
        System.out.println(getNext(n13));
        System.out.println(getNext(n14));
        System.out.println(getNext(n15));
    }

    public static void main(String[] args) {
        test01();
    }



}
