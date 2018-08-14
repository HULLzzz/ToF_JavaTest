package com.ToF.test;

import java.util.ArrayList;

/**
 * @Author:
 * @Description:
 *              一个数组中除了两个数字出现一次其他数字都出现两次，找出这两个数字
 * @params:
 * @Data: Created in  14:46 2018/7/26
 * @Modified By:
 */
public class NumAppearOnce {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,2,3,4,3};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce_useList(array,num1,num2);

        System.out.println(num1[0]+"--"+num2[0]);
    }
    /*
    * 思路：遍历数组，用一个ArrayList记录当前出现了一次的值，当前遍历的值如果在ArrayList中已经出现，则移除该值，继续遍历
    * */
    public static void FindNumsAppearOnce_useList(int[] array,int[] num1,int[] num2){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0;i<array.length;i++){
            if (!list.contains(array[i]))
                list.add(array[i]);
            else
                list.remove(new Integer(array[i]));
        }
        if (list.size()>1){
            num1[0] = list.get(0);
            num2[0] = list.get(1);
        }
    }

    /*
    * 要求时间复杂度为O(n）空间复杂度为O（1）
    *       异或运算中任何数和本身异或都为0，和0异或都为本身
    *       将原数组分为两个子数组，且每个子数组中各自包含一个只出现一个的数字，在该前提下，只有一个数字出现了一次，其他数字出现了两次
    *       针对每个子数组从头到尾一次异或每个数字，最后留下来的都是就是出现一次的数字
    *       子数组的划分：将原数组从头到尾进行异或，得到的结果就是两个不相同的数的运算结果，运算结果中肯定有一位是1，将这位标记为从低位开始的第n位
    *                   第n位对照的两个不同的数字一定一位是1一位是0
    *                   按照第n位是否为1进行分组，相同的数字肯定被分在同一子数组中
    * */

    public void FindNumsAppearOnce(int[] array,int[] num1,int num2[]){
        if (array==null||array.length<2)
            return;
        int n = 0 ;
        for (int i = 0; i<array.length;i++){
            n^=array[i];
        }
        //n是原数组一次异或完之后的值
        int firstBitIs1 = findFirstBistIs1(n);
        //第n位为1的值
        int N = 1<<firstBitIs1;  //将1按照二进制左移firstBitIs1位
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0;i<array.length;i++){
            if ((array[i]&N)!=0)
                num1[0]^=array[i];
            else
                num2[0]^=array[i];
        }

    }

    private int findFirstBistIs1(int n) {
        if (n==0)
            return 0;
        for (int i = 0;i<32;i++,n>>=1){
            if ((n&1)==1)
                return i;
        }
        return 0;
    }
}
