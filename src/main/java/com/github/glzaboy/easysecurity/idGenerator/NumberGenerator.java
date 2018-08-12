package com.github.glzaboy.easysecurity.idGenerator;

import java.util.Random;

public class NumberGenerator implements IdGenerator {
    private static final String RANDOM_NUM_GENERATOR_ALGORITHM_NAME = "SHA1PRNG";
    private Random random;

    public NumberGenerator() {
        super();
        try {
            this.random = java.security.SecureRandom.getInstance(RANDOM_NUM_GENERATOR_ALGORITHM_NAME);
        } catch (java.security.NoSuchAlgorithmException e) {
            this.random = new java.security.SecureRandom();
        }
    }

    public String generateId() {
        return Long.toString(random.nextLong());
    }
}
