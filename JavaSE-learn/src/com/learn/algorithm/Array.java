package com.learn.algorithm;

import org.junit.Test;

import java.util.*;

public class Array {
    /**
     * 2021.2.7
     1.给出⼀个⾮负整数数组 a1，a2，a3，…… an，每个整数标识⼀个竖⽴在坐标轴 x 位置的⼀堵⾼度为 ai 的墙，
     2.选择两堵墙，和 x 轴构成的容器可以容纳最多的⽔。
     example:
             Input: [1,8,6,2,5,4,8,3,7]
             Output: 49
     */
    @Test
    public void containWater(){
        int []X = {1,8,6,2,5,4,8,3,7};
        int V = 0;
        int start = 0;
        int end = X.length - 1;
        int high = 0;
        int width = 0;
        int temp = 0;
        //是否可以省去非必要的计算
        for (int i = 0; i < X.length; i++) {
            width = end - start;
            if(width <= 0){
                break;
            }
            if (X[start] < X[end]) {
                high = X[start];
                start++;
            }else{
                high = X[end];
                end--;
            }
            temp = width * high;
            if(temp > V){
                V = temp;
            }
        }
        System.out.println(V);
    }

    /*
    * 给定⼀个数组，要求在这个数组中找出 3 个数之和为 0 的所有组合。List<List<Integer>>
    * */
    @Test
    public void threeSum() {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        Set<List<Integer>> Set = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        Set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        System.out.println(Set);
    }
}
