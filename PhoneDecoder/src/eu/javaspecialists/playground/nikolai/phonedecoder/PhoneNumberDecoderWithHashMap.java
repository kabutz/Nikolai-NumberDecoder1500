package eu.javaspecialists.playground.nikolai.phonedecoder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PhoneNumberDecoderWithHashMap extends PhoneNumberDecoderWithConverter {
    public PhoneNumberDecoderWithHashMap() {
        super(new CharacterConverterWithHashMap());
    }
}
