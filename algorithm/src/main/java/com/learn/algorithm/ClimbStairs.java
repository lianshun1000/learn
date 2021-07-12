package com.learn.algorithm;

/**
 * @author lianshun
 * @date 2021/6/23 5:48 下午
 * @description
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }

    //递归，时间复杂度相当高
    public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n ==2){
            return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

    //动态规划，使用滚动数组解决
    public int climbStairs2(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;//每次等于前面两个的和
        }
        return r;
    }

}
