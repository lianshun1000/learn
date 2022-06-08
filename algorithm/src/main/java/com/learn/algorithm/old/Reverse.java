package com.learn.algorithm.old;


public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(-317999999));
    }

    public static int reverse(int x) {
        long result = 0l;
        while (x != 0) {
            int num = x % 10;
            x = x / 10;
            result = result * 10 + num;
        }
        if (result <= Integer.MAX_VALUE && result >= Integer.MIN_VALUE) {
            return (int) result;
        } else {
            return 0;
        }
    }
}
