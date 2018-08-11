package com.github.glzaboy.easysecurity.session.generator;


import java.util.UUID;

public class JavaUuidIdSessionGenerator implements SessionIdGenerator<UUID> {
    public UUID generateId() {
        return UUID.randomUUID();
    }
}
