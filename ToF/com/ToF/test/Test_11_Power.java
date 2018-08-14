package com.ToF.test;

/**
 * @Author:
 * @Description: 不使用库函数实现一个数的n次方
 * @params:
 * @Data: Created in  10:59 2018/8/7
 * @Modified By:
 */
public class Test_11_Power {
    public static double power(double base,int exponent){
        //指数和底数不能同时为0
        if (base==0&&exponent==0){
            throw new RuntimeException("Invalid input");
        }

        if (exponent==0){
            return 1;
        }

        //求指数的绝对值
        long exp = exponent;
        if (exponent<0){
            exp = -exp;
        }

        //求幂次方
        double result = powerWihtUnsignedExponent(base,exp);
        //指数是负数，求倒数
        if (exponent<0){
            result = 1/result;
        }
        return result;
    }

    private static double powerWihtUnsignedExponent(double base, long exponent) {
        if (exponent==0)
            return 1;

        if (exponent==1)
            return base;

        //递归求一半的值
        double result = powerWihtUnsignedExponent(base,exponent>>1);

        //求最终的值，如果是奇数还剩一次底数
        result *= result;
        if (exponent%2!=0){
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(0.0000000000000000000000001111 == 0);
        System.out.println(0.0000000000000000000000000000 == 0);

        System.out.println(power(2, -4));
        System.out.println(power(2, 4));
        System.out.println(power(2, 0));
        System.out.println(power(0.00000000000000000000000000001, -1));
        System.out.println(power(0.00000000000000000000000000001, 1));
        System.out.println(power(0.00000000000000000000000000001, 0));
        System.out.println(power(0.00000000000000000000000000000, 0));
    }
    }
