package com.learn.algorithm.old;

/**
 * @author lianshun
 * @date 2021/6/11 11:22 上午
 * @description
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        removeElement(nums, 2);
    }

    public static int removeElement(int[] nums, int val) {
        int flag = 0;
        int i = 0;
        while (i <= nums.length - flag - 1) {
            if (nums[i] == val) {
                nums[i] = nums[nums.length - flag - 1];
                nums[nums.length - flag - 1] = val;
                flag++;
            }
            if (nums[i] != val) {
                i++;
            }

        }
        for (int j = 0; j < nums.length; j++) {
            System.out.println(nums[j]);
        }
        return nums.length - flag;
    }
}
