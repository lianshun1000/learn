package com.learn.algorithm;

/**
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * <p>
 * 0
 * 01  2
 * 0110  3
 * 0110 1001   6
 * 0110 1001 1001 0110  11
 * 0110 1001 1001 0110 1001 0110 0110 1001
 * 0110 1001 1001 0110 1001 0110 0110 1001 1001 0110 0110 1001 0110 1001 1001 0110
 */
public class KthGrammar {
    public static void main(String[] args) {
        System.out.println(Integer.highestOneBit(6) << 1);
    }

    public static int kthGrammar(int N, int K) {
        N = Integer.highestOneBit(K) << 1;
        int num = K - (2 >> (N - 1));
        int parentK = 1;
        for (int i = 2; i < N; i++) {

        }
        if ((parentK == 1 && K % 2 == 1) || (parentK == 0 && K % 2 == 0)) {
            return 1;
        } else {
            return 0;
        }
    }

}
