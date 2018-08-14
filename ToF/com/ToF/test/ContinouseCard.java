package com.ToF.test;

import java.util.Arrays;

/**
 * @Author:
 * @Description:
 * @params:
 * @Data: Created in  17:08 2018/7/25
 * 题目：
 *  * LL今天心情特别好，因为他去买了一副扑克牌，发现里面居然有2个大王，2个小王(一副牌原本是54张^_^)...
 *  * 他随机从中抽出了5张牌，想测测自己的手气，看看能不能抽到顺子，如果抽到的话，他决定去买体育彩票，嘿嘿！！
 *  * “红心A，黑桃3，小王，大王，方片5”，“Oh My God！”不是顺子.....
 *  * LL不高兴了，他想了想，决定大王和小王可以看成任何数字，并且A看作1，J为11，Q为12，K为13。
 *  * 上面的5张牌就可以变成“1，2，3，4，5”（大小王分别看作2和4），“So Lucky!”。
 *  * LL决定去买体育彩票啦。 现在，要求你使用这幅牌模拟上面的过程，然后告诉我们LL的运气如何。
 *  * 为了方便起见，你可以认为大小王是0。
 *  *
 *
 *  思路：对数组进行排序
 *        统计数组中0的个数num1
 *        统计除了0之外的其他排序数的空缺数num2
 *        如果num1>=num2 是顺子
 *        如果num1<num2 不是顺子
 *        如果出现了非0的重复数字，则不是顺子
 * @Modified By:
 */
public class ContinouseCard {

    public static boolean isContinuous(int[] num){
        if(num == null || num.length == 0){
            return false;
        }
        Arrays.sort(num);
        int num1 = 0;
        int num2 = 0;
        //统计0的个数
        while (num1!=num.length&&num[num1] == 0){
            num1++;
        }
        //计算除0之外的空缺数
        for (int i = num1 + 1;i<num.length;i++){
            if (num[i] == num[i-1]) //出现两个重复的数字，不是顺子
                return false;
            num2 += num[i] - num[i - 1] - 1 ;  //计算两个数之间的空缺数
        }
        if(num1 >= num2)
            return true;
        return false;
    }




}
