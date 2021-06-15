package com.learn.algorithm;

/**
 * @author lianshun
 * @date 2021/6/15 9:17 上午
 * @description
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
      String s = "a ";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        int len = 0;
        char[] charArr = s.toCharArray();

        for (int i = charArr.length-1; i >=0; i--) {
            if(charArr[i] != ' '){
                len++;
            }else if(len==0){
                continue;
            }else {
                break;
            }
        }
        return len;
    }
}
