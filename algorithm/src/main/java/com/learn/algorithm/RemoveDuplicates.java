package com.learn.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2,4, 4, 5, 5};
        removeDuplicates(arr);
    }
    public static int removeDuplicates(int[] nums) {
        //排序
        Arrays.sort(nums);
        int len = nums.length;
        int frist = 0;
        int removeNum = 0 ;
        if(len<=0){
            return 0;
        }
        //当前数组中最大值+1（方便后面排序取值）
        int flag = nums[len-1]+1;
        //当前重复元素值
        int eq = nums[len-1]+1;
        //理解为，first位置不变，看它后面的元素是否等于他，如果相等，改变值，继续循环，直到找到下一个与他不等的元素位置
        for(int second = frist+1;second<len;second++){
            if(nums[second] == eq){
                //如果second元素等于当前重复元素值，则将当前位置置为flag，移除元素+1，frist不变，second由循环指向下一位
                nums[second] = flag;
                removeNum++;
            }else if(nums[second] == nums[frist]){
                //如果frist的元素等于second的元素，则将两个位置置为flag，移除元素+2，frist不变，second由循环指向下一位
                eq = nums[frist];
                nums[frist] = flag;
                nums[second] = flag;
                removeNum= removeNum+2;
            }else{
                //如果都不相等，将frist指针指向second的位置
                frist = second;
            }
        }
        Arrays.sort(nums);
        Arrays.stream(nums).filter(i->i<flag).forEach(System.out::println);
        System.out.println(len-removeNum);
        return len - removeNum;

    }
}
