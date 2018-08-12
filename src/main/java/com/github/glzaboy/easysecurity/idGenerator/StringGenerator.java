package com.github.glzaboy.easysecurity.idGenerator;

public class StringGenerator implements IdGenerator {

    @Override
    public String generateId() {
        return generateId(36);
    }

    public String generateId(int length) {
        StringBuilder stringTab=new StringBuilder() ;
        stringTab.append("BCEFGHJKMPQRTVWXY2346789");
        stringTab.append("ABCDEFGHJKMNPQRSTUVWXY0123456789abcdefghjkmnrstuvwxyz");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int offset = new Double(Math.random() * 10000).intValue() % stringTab.length();
            stringBuilder.append(stringTab.substring(offset, offset + 1));
        }
        return stringBuilder.toString();
    }


}
