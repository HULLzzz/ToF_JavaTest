package com.ToF.test;

/**
 * @Author:
 * @Description:  题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *                例如，字符串“+100”，“5e2”，“-123”，“3.1416”及”-1E-16”都表示数值
 *                但“12e”,”1a3.14”,”1.2.3”,”+-5”及“12e+5.4”都不是。
 *
 *                判断一个字符串是否符合上述模式时，首先看第一个字符是不是正负号。
 *                如果是，在字符串上移动一个字符，继续扫描剩余的字符串中0到9的数位。
 *                如果是一个小数，则将遇到小数点。
 *                另外，如果是用科学计数法表示的数值，在整数或者小数的后面还有可能遇到’e’或者’E’。
 * @params:
 * @Data: Created in  11:58 2018/8/1
 * @Modified By:
 */
public class Test_54_isNumeric {
    public static boolean isNumeric(String string) {
        if (string == null || string.length() < 1) {
            return false;
        }
        int index = 0;
        if (string.charAt(index) == '+' || string.charAt(index) == '-') {
            index++;
        }
        //已经到达字符串末尾
        if (index >= string.length()) {
            return false;
        }
        boolean numric = true;
        index = scanDigits(string, index);
        //未到字符串末尾
        if (index < string.length()) {
            if (string.charAt(index) == '.') {
                index++;
                index = scanDigits(string, index);

                //已经到了字符串末尾
                if (index >= string.length()) {
                    numric = true;
                }
                //还未到字符串结束的位置
                else if (index < string.length() && (string.charAt(index) == 'e' || string.charAt(index) == 'E')) {
                    numric = isExponential(string, index);
                } else {
                    numric = false;
                }
            }
            //如果是指数标识
            else if (string.charAt(index) == 'e' || string.charAt(index) == 'E') {
                numric = isExponential(string, index);
            } else
                numric = false;
            return numric;
        }
        //到了字符串的末尾了，说明没有指数部分
       else
           return true;

    }

    private static boolean isExponential(String string, int index) {
        if (index>string.length()||(string.charAt(index)!='e'&&string.charAt(index)!='E')){
            return false;
        }

        index++;
        //到达末尾 返回false
        if (index>=string.length()){
            return false;
        }
        if (string.charAt(index)=='+'||string.charAt(index)=='-'){
            index++;
        }
        if (index>=string.length())
            return false;
        index = scanDigits(string,index);
        //已经处理到数字的末尾就认为是正确的指数
        return index>=string.length();
    }

    //扫描字符串的数字部分

    private static int scanDigits(String string, int index) {
        while (index<string.length()&&string.charAt(index)>='0'&&string.charAt(index)<='9'){
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("12e") + "[" + false + "]");
        System.out.println(isNumeric("100") + "[" + true + "]");
        System.out.println(isNumeric("123.45e+6") + "[" + true + "]");
        System.out.println(isNumeric("+500") + "[" + true + "]");
        System.out.println(isNumeric("5e2") + "[" + true + "]");
    }
}
