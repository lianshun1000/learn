package com.learn.algorithm.middle;

import java.util.SortedMap;

/**
 * @author lianshun
 * @date 2022/5/3 4:10 下午
 * @description 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 */
public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("2147483646"));
    }

    public static int myAtoi(String s) {
        s= s.trim();
        int num = 0;
        int flag = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(flag == -1 && c != '+' && c != '-' && !(c >= '0' && c <= '9')){
                break;
            }
            if (flag != -1 && (c < '0' || c > '9')) {
                break;
            }
            if ((c == '+' || c == '-') && flag == -1 && num == 0) {
                flag = i;
            }
            if (c >= '0' && c <= '9') {
                if (flag == -1) {
                    flag = 0;
                }
                if (num <= (Integer.MAX_VALUE-c+'0')  / 10 ) {
                    num = num * 10 + c - '0';
                }else{
                    if(s.charAt(flag) == '-'){
                        return Integer.MIN_VALUE;
                    }
                    return Integer.MAX_VALUE;
                }
            }
        }

        if (flag == -1) {
            return 0;
        } else if (s.charAt(flag) == '-') {
            num = -1 * num;
        }
        return num;
    }
}
