package eu.javaspecialists.playground.nikolai.phonedecoder;

/**
 * This is quite slow, and ugly.
 */
public class CharacterConverterSwitch implements CharacterConverter {
    @Override
    public char convert(char c) {
        return switch (c) {
            case '0' -> '0';
            case '1' -> '1';
            case 'A', 'B', 'C', 'a', 'b', 'c', '2' -> '2';
            case 'D', 'E', 'F', 'd', 'e', 'f', '3' -> '3';
            case 'G', 'H', 'I', 'g', 'h', 'i', '4' -> '4';
            case 'J', 'K', 'L', 'j', 'k', 'l', '5' -> '5';
            case 'M', 'N', 'O', 'm', 'n', 'o', '6' -> '6';
            case 'P', 'Q', 'R', 'S', 'p', 'q', 'r', 's', '7' -> '7';
            case 'T', 'U', 'V', 't', 'u', 'v', '8' -> '8';
            case 'W', 'X', 'Y', 'Z', 'w', 'x', 'y', 'z', '9' -> '9';
            default -> throw new IllegalArgumentException(
                    "'" + c + "' is an invalid character");
        };
    }

    @Override
    public String toString() {
        return "Switch";
    }
}