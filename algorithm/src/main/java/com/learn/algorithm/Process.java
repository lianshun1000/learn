package com.learn.algorithm;

/**
 * 在只包含 3，5，7，这三个质因子的从小到大的数列里，返回第n个
 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21，25，27....
 *  9  3*3        5
 *  15 3*5        6
 *  21 3*7        7
 *  25 5*5        8
 *  27 3*3*3      9
 *  35 5*7
 * 示例 1:
 * 输入: k = 5
 * 输出: 9
 */
public class Process {
    public static void main(String[] args) {
        System.out.println(process(1));
        System.out.println(process(2));
        System.out.println(process(3));
        System.out.println(process(4));
        System.out.println(process(5));
        System.out.println(process(6));
        System.out.println(process(7));
        System.out.println(process(8));
        System.out.println(process(9));
        System.out.println(process(10));



    }

    public static int process(int n) {
        int num = 1;
        int[] p = new int[n];
        p[0] = 1;
        int p3 = 0;
        int p5 = 0;
        int p7 = 0;
        while (num < n){
            int min1 = Math.min(p[p3]*3,p[p5]*5);
            int min2 = Math.min(p[p7]*7,p[p5]*5);
            int min = Math.min(min1,min2);
            p[num] = min;
            while(p[p3]*3<=p[num]){
                p3++;
            }
            while(p[p5]*5<=p[num]){
                p5++;
            }
            while(p[p7]*7<=p[num]){
                p7++;
            }
            num++;
        }
        int res = p[num-1];
        return res;
    }
}
