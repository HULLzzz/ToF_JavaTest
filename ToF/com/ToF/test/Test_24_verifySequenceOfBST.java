package com.ToF.test;

/**
 * @Author:
 * @Description:题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同。
 * @params:
 * @Data: Created in  10:27 2018/8/9
 * @Modified By:
 */
public class Test_24_verifySequenceOfBST {
    public static boolean verifySequenceOfBST(int[] sequence){
        if (sequence==null||sequence.length<=0){
            return false;
        }
        return verifySequenceOfBST(sequence,0,sequence.length-1);
    }

    //此方法与上面方法不同，没有空值的判断，这是上面方法的一个辅助方法，只有上面的方法中数组中有数字的时候这个方法和上面方法返回的值才相同
    private static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }

        //从左向右找第一个不大于根节点的元素的位置
        int index = start;
        while (index<end-1&&sequence[index]<sequence[end]){
            index++;
        }

        //执行到此处的[end,index-1]可以看作左子树
        int right = index;

        //从第一个不小于根节点的元素开始找第一个不大于根节点的元素，保证右子树的所有节点都大于根节点
        while (index<end-1&&sequence[index]>sequence[end]){
            index++;
        }

        //不满足则不符合二叉树的定义，返回false
        if (index != end - 1) {
            return false;
        }

        index = right;
        return verifySequenceOfBST(sequence,start,index-1)&&verifySequenceOfBST(sequence,index,end-1);

    }

    public static void main(String[] args) {
        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16
        int[] data = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + verifySequenceOfBST(data));
    }
}
