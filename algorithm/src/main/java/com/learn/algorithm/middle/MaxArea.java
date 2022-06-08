package com.learn.algorithm.middle;

/**
 * @author lianshun
 * @date 2022/5/3 6:08 下午
 * @description
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 */

public class MaxArea {
    public static void main(String[] args) {
        int []arr = {1,1};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] height) {
       int i = 0;
       int j = height.length - 1;
       int max = 0;

       while (j > i){
           int h = height[i] <= height[j] ? height[i] : height[j];
           if(max < h * (j-i)){
               max = h * (j-i);
           }
           if(height[j] >= height[i]){
               i++;
           }else{
               j--;
           }
       }
       return max;
    }
}
