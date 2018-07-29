package com.github.glzaboy.easysecurity.session.generator;

import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.session.SessionImpl;
import com.github.glzaboy.easysecurity.user.User;

import java.util.UUID;

public class JavaUuidIdSessionGenerator implements SessionGenerator<UUID> {
    public UUID generateId() {
        return UUID.randomUUID();
    }

    public Session<UUID> buildSession(User user) {
        SessionImpl<UUID> uuidSession = new SessionImpl<UUID>(generateId(), user);
        return uuidSession;
    }
}
