package eu.javaspecialists.playground.nikolai.phonedecoder;

import static java.lang.Character.*;

public class PhoneNumberDecoderWithNestedIf implements PhoneNumberDecoder {
    @Override
    public String decode(String number) {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            if (i == 1)
                result.append("(");
            if (i == 4)
                result.append(") ");
            if (i == 7)
                result.append("-");
            char c = number.charAt(i - 1);
            if (isDigit(c)) {
                // Actually this is incorrect. there are quite a few
                // characters that are digits, but which are not 0-9,
                // for example in other languages. Thus the following
                // are digits in Java: ०१२३४५६७८९০১২৩ and ႐႑႒႓႔႕႖႗႘႙
                result.append(c);
            } else {
                if (isLowerCase(c)) {
                    c = toUpperCase(c);
                }
                if (c == 'A' || c == 'B' || c == 'C') {
                    result.append('2');
                } else if (c == 'D' || c == 'E' || c == 'F') {
                    result.append('3');
                } else if (c == 'G' || c == 'H' || c == 'I') {
                    result.append('4');
                } else if (c == 'J' || c == 'K' || c == 'L') {
                    result.append('5');
                } else if (c == 'M' || c == 'N' || c == 'O') {
                    result.append('6');
                } else if (c == 'P' || c == 'Q' || c == 'R' || c == 'S') {
                    result.append('7');
                } else if (c == 'T' || c == 'U' || c == 'V') {
                    result.append('8');
                } else if (c == 'W' || c == 'X' || c == 'Y' || c == 'Z') {
                    result.append('9');
                }
            }
        }
        return result.toString();
    }
}
