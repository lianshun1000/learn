package com.learn.algorithm.hard;

/**
 * @author lianshun
 * @date 2022/2/27 3:51 下午
 * @description 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length == 0){
            if(nums1.length%2 == 0){
                return (nums1[nums1.length/2] + nums1[nums1.length/2 - 1])/2.0d;
            }
            return nums1[nums1.length/2];
        }
        if(nums1.length == 0){
            if(nums2.length%2 == 0){
                return (nums2[nums2.length/2] + nums2[nums2.length/2 - 1])/2.0d;
            }
            return nums2[nums2.length/2];
        }
        if(nums1.length == 1 && nums2.length == 1){
            return (nums1[0] + nums2[0])/2.0d;
        }
        int size = nums1.length + nums2.length;
        int count = 0;
        int flag = size / 2;
        int i = 0;
        int j = 0;
        int pre = 0;
        int current = 0;
        while (count <= flag) {
            pre = current;
            if(i>=nums1.length){
                current = nums2[j++];
            }else if(j >= nums2.length){
                current = nums1[i++];
            }
            else if(i<nums1.length && j< nums2.length && nums1[i] == nums2[j]){
                if(i<j){
                    current = nums1[i++];
                }else{
                    current = nums2[j++];
                }
            }else if(i < nums1.length && nums1[i] < nums2[j]){
                current = nums1[i++];
            }else if(j < nums2.length && nums2[j] < nums1[i]){
                current = nums2[j++];
            }
            count++;
        }

        if(size%2 == 0){
            return (pre + current)/2.0d;
        }
        return current;
    }
}
