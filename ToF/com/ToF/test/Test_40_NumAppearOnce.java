package com.ToF.test;

/**
 * @Author:
 * @Description:题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次，请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * @params:
 * @Data: Created in  11:30 2018/8/10
 * @Modified By:
 */
public class Test_40_NumAppearOnce {
    public static int[] findNumbersAppearOnce(int[] data){
        int[] result = {0,0};
        if (data == null || data.length < 2) {
            return result;
        }
        int xor = 0;
        for (int i : data){
            xor ^= i ;
        }
        int  indexOf1 = findFirstBit1(xor);
        for (int i : data){
            if (isBit1(i , indexOf1)){
                result[0] ^= i;
            }else {
                result[1] ^= i;
            }
        }
        return result;
    }

    private static boolean isBit1(int num, int indexBit) {
        num>>>=indexBit;
        return (num&1)==1;
    }

    private static int findFirstBit1(int num) {
        int index = 0;
        while ((num & 1) == 0 && index < 32) {
            num>>>=1;
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] data1 = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] result1 = findNumbersAppearOnce(data1);
        System.out.println(result1[0] + " " + result1[1]);
    }

}
