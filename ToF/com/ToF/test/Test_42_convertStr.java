package com.ToF.test;

/**
 * @Author:
 * @Description: 面试题42：翻转单词顺序vs左旋转字符串
 * @params:
 * @Data: Created in  10:06 2018/8/3
 * @Modified By:
 */



public class Test_42_convertStr {

    public static void reverse(char[] data,int start,int end){
        if (data==null||data.length<1||start<0||end>data.length){
            return;
        }
        while (start<end){
            char tmp;
            tmp = data[start];
            data[start] = data[end];
            data[end] = tmp;

            start++;
            end--;
        }
    }


    /*
    *   Q: 题目一：输入一个英文句子，翻转句子中单词的顺序，但单词内字啊的顺序不变。为简单起见，标点符号和普通字母一样处理。
    *   think:  例如输入字符串”I am a student. ”，则输出”student. a am I”。解题思路
　　             第一步翻转句子中所有的字符。比如翻转“I am a student. ”中所有的字符得到”.tneduts a m a I”，此时不但翻转了句子中单词的顺序，连单词内的字符顺序也被翻转了。
                 第二步再翻转每个单词中字符的顺序，就得到了”student. a am I”。这正是符合题目要求的输出。
    *
    *
    * */

    public static char[] reverseSentence(char[] data){
        if (data==null||data.length<1){
            return data;
        }
        reverse(data,0,data.length-1);
       // System.out.println(data.length);

        int start = 0;
        int end = 0;
        while (start < data.length){
            if (data[start]==' '){
                start++;
                end++;
            }
            else if (end == data.length||data[end] == ' '){
                reverse(data,start,end-1);
                end++;
                start = end;
            }
            else
                end++;
        }
        return data;
    }

    /*
    * 题目二：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
    * 请定义一个函数实现字符串左旋转操作的功能。
    * 比如输入字符串”abcefg”和数字2，该函数将返回左旋转2 位得到的结”cefgab”。
    * think:    将两段数字分别左旋，再将整体数字左旋即可
    *
    * */

    public static char[] leftRotateStr(char[] data,int num){
        if (data==null||data.length<num||num<0){
            return data;
        }
        reverse(data,0,num-1);
        reverse(data,num,data.length-1);
        reverse(data,0,data.length - 1);
        return data;
    }

    public static void main(String[] args) {
        test01();
       // test02();
    }

    private static void test01() {
        System.out.println(new String(reverseSentence("I am a student.".toCharArray())));
        System.out.println(new String(reverseSentence("Wonderful".toCharArray())));
        System.out.println(new String(reverseSentence("".toCharArray())));
        System.out.println(new String(reverseSentence("    ".toCharArray())));
    }

    private static void test02() {
        System.out.println(new String(leftRotateStr("abcdefg".toCharArray(), 2)));
        System.out.println(new String(leftRotateStr("abcdefg".toCharArray(), 1)));
        System.out.println(new String(leftRotateStr("abcdefg".toCharArray(), 6)));
        System.out.println(new String(leftRotateStr("abcdefg".toCharArray(), 7)));
        System.out.println(new String(leftRotateStr("abcdefg".toCharArray(), 0)));
    }




}
