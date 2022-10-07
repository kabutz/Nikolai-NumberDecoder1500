package eu.javaspecialists.playground.nikolai.phonedecoder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Here we store all the important characters in a hash map. It takes a bit
 * of time to set up, but then it is fairly fast, but not as quick as the
 * {@link CharacterConverterArray}.
 */
public class CharacterConverterWithHashMap implements CharacterConverter {
    private static final Map<Character, Character> converterMap =
            new ConcurrentHashMap<>();

    static {
        for (int i = 0; i < 10; i++) {
            converterMap.put((char) ('0' + i), (char) ('0' + i));
        }
        String alphabet = "22233344455566677778889999";
        for (int i = 0; i < alphabet.length(); i++) {
            converterMap.put((char) ('a' + i), alphabet.charAt(i));
            converterMap.put((char) ('A' + i), alphabet.charAt(i));
        }
    }

    @Override
    public char convert(char c) {
        Character result = converterMap.get(c);
        if (result == null)
            throw new IllegalArgumentException(
                    "'" + c + "' is an invalid character");
        return result;
    }
}