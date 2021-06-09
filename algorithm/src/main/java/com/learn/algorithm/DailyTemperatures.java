package com.learn.algorithm;

import java.util.*;

/**
* 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
*/
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] T = {89,62,70,58,47,47,46,76,100,70};
        for (int i = 0; i < dailyTemperatures2(T).length; i++) {
            System.out.println(dailyTemperatures2(T)[i]);
        }

    }

    public static int[] dailyTemperatures(int[] T) {

        int[] arr = new int[T.length];
        for (int fri = 0; fri < T.length; fri++) {
            for (int sec = fri+1; sec < T.length; sec++) {
                if(T[sec] > T[fri]){
                    arr[fri] = (sec-fri);
                    break;
                }else if(sec == T.length-1) {
                    arr[fri] = (0);
                }
            }
        }
        return arr;
    }

    public static int[] dailyTemperatures2(int[] T) {

        int[] arr = new int[T.length];
        Stack stack = new Stack();
        for (int i = T.length-1; i >=0 ; i--) {

            int num = 1;
            int flag = 1;
            while(stack.size()>0 && T[i] >= (int)stack.peek()){
                num = num + arr[i+flag];//73, 74, 75, 71, 69, 72, 76, 73
                stack.pop();
                flag = flag + arr[i+flag];
            }
            if(stack.size() == 0){
                stack.push(T[i]);
                arr[i] = 0;
            }else if(T[i] < (int)stack.peek()){
                stack.push(T[i]);
                arr[i] = num;
            }
        }
        return arr;
    }
}
