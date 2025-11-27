package org.simpleframework.xml.transform;

class CharacterTransform implements Transform<Character> {
    public Character read(String str) {
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new InvalidFormatException("Cannot convert '%s' to a character", str);
    }

    public String write(Character ch) {
        return ch.toString();
    }
}
