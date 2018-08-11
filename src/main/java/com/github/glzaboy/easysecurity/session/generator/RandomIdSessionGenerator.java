package com.github.glzaboy.easysecurity.session.generator;

import java.util.Random;

public class RandomIdSessionGenerator implements SessionIdGenerator<String> {
    private static final String RANDOM_NUM_GENERATOR_ALGORITHM_NAME = "SHA1PRNG";
    private Random random;

    public RandomIdSessionGenerator() {
        try {
            this.random = java.security.SecureRandom.getInstance(RANDOM_NUM_GENERATOR_ALGORITHM_NAME);
        } catch (java.security.NoSuchAlgorithmException e) {
//            log.debug("The SecureRandom SHA1PRNG algorithm is not available on the current platform.  Using the " +
//                    "platform's default SecureRandom algorithm.", e);
            this.random = new java.security.SecureRandom();
        }
    }

    public String generateId() {
        return Long.toString(random.nextLong());
    }
}
