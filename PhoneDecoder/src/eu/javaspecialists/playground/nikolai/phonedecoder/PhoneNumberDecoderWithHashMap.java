package eu.javaspecialists.playground.nikolai.phonedecoder;

public class PhoneNumberDecoderWithHashMap extends PhoneNumberDecoderWithConverter {
    public PhoneNumberDecoderWithHashMap() {
        super(new CharacterConverterWithHashMap());
    }
}
