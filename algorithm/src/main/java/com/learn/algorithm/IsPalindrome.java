package com.learn.algorithm;

//TODO 可以优化为只反转一半
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        int x1 = x;
        long result = 0l;
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        while (x != 0) {
            int num = x % 10;
            x = x / 10;
            result = result * 10 + num;
        }
        int compareNum = (int) result;
        if (result <= Integer.MAX_VALUE && compareNum == x1) {
            return true;
        } else {
            return false;
        }
    }
}
