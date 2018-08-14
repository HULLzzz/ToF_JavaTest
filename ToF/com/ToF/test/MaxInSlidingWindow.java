package com.ToF.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author:
 * @Description:
 *  * 题目：
 *  * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *  * 例如：
 *  * 如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 *  * 他们的最大值分别为{4,4,6,6,6,5}；
 *  * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *  * {[2, 3, 4], 2, 6, 2, 5, 1}，
 *  * {2, [3, 4, 2], 6, 2, 5, 1}，
 *  * {2, 3, [4, 2, 6], 2, 5, 1}，
 *  * {2, 3, 4, [2, 6, 2], 5, 1}，
 *  * {2, 3, 4, 2, [6, 2, 5], 1}，
 *  * {2, 3, 4, 2, 6, [2, 5, 1]}。
 * @params:
 * @Data: Created in  9:17 2018/7/26
 * @Modified By:
 */
public class MaxInSlidingWindow {
    public static void main(String[] args) {
        int num[] = {4,2,3,2,6,2,5,1};
        System.out.println(maxInWindows(num,4));
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size){
        if(num == null||num.length == 0||size<1||size>num.length)
            return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        //result保存的是最大值序列
        // 双向队列保存的是每个窗口的最大值元素的下标，按照元素的值降序排序。滑动窗口的时候要判断最大值有没有滑出窗口
        // 窗口右滑遇到新数时，首先判断若左侧滑出窗口的是最大值，则将双向队列的对手元素删除。
        // 然后依次将新数与队列末尾元素进行比较，依次删掉队尾小于新数的元素直到遇到大的元素或队列为空。
        // 将新数压入队列，保证队列中保存的元素是降序存在的，这里队列保存的就是当下滑动窗口的第一大元素、第二大元素···
        // 另外，此处队列保存的的是原数组的下标，这样既可以保存数值，也可以判断队列中的数是否滑出窗口。

        Deque<Integer> deque = new LinkedList<>(); //初始化滑动窗口
        for(int i =0;i<size;i++){
            while (!deque.isEmpty()&&num[deque.getLast()]<num[i])
                deque.removeLast();
            deque.addLast(i);  //将数字对应的下标添加到双端队列中

        }
        result.add(num[deque.getFirst()]);
        //右移滑动窗口
        for (int i = size;i<num.length;i++){
            //判断最大值是否滑出窗口
            if (i-deque.getFirst()>=size)
                deque.removeFirst();
            while (!deque.isEmpty()&&num[deque.getLast()]<num[i])
                deque.removeLast();
            deque.addLast(i);
            result.add(num[deque.getFirst()]);
        }
        return result;
    }
}
