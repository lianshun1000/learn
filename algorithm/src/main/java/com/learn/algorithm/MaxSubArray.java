package com.learn.algorithm;

/**
 * @author lianshun
 * @date 2021/6/14 6:32 下午
 * @description
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class MaxSubArray {
    public static void main(String[] args) {
      int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        if(nums.length==0){
            return nums[0];
        }
        int point =1;
        int max = nums[0];
        int result = nums[0];
        while (point<nums.length){
            if(result>0) {
                result += nums[point];
            }else if(result<nums[point] && point<nums.length-1){
                result = nums[point];
            }else if(result>nums[point]){
                point++;
                result = nums[point];
            }
            if(result>max){
                max = result;
            }
            point++;
        }


        return max;
    }
}
