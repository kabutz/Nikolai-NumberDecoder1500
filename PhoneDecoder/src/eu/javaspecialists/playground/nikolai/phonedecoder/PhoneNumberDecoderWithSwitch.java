package eu.javaspecialists.playground.nikolai.phonedecoder;

/**
 * This approach works by minimizing object creation. The only object that we
 * make is the final String, and we make that with a simple +, which is very
 * fast in modern Java.
 */
public final class PhoneNumberDecoderWithSwitch extends PhoneNumberDecoderWithConverter {
    public PhoneNumberDecoderWithSwitch() {
        super(new CharacterConverterSwitch());
    }
}
