package eu.javaspecialists.playground.nikolai.phonedecoder;

/**
 * This approach works by minimizing object creation. The only object that we
 * make is the final String, and we make that with a simple +, which is very
 * fast in modern Java.
 */
public class PhoneNumberDecoderWithConverter implements PhoneNumberDecoder {
    private final CharacterConverter converter;

    public PhoneNumberDecoderWithConverter(CharacterConverter converter) {
        this.converter = converter;
    }

    private char convert(String number, int index) {
        return converter.convert(number.charAt(index));
    }

    @Override
    public String decode(String number) {
        int i = 0;
        return "(" + convert(number, i++) + convert(number, i++) + convert(number, i++) + ") "
                + convert(number, i++) + convert(number, i++) + convert(number, i++) + "-"
                + convert(number, i++) + convert(number, i++) + convert(number, i++) + convert(number, i++);
    }

    @Override
    public String toString() {
        return "Converter using " + converter;
    }
}
