package com.learn.juc;

import java.util.concurrent.CompletableFuture;

public class CompetableFutureDemo {
    public static void main(String[] args) throws Exception{
        CompletableFuture completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"没有返回，update sql OK");
        });
        completableFuture.get();

        CompletableFuture completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"有返回，insert sql OK");
            return 1024;
        }).whenComplete((t,u) -> {
            System.out.println("t:"+t);
            System.out.println("u:"+u);
        }).exceptionally(f -> {
            System.out.println("exception:"+f.getMessage());
            return 4;
        });

    }
}
