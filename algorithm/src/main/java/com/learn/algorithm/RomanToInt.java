package com.learn.algorithm;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    /**
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 输入: "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int result = 0;
        char[] roman = s.toCharArray();
        int[] num = new int[roman.length];
        for (int i = 0; i < roman.length; i++) {
            switch (roman[i]) {
                case 'I':
                    num[i] = 1;
                    break;
                case 'V':
                    num[i] = 5;
                    break;
                case 'X':
                    num[i] = 10;
                    break;
                case 'L':
                    num[i] = 50;
                    break;
                case 'C':
                    num[i] = 100;
                    break;
                case 'D':
                    num[i] = 500;
                    break;
                case 'M':
                    num[i] = 1000;
                    break;
                default:
                    break;
            }
        }
        int point = 0;
        while (point < num.length) {
            if (point + 1 < num.length && num[point] < num[point + 1]) {
                result += num[point + 1] - num[point];
                point += 2;
            } else {
                result += num[point];
                point++;
            }
        }
        return result;
    }
}
