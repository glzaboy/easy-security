package com.github.glzaboy.easysecurity.session.generator;


import java.io.Serializable;

public interface SessionGenerator<T extends Serializable> {
    T generateId();
}
