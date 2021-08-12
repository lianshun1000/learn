package com.learn.algorithm;

/**
 * @author lianshun
 * @date 2021/6/18 4:55 下午
 * @description 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(2147395600));
        System.out.println(mySqrt2(2147395600));

    }

    public static int mySqrt(int x) {
        Long i = 1L;
        while (i * i <= Long.valueOf(x)) {
            i++;
        }
        Long result = i - 1;
        return result.intValue();
    }

    public static int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}
