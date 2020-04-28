package com.lerith.anatomy.lettuce.started;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 *
 */
public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        System.out.println("Current state: " + completableFuture.isDone());
        completableFuture.complete("my value");
        System.out.println("Current state: " + completableFuture.isDone());
        System.out.println("Got value: " + completableFuture.get());

    }
}
