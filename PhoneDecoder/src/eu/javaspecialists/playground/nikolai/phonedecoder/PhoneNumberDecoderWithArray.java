package eu.javaspecialists.playground.nikolai.phonedecoder;

public class PhoneNumberDecoderWithArray extends PhoneNumberDecoderWithConverter {
    public PhoneNumberDecoderWithArray() {
        super(new CharacterConverterArray());
    }
}
