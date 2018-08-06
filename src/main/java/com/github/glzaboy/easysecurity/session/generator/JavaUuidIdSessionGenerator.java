package com.github.glzaboy.easysecurity.session.generator;


import java.util.UUID;

public class JavaUuidIdSessionGenerator implements SessionGenerator<UUID> {
    public UUID generateId() {
        return UUID.randomUUID();
    }
}
