package com.learn.algorithm;

/**
 * @author lianshun
 * @date 2021/6/11 11:32 上午
 * @description
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 *
 * 可以使用KPM等算法
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issipi"));
    }

    public static int strStr(String haystack, String needle) {
        int result = -1;
       if("".equals(needle)){
           return 0;
       }
       if(haystack.length()<needle.length()){
           return result;
       }

       char[] hay = haystack.toCharArray();
       char[] nee = needle.toCharArray();
       for (int i = 0; i < hay.length; i++) {
           if(haystack.length()-i>=needle.length()&&nee[0] == hay[i]){
               result = i;
               for (int j = 0; j < nee.length; j++) {
                   if (i+j<hay.length && nee[j] != hay[i+j]) {
                       result = -1;
                       break;
                   }
               }
           }
           if(result == i){
               return result;
           }
        }

       return result;
    }
}
