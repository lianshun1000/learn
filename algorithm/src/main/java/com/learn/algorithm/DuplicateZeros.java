package com.learn.algorithm;

import java.util.Arrays;
import java.util.Collections;

public class DuplicateZeros {
    public static void main(String[] args) {

       //[1,5,2,0,6,8,0,6,0]
       //[1,5,2,0,0,6,8,0,0]
       int[] arr = {8,4,5,0,0,0,0,7};
       duplicateZeros(arr);
    }

    public static void duplicateZeros(int[] arr) {
        int first = 0;
        int second = arr.length-1;
        int flag = 0;
        while (first < second){
            if(arr[first] == 0){
                arr[second] = 0;
                first ++;
                second --;
                flag ++;
            }else{
                first++;
            }
        }
     //[1,5,2,0,0,6,8,0,0]
        if(flag != 0) {
            reverse(arr,flag);
            int len = arr.length - 1 - flag;
            int pointA = len;
            int pointB = arr.length - 1;
            while (pointA > 0 && flag != 0) {
                if (arr[pointA] == 0) {
                    arr[pointB - 1] = 0;
                    pointA--;
                    flag --;
                    pointB -= 2;
                } else {
                    arr[pointB] = arr[pointA];
                    arr[pointA] = 0;
                    pointA--;
                    pointB--;
                }
            }
            reverse(arr,0);
        }

        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void reverse(int[] a,int flag) {
        for(int start=0,end=a.length-1-flag;start<end;start++,end--) {
            int temp=a[start];
            a[start]=a[end];
            a[end]=temp;
        }
    }

}
