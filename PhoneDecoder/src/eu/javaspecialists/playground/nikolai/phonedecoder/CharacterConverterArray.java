package eu.javaspecialists.playground.nikolai.phonedecoder;

/**
 * Not surprisingly, this is the fastest conversion.
 */
public class CharacterConverterArray implements CharacterConverter {
    private static final char[] CONVERTER =
            "22233344455566677778889999".toCharArray();

    @Override
    public char convert(char c) {
        if (c >= 'a' && c <= 'z') return CONVERTER[c - 'a'];
        if (c >= 'A' && c <= 'Z') return CONVERTER[c - 'A'];
        if (c >= '0' && c <= '9') return c;
        throw new IllegalArgumentException("'" + c + "' is an invalid character");
    }
}