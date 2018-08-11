package com.github.glzaboy.easysecurity.session.generator;


import java.io.Serializable;

public interface SessionIdGenerator<T extends Serializable> {
    T generateId();
}
