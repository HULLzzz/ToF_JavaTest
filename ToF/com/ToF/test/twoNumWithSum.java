package com.ToF.test;

import javax.print.attribute.standard.Finishings;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:
 * @Description:
 * * 题目：
 *  * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 *  * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *  * 对应每个测试案例，输出两个数，小的先输出。
 *  *
 *  * 思路：
 *  * 充分利用数组已排序的特点，
 *  * 将第一个指针指向数组最小的元素（头），将第二个指针指向数组最大的元素（末尾）
 *  *     若此时两个元素的和等于S，则这是我们要的答案
 *  *     如果此时两个元素的和小于S，则将第一个指针指向下一个元素
 *  *     如果此时两个元素的和大于S，则将第二个指针指向前一个元素
 *  *
 *  * 题目要求如果有多对符合的数字，则输出两数乘积最小的
 *  * 设两数的和为2m，则其中一个数字为m-a，另外一个数字为m+a
 *  * (m+a)(m-a) = m² - a²
 *  * 所以当a越大，乘积越小
 *  *
 *  * 即本题中，两个数组下标差越大时，乘积越小，即第一对符合的元素就是我们要的答案
 *
 *
 *  补充：
 *      装箱：值类型转换为引用类型
 *      拆箱：引用类型转换为值类型
 *      值类型：直接存储在内存的栈中，由系统自动释放资源
 *      引用类型：存储在内存的堆中，由实际值引用表示的数据类型，类似与指针，new出来的都是引用类型，通常说的内存溢出指栈被分配完了
 *      ArrayList和list的区别：
 *                          数组是连续存储的，插入添加都很不方便，list解决了这个问题
 *                          在list中，我们不仅插入了字符串"abc"，而且又插入了数字123。
 *                          这样在ArrayList中插入不同类型的数据是允许的。因为ArrayList会把所有插入其中的数据都当作为object类型来处理。
 *                          这样，在我们使用ArrayList中的数据来处理问题的时候，很可能会报类型不匹配的错误，也就是说ArrayList不是类型安全的。既
 *                          使我们保证在插入数据的时候都很小心，都有插入了同一类型的数据，但在使用的时候，我们也需要将它们转化为对应的原类型来处理。
 *                          这就存在了装箱与拆箱的操作，会带来很大的性能损耗。
 * @params:
 * @Data: Created in  10:51 2018/7/26
 * @Modified By:
 */


public class twoNumWithSum {
    public static void main(String[] args) {
        int array[] = new int[]{1,2,2,3,5};
        System.out.println(FindNumWithSum(array,4));
       // System.out.println(FindContinunousSequence(100));
       // System.out.println(FindNumWithSum(array,4));

    }
    public static ArrayList<Integer> FindNumWithSum(int[] array, int sum){
        if (array==null||array.length<2)
            return new ArrayList<>();
        int low = 0;
        int high = array.length-1;
        ArrayList<Integer> list = new ArrayList<>();
        while (low<high){

            if (array[low]+array[high]>sum)
                high--;
            else if (array[low]+array[high]<sum)
                low++;
            else{
               return new ArrayList<>(Arrays.asList(array[low],array[high]));   //return语句，避免陷入死循环
            }
        }
       // System.out.println(list.size()+"-------------");
        return new ArrayList<>();
    }
    /*
    * 题目：输出所有和为S的连续整数的序列，序列内按照从小到大的顺序排列，序列间按照数字的从小到大排列
    *
    * 和为s的连续正数序列
    * 序列的长度至少为2 和为S的连续整数序列的可能区间是【1，（S+1）/2】
    *
    * 两个指针，第一个指针p1指向1，第二个指针p2指向2
    *
    * 循环执行下面步骤 直到p2>(s+1)/2
    * if     序列p1~p2的和小于s，p2向前移动
    * else if 序列p1~p2 的和大于s p1向前移动
    * else 得到符合条件的序列，记录下来并且p2和p1同时向前移动
    *
    * */
    public static ArrayList<ArrayList<Integer>> FindContinunousSequence(int sum){
        if(sum<3)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int low = 1;
        int high = 2;
        int sumOfSequence = low+high;
        while (high<=(sum+1)/2){
            if(sumOfSequence<sum){
                high++;
                sumOfSequence+=high;
            }
            else if(sumOfSequence>sum){
                sumOfSequence -=low;
                low++;
            }
            else {
                ArrayList<Integer> oneOfResult = new ArrayList<>();
                for (int i = low;i<=high;i++){
                    oneOfResult.add(i);
                }
                result.add(oneOfResult);
                high++;
                sumOfSequence += high;
                sumOfSequence -= low;
                low++;
            }
        }
        return result;

    }

}
