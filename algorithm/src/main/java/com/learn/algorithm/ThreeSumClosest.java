package com.learn.algorithm;

import java.util.Arrays;
import java.util.Optional;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {4, -1, -4, 4};
        int target = -1;
        System.out.println(threeSumClosest(nums,target));

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);//-4,-1,1,2
        int result = 99999;
        int minComp = 9999;
        final int size = nums.length;
        for (int i = 0; i < size-2; i++) {
            int baseVal = nums[i];
            int secPr = size - 1;
            int firPr = i + 1;

            while (secPr > firPr) {
                int comp = target - baseVal - nums[firPr] - nums[secPr];
                if(comp == 0){
                    result = target;
                    return result;
                }
                if(comp < 0){
                    if(abs(comp) < abs(minComp)){
                        minComp = comp;
                        result = baseVal + nums[firPr] + nums[secPr];
                    }
                    secPr --;
                }
                if(comp > 0){
                    if(abs(comp) < abs(minComp)){
                        minComp = comp;
                        result = baseVal + nums[firPr] + nums[secPr];
                    }
                    firPr ++;
                }
            }
        }
        return result;
    }

    public static int abs(int num){
        if(num >= 0){
            return num;
        }else {
            return 0 - num;
        }
    }
}
