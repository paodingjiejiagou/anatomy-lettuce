package com.lerith.anatomy.lettuce.started;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.concurrent.ExecutionException;

/**
 *
 */
public class AsynchronousConnected {
    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create("redis://localhost:6379/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisAsyncCommands<String, String> asyncCommands = connection.async();

        RedisFuture<String> result = asyncCommands.set("key", "Hello, Redis!");
        RedisFuture<String> value = asyncCommands.get("key");
        try {
            System.out.println("value = " + value.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        connection.close();
        redisClient.shutdown();
    }
}
