package com.lerith.anatomy.lettuce.started;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.reactive.RedisStringReactiveCommands;
import reactor.core.publisher.Mono;

public class ReactiveConnected {
    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create("redis://localhost:6379/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisStringReactiveCommands<String, String> reactive = connection.reactive();
        Mono<String> set = reactive.set("key", "value");
        Mono<String> get = reactive.get("key");
        set.subscribe();
        System.out.println("get.block() = " + get.block());
    }
}
