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
    
    
    //循环解法
    public static void solution43(int num){
        if (num<1)
            return;
        int[][] probabilities = new int[2][6*num + 1];
        for (int i = 0;i<6;i++){
            probabilities[0][i] = 0;
            probabilities[1][i] = 0;
        }
        int flag = 0;
        for (int i = 1;i<=6;i++){
            //第一次抛筛子的时候有6种可能，每种可能出现一次
            probabilities[flag][i] = 1;
        }
        //从第2次开始掷筛子，假设第一个数组中的第n个数字标识筛子和为n出现的次数
        //下一个循环的时候，加上一个新的筛子，这样此时和为n的筛子出现的次数应该是上一次
        //筛子点数为n-1，n-2...n-6的次数总和，所以我们将另一个数组设为前一个数组对应的n-1 n-2...n-6之和
        for (int k = 2;k<=num;k++){
            for (int i = 0;i<k;i++){//第k次掷筛子，和最小是k，令不可能的值设置为0
                probabilities[1-flag][i] = 0;
            }
            for (int i = k;i<=6*num;i++){
                probabilities[1-flag][i] = 0; //初始化，因为这是一个反复使用的数组，需要将上次的结果清0
                for (int j = 1;j<=i&&j<=6;j++){
                    probabilities[1-flag][i] += probabilities[flag][i-j];
                }
            }
            flag = 1-flag;
        }
        double total = Math.pow(6,num);
        for (int i = num;i<6*num;i++){
            double ratio = probabilities[flag][i]/total;
            System.out.println("sum"+i+"ratio"+ratio);
        }
    }
}
