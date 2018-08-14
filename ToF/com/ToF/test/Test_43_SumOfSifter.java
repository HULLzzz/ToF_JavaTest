package com.ToF.test;

/**
 * @Author:
 * @Description:题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s 的所有可能的值出现的概率。
 * @params:
 * @Data: Created in  17:35 2018/8/3
 * @Modified By:
 */
public class Test_43_SumOfSifter {

    /*
    * 递归解法：
    * 先把n个骰子分为两堆：第一堆只有一个，另一个有n- 1 个。单独的那一个有可能出现从1 到6 的点数。
    * 我们需要计算从1 到6 的每一种点数和剩下的n-1 个骰子来计算点数和。
    * 接下来把剩下的n-1个骰子还是分成两堆，第一堆只有一个， 第二堆有n-2 个。
    * 我们把上一轮那个单独骰子的点数和这一轮单独骰子的点数相加， 再和剩下的n-2 个骰子来计算点数和。
    * 分析到这里，我们不难发现这是一种递归的思路，递归结束的条件就是最后只剩下一个骰子。
    *
    * */
    public static void printProbability(int number,int max){
        if (number<1||max<1)
            return;

        int maxSum = number*max;
        int[] probabilities = new int[maxSum - number + 1];
    }
}
