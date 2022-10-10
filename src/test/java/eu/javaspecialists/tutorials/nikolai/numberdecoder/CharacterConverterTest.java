package eu.javaspecialists.tutorials.nikolai.numberdecoder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterConverterTest {
    @Test
    public void testGoodCharacters() {
        CharacterConverter converter = new CharacterConverter();
        for (char c = '0'; c <= '9'; c++) {
            assertEquals(c, converter.convert(c));
        }
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
    }

    @Test
    public void testBadCharacters() {
        CharacterConverter converter = new CharacterConverter();
        for (char c = 0; c < 65535; c++) {
            if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c>= 'A' && c <= 'Z') {
                // don't test
            } else {
                char finalC = c;
                assertThrows(IllegalArgumentException.class,
                        () -> converter.convert(finalC),
                        () -> "Incorrectly converted " + finalC + " to " +
                                converter.convert(finalC));
            }
        }
    }
}