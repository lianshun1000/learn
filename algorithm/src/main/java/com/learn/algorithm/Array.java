package com.learn.algorithm;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import cn.hutool.core.lang.Assert;


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

    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};

        final List<List<Integer>> results = threeSumBestPractice(nums);
        results.forEach(x -> System.out.println(x));
    }
    /**
     * counter: 放每个元素出现的此时 <br>
     * unique: unique 元素 <br>
     * core: 元素被使用的次数
     *
     * @param nums
     * @return
     */

    public static List<List<Integer>> threeSumBestPractice(int[] nums) {
        Assert.notNull(nums);

        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        HashMap<Integer, Integer> counter = new HashMap<>(size);

        Arrays.stream(nums)
                .forEach(
                        num -> {
                            counter.compute(
                                    num,
                                    (k, v) -> {
                                        Integer val = Optional.ofNullable(v).orElse(0);
                                        return ++val;
                                    });
                        });

        final List<Integer> unique = counter.keySet().stream().collect(Collectors.toList());

        unique.sort(Integer::compareTo);

        // calculate
        for (int i = 0; i < unique.size(); i++) {
            // third
            if (unique.get(i) == 0 && counter.get(0) >= 3) {
                result.add(Arrays.asList(0, 0, 0));
            }

            for (int j = i + 1; j < unique.size(); j++) {
                // twice
                if (2 * unique.get(i) + unique.get(j) == 0 && counter.get(unique.get(i)) >= 2) {
                    result.add(Arrays.asList(unique.get(i), unique.get(i), unique.get(j)));
                }

                if (2 * unique.get(j) + unique.get(i) == 0 && counter.get(unique.get(j)) >= 2) {
                    result.add(Arrays.asList(unique.get(i), unique.get(j), unique.get(j)));
                }

                // once
                int repair = 0 - unique.get(i) - unique.get(j);
                if (repair > unique.get(j) && counter.getOrDefault(repair, 0) > 0) {
                    result.add(Arrays.asList(unique.get(i), unique.get(j), repair));
                }
            }
        }

        return result;
    }
}
