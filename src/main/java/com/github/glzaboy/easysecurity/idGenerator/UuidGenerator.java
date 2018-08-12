package com.github.glzaboy.easysecurity.idGenerator;


import java.util.UUID;

public class UuidGenerator implements IdGenerator {
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
