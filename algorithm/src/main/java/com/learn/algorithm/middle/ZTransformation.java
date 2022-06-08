package com.learn.algorithm.middle;

import java.util.Arrays;

/**
 * @author lianshun
 * @date 2022/5/1 4:49 下午
 * @description
 */
public class ZTransformation {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int num = numRows - 1;
        char[] chars = s.toCharArray();
        String[][] result = new String[numRows][s.length()];
        int i = 0;
        int j = 0;
        for (int index = 0; index < chars.length; index++) {
            result[i][j] = String.valueOf(chars[index]);
            if (i < num && j % num == 0){
                i++;
            }else{
                i--;
                j++;
            }
        }

       return Arrays.toString(result);
        /*StringBuffer sb = new StringBuffer();
        for(int k = 0;k < result.length;k++){
            for(int t = 0;t < result[k].length;t++){
                if(result[k][t] != null) {
                    sb.append(result[k][t]);
                }
            }
        }

        return sb.toString();*/
    }
}
