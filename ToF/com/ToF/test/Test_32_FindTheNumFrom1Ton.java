package com.ToF.test;

/**
 * @Author:
 * @Description:
 * @params:
 * @Data: Created in  15:37 2018/8/11
 * @Modified By:
 */
public class Test_32_FindTheNumFrom1Ton {
    public static int numberOf1Between1AndN(int n){
        //n最大的数字
        //return 1-n中各个数位1出现的次数
        if (n <= 0) {
            return 0;
        }
        String value = n + "";
        int[] numbers = new int[value.length()];
        for (int i = 0;i<numbers.length;i++){
            numbers[i] = value.charAt(i)-'0';
        }
        return numberOf1(numbers,0);
    }

    private static int numberOf1(int[] numbers, int curIdx) {
        //求0-numbers表中数字1的个数
        if (numbers == null || curIdx >= numbers.length || curIdx < 0) {
            return 0;
        }
        //待处理的第一个数字
        int first = numbers[curIdx];
        //要处理的数字的位数
        int length = numbers.length-curIdx;

        //如果只有一位且这一位不是0返回1
        if (length == 1 && first > 0) {
            return 1;
        }
        //数组只有一位且这一位是0则返回0
        if (length == 1 && first == 0) {
            return 0;
        }
        //假设numbers是21345
        //numFirstDigit是数字10000-19999的第一个位中的数目
        int numFirstDigit = 0;
        //处理最高位
        //最高位是1，如12345，在[2346,12345]中最高位1出现的只有在[10000,12345]中一共2346次
        if (first == 1) {
            numFirstDigit = atoi(numbers,curIdx+1)+1;
        }
        //最高位不是1，21345，在[1236,21345]中最高位1出现的次数[10000,19999]是10^4次
        else if (first > 1) {
            numFirstDigit = powerBase10(length - 1);
        }

        // numOtherDigits，是[1346, 21345]中，除了第一位之外（不看21345中的第一位2）的数位中的1的数目
        int numOtherDigits = first*(length-1)*powerBase10(length-2);
        //int Recursive 是1-1234中1的数目
        int numRecursive = numberOf1(numbers,curIdx+1);
        return numFirstDigit+numOtherDigits+numRecursive;

    }

    private static int powerBase10(int n) {
        //求10的n次方
        int result = 1;
        for (int i = 0;i<n;i++){
            result *=10;
        }
        return result;
    }

    private static int atoi(int[] numbers, int i) {
        //将数字数组转化为数值 如{1，2，3，4，5} i=2结果是345
        int result = 0;
        for (int j = i;j<numbers.length;j++){
            result = (result*10+numbers[j]);
        }
        return result;
    }
}
