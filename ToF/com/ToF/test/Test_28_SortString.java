package com.ToF.test;

/**
 * @Author:
 * @Description:题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc。则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac 、bca、cab 和cba 。
 * @params:
 * @Data: Created in  15:13 2018/8/9
 * @Modified By:
 */
public class Test_28_SortString {
    public static void permutation(char[] chars){
        if (chars == null || chars.length < 1) {
            return;
        }
        permutation(chars,0);
    }

    private static void permutation(char[] chars, int begin) {
        //如果是最后一个元素，则输出
        if (chars.length - 1 == begin) {
            System.out.print(new String(chars)+ " ");
        }else {
            char tmp;
            //对当前还未处理的字符串进行处理，每个字符都可以作为当前处理的元素
            for (int i = begin;i<chars.length;i++){
                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;
                //处理下一个位置
                permutation(chars,begin+1);
                //应该将之前交换过的再交换回来，进行下次循环，否则会由重复序列，begin变为交换后的begin了
                tmp = chars[begin];chars[begin] = chars[i]; chars[i] = tmp;
            }


        }
    }
    public static void main(String[] args) {
        char[] c1 = {'a', 'b', 'c'};
        permutation(c1);
        System.out.println();

        char[] c2 = {'a', 'b', 'c', 'd'};
        permutation(c2);
    }

}
