package com.learn.algorithm;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = 0;
        int t = 1;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }

    //算法超时，非优解
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int start = 0;
        int end = start + k > nums.length - 1 ? nums.length - 1 : start + k;
        if (nums.length <= 1) {
            return false;
        }
        if (k == 0) {
            return false;
        }
        while (end <= nums.length - 1) {
            int[] newArray = Arrays.copyOfRange(nums, start, end + 1);
            if (start == 0) {
                Arrays.sort(newArray);
                for (int i = 0; i < newArray.length - 1; i++) {
                    long r = (long) nums[i + 1] - (long) nums[i];
                    if (r >= Integer.MAX_VALUE || r <= Integer.MIN_VALUE) {
                        return false;
                    }
                    if (newArray[i + 1] - newArray[i] <= t) {
                        return true;
                    }
                }
            } else {
                if (newArray[newArray.length - 1] == nums[end] && newArray[newArray.length - 1] - newArray[newArray.length - 2] <= t) {
                    long r = (long) nums[newArray.length - 1] - (long) nums[newArray.length - 2];
                    if (r >= Integer.MAX_VALUE || r <= Integer.MIN_VALUE) {
                        return false;
                    }
                    return true;
                }
                if (newArray[0] == nums[end] && newArray[1] - newArray[0] <= t) {
                    long r = (long) nums[1] - (long) nums[0];
                    if (r >= Integer.MAX_VALUE || r <= Integer.MIN_VALUE) {
                        return false;
                    }
                    return true;
                }
                for (int i = 1; i < newArray.length - 1; i++) {
                    if (newArray[i] == nums[end] && (newArray[i] - newArray[i - 1] <= t || newArray[i + 1] - newArray[i] <= t)) {
                        long r1 = (long) nums[i + 1] - (long) nums[i];
                        long r2 = (long) nums[i] - (long) nums[i - 1];
                        if ((r1 >= Integer.MAX_VALUE || r1 <= Integer.MIN_VALUE) && (r2 >= Integer.MAX_VALUE || r2 <= Integer.MIN_VALUE)) {
                            return false;
                        }
                        return true;
                    }
                }
            }
            start++;
            end++;
        }
        return false;
    }

}
