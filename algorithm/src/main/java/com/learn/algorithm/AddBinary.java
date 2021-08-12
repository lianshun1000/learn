package com.learn.algorithm;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @author lianshun
 * @date 2021/6/15 11:37 上午
 * @description 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "10101";
        String b = "1010";
        System.out.println(addBinary(a, b));
        // System.out.println(new BigDecimal("-3.24999999170546E-16").toPlainString());
    }

    public static String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }
}
