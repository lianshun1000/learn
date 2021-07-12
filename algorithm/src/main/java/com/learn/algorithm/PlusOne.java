package com.learn.algorithm;

import java.util.Arrays;

/**
 * @author lianshun
 * @date 2021/6/15 10:49 上午
 * @description
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9,9,9};
        plusOne(digits);
    }

    public static int[] plusOne(int[] digits) {
        boolean flag = false;
        for (int i = digits.length-1; i >=0 ; i--) {
            if(i == digits.length-1 && digits[i]==9){
                digits[i]=0;
                flag = true;
            }else if(flag == true && digits[i]==9){
                digits[i]=0;
            }else{
                digits[i] = digits[i]+1;
                flag = false;
                break;
            }
        }
        if(flag == true){
            int[] result = new int[digits.length+1];
            System.arraycopy(digits,0,result,1,digits.length);
            result[0]=1;
            Arrays.stream(result).forEach(System.out::println);
            return result;
        }
        Arrays.stream(digits).forEach(System.out::println);
        return digits;
    }
}
