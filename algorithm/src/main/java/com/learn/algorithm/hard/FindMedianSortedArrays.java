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
        int[] nums1 = {3};
        int[] nums2 = {-2,-1};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] arr1;
        int[] arr2;
        if(nums1.length == 0){
            nums1 = nums2;
        }
        if(nums2.length == 0){
            nums2 = nums1;
        }
        if(nums1.length == 1 && nums2.length ==1){
            return (nums1[0]+nums2[0])/2.0;
        }
        if(nums1.length>=nums2.length){
            arr1 = nums1;
            arr2 = nums2;
        }else{
            arr1 = nums2;
            arr2 = nums1;
        }
        int m = arr1.length;
        int n = arr2.length;
        int k;
        if ((m + n) % 2 == 0) {
            k = (m + n) / 2;
        } else {
            k = (m + n - 1) / 2;
        }

        int i = 0;
        int j = 0;
        int flag = 0;
        double result = 0.;
        while (i + j <= k) {
            if ((i < m && arr1[i] <= arr2[j])||(j>=n)) {
                if ((m + n) % 2 == 0) {
                    result = (arr1[i] + flag) / 2.0;
                } else {
                    result = arr1[i];
                }
                flag = arr1[i];
                i++;
            } else {
                if ((m + n) % 2 == 0) {
                    result = (arr2[j] + flag) / 2.0;
                } else {
                    result = arr2[j];
                }
                flag = arr2[j];
                j++;
            }
        }
        return result;
    }
}
