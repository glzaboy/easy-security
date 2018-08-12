package com.github.glzaboy.easysecurity.session.generator;

public class RandStringSessionIdGenerator implements SessionIdGenerator<String> {
    public RandStringSessionIdGenerator() {
        super();
    }

    @Override
    public String generateId() {
        StringBuilder stringTab=new StringBuilder() ;
        stringTab.append("BCEFGHJKMPQRTVWXY2346789");
        stringTab.append("ABCDEFGHJKMNPQRSTUVWXY0123456789abcdefghjkmnrstuvwxyz");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 36; i++) {
            int offset = new Double(Math.random() * 10000).intValue() % stringTab.length();
            stringBuilder.append(stringTab.substring(offset, offset + 1));
        }
        return stringBuilder.toString();
    }
}
