package eu.javaspecialists.tutorials.nikolai.numberdecoder;

public class CharacterConverter {
    /**
     * Returns a decoded char of the input, where LATIN digits
     * '0'-'9' are returned as-is, [ABC] return '2', [DEF] return '3'
     * [GHI] return '4', [JKL] return '5', [MNO] return '6',
     * [PQRS] return '7', [TUV] return '8' [WXYZ] return '9'.
     * Lower case LATIN characters a-z are also accepted.
     * <p>
     * If c is not one of those characters, we throw an
     * IllegalArgumentException.
     *
     * @param c
     * @return the decoded char
     * @throws IllegalArgumentException if the char is not in the range
     *                                  [0-9a-zA-Z]
     */
    public char convert(char c) {
        if (isDigit(c)) { // '0' - '9'
            return c;
        }
        if (isLowerCase(c)) {
            c = Character.toUpperCase(c);
        }
        if (c == 'A' || c == 'B' || c == 'C') {
            return '2';
        } else if (c == 'D' || c == 'E' || c == 'F') {
            return '3';
        } else if (c == 'G' || c == 'H' || c == 'I') {
            return '4';
        } else if (c == 'J' || c == 'K' || c == 'L') {
            return '5';
        } else if (c == 'M' || c == 'N' || c == 'O') {
            return '6';
        } else if (c == 'P' || c == 'Q' || c == 'R' || c == 'S') {
            return '7';
        } else if (c == 'T' || c == 'U' || c == 'V') {
            return '8';
        } else if (c == 'W' || c == 'X' || c == 'Y' || c == 'Z') {
            return '9';
        }
        throw new IllegalArgumentException("Invalid character: '" + c + "'");
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }
}
