package com.ToF.test;


import javax.naming.NamingEnumeration;

/**
 * @Author:
 * @Description:题目：我们把只包含因子2、3 和5 的数称作丑数（Ugly Number）。求从小到大的顺序的第1500个丑数。
 * @params:
 * @Data: Created in  9:51 2018/8/11
 * @Modified By:
 */
public class Test_34_FindUglyNum {
    //判断一个数是否只有2，3，5因子
    private static boolean isUgly(int num){
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
    //找出第index个丑数
    public static int getUglyNumber(int index){
        if (index <= 0) {
            return 0;
        }
        int num = 0;
        int uglyFound = 0;
        while (uglyFound < index) {
            num++;
            if (isUgly(num)){
                uglyFound++;
            }
        }
        return num;
    }


    //找出丑数第二种方法，第一种方法效率太低
    public static int getUglyNumber2(int index){
        if (index <= 0) {
            return 0;
        }
        int[] pUglyNum = new int[index];
        pUglyNum[0] = 1;
        int nextUglyIndex = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        while (nextUglyIndex < index) {
            int min = min(pUglyNum[p2]*2,pUglyNum[p3]*3,pUglyNum[p5]*5);
            pUglyNum[nextUglyIndex] = min;
            while (pUglyNum[p2]*2<=pUglyNum[nextUglyIndex]){
                p2++;
            }
            while (pUglyNum[p3]*3<=pUglyNum[nextUglyIndex]){
                p3++;
            }
            while (pUglyNum[p5]*2<=pUglyNum[nextUglyIndex]){
                p5++;
            }
            nextUglyIndex++;
        }
        return pUglyNum[nextUglyIndex - 1];
    }

    private static int min(int n1, int n2, int n3) {
        int min = n1<n2?n1:n2;
        return min<n3?min:n3;
    }
}
