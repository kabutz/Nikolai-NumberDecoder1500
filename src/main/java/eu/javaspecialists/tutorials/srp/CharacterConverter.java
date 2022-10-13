package eu.javaspecialists.tutorials.srp;

import static java.lang.Character.*;

public class CharacterConverter {
    public char convert(char c) {
        if (isDigit(c)) {
            return c;
        } else {
            if (isLowerCase(c)) {
                c = toUpperCase(c);
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
            } else {
                throw new IllegalArgumentException(
                        "Character '" + c + "' is not allowed");
            }
        }

    }
}
