package eu.javaspecialists.playground.nikolai.phonedecoder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CorrectnessTest {
    private static final PhoneNumberDecoder[] decoders = {
            new PhoneNumberDecoderWithNestedIf(),
            new PhoneNumberDecoderWithArray(),
            new PhoneNumberDecoderWithSwitch()
    };

    @Test
    public void testBadNumber() {
        for (PhoneNumberDecoder decoder : decoders) {
            assertFalse(decoder.isValidInput(""));
            assertFalse(decoder.isValidInput("123"));
            assertFalse(decoder.isValidInput("123456"));
            assertFalse(decoder.isValidInput("123456789"));
            assertFalse(decoder.isValidInput("123456789123"));
        }
    }

    private final static String[] goodNumbers = {
            "1234abcdEF",
            "1234567890",
            "ABCDEFGHIJ",
            "KLMNOPQRST",
            "UVWXYZabcd",
            "efghijklmn",
            "opqrstuvwx",
            "yz01234567",
    };

    @Test
    public void testGoodNumber() {

        for (PhoneNumberDecoder decoder : decoders) {
            for (String goodNumber : goodNumbers) {
                assertTrue(decoder.isValidInput(goodNumber));
            }
        }
    }

    @Test
    public void testAllSameResults() {
        for (String number : goodNumbers) {
            String result0 = decoders[0].decode(number);
            for (int i = 1; i < decoders.length; i++) {
                PhoneNumberDecoder decoder = decoders[i];
                String decode = decoder.decode(number);
                assertEquals(result0, decode,
                        "incorrect decoding with " +
                                decoder.getClass().getSimpleName() +
                                " number " + number +
                                " expected " + result0 + " actual " +
                                decode);
            }
        }
    }

    private static final CharacterConverter[] converters = {
            new CharacterConverterArray(),
            new CharacterConverterSwitch(),
            new CharacterConverterWithHashMap()
    };

    @Test
    public void testConverters() {
        for (CharacterConverter converter : converters) {
            // digits
            assertEquals('0', converter.convert('0'));
            assertEquals('1', converter.convert('1'));
            assertEquals('2', converter.convert('2'));
            assertEquals('3', converter.convert('3'));
            assertEquals('4', converter.convert('4'));
            assertEquals('5', converter.convert('5'));
            assertEquals('6', converter.convert('6'));
            assertEquals('7', converter.convert('7'));
            assertEquals('8', converter.convert('8'));
            assertEquals('9', converter.convert('9'));

            // upper case
            assertEquals('2', converter.convert('A'));
            assertEquals('2', converter.convert('B'));
            assertEquals('2', converter.convert('C'));
            assertEquals('3', converter.convert('D'));
            assertEquals('3', converter.convert('E'));
            assertEquals('3', converter.convert('F'));
            assertEquals('4', converter.convert('G'));
            assertEquals('4', converter.convert('H'));
            assertEquals('4', converter.convert('I'));
            assertEquals('5', converter.convert('J'));
            assertEquals('5', converter.convert('K'));
            assertEquals('5', converter.convert('L'));
            assertEquals('6', converter.convert('M'));
            assertEquals('6', converter.convert('N'));
            assertEquals('6', converter.convert('O'));
            assertEquals('7', converter.convert('P'));
            assertEquals('7', converter.convert('Q'));
            assertEquals('7', converter.convert('R'));
            assertEquals('7', converter.convert('S'));
            assertEquals('8', converter.convert('T'));
            assertEquals('8', converter.convert('U'));
            assertEquals('8', converter.convert('V'));
            assertEquals('9', converter.convert('W'));
            assertEquals('9', converter.convert('X'));
            assertEquals('9', converter.convert('Y'));
            assertEquals('9', converter.convert('Z'));

            // lower case
            assertEquals('2', converter.convert('a'));
            assertEquals('2', converter.convert('b'));
            assertEquals('2', converter.convert('c'));
            assertEquals('3', converter.convert('d'));
            assertEquals('3', converter.convert('e'));
            assertEquals('3', converter.convert('f'));
            assertEquals('4', converter.convert('g'));
            assertEquals('4', converter.convert('h'));
            assertEquals('4', converter.convert('i'));
            assertEquals('5', converter.convert('j'));
            assertEquals('5', converter.convert('k'));
            assertEquals('5', converter.convert('l'));
            assertEquals('6', converter.convert('m'));
            assertEquals('6', converter.convert('n'));
            assertEquals('6', converter.convert('o'));
            assertEquals('7', converter.convert('p'));
            assertEquals('7', converter.convert('q'));
            assertEquals('7', converter.convert('r'));
            assertEquals('7', converter.convert('s'));
            assertEquals('8', converter.convert('t'));
            assertEquals('8', converter.convert('u'));
            assertEquals('8', converter.convert('v'));
            assertEquals('9', converter.convert('w'));
            assertEquals('9', converter.convert('x'));
            assertEquals('9', converter.convert('y'));
            assertEquals('9', converter.convert('z'));

            assertThrows(IllegalArgumentException.class, () -> converter.convert('('));
            assertThrows(IllegalArgumentException.class, () -> converter.convert(' '));
            assertThrows(IllegalArgumentException.class, () -> converter.convert(')'));
            assertThrows(IllegalArgumentException.class, () -> converter.convert('_'));
            assertThrows(IllegalArgumentException.class, () -> converter.convert('#'));
            assertThrows(IllegalArgumentException.class, () -> converter.convert('$'));
            assertThrows(IllegalArgumentException.class, () -> converter.convert('१'));
        }
    }
}