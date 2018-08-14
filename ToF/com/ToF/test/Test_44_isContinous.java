package com.ToF.test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author:
 * @Description:题目：从扑克牌中随机抽5张牌，判断是不是一个顺子， 即这5张牌是不是连续的。2～10为数字本身， A为1。 J为11、Q为12、 为13。小王可以看成任意数字。
 * @params:
 * @Data: Created in  10:03 2018/8/14
 * @Modified By:
 */
public class Test_44_isContinous {
    public static boolean isContinuous(int[] number){
        if (number.length < 1 || number == null) {
            return false;
        }
        //对元素进行排序
        Arrays.sort(number);
        int numberOfZero = 0;
        int numberOfGap = 0;
        for (int i = 0;i<number.length&&number[i]==0;i++){
            numberOfZero++;
        }
        //一副牌不可能有两个王
        if (numberOfZero>2){
            return false;
        }
        //第一个非零元素的位置
        int small = numberOfZero;
        int big = small+1;
        while (big<number.length){
            if (number[small]==number[big]){
                return false;
            }
            //两张牌中间差了几张
            numberOfGap += (number[big]-number[small]-1);
            small = big;
            big++;
        }
        return numberOfGap<=numberOfZero;
    }

}
