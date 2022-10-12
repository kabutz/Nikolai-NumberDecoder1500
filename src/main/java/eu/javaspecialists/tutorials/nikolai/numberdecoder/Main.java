package eu.javaspecialists.tutorials.nikolai.numberdecoder;

import java.util.Scanner;

// Move everything into packages

// TODO: Get input from user
// TODO: Determine if input is valid
// TODO: Know when we are at the end
// Convert a single character to the number character
// TODO: Format a bunch of 10 number characters into a USA String (###) ###-####
// TODO: Send the converted phone number somewhere, in this case System.out
// TODO: Test cases for conversion and formatting
// TODO: Performance benchmark for formatting and conversion
public class Main {
    static Scanner sc = new Scanner(System.in);
    static String number;

    public static CharSequence decoder(String num) {

        number = num;
        StringBuilder numba = new StringBuilder();
        CharacterConverter converter = new CharacterConverter();

        if (number.length() == 10) {
            for (int i = 1; i <= 10; i++) {
                if (i == 1)
                    numba.append("(");
                if (i == 4)
                    numba.append(") ");
                if (i == 7)
                    numba.append("-");
                char c = number.charAt(i - 1);
                numba.append(converter.convert(c));
            }


        } else if (number.length() != 10 && !(number.equals("0"))) {
            System.out.println("the Number needs to be 10 digits. Try again:");
            String n = sc.nextLine();

            System.out.println(decoder(n));

        } else if (number.equals("0")) {
            System.exit(0);

        }
        return numba;


    }


    public static void main(String[] args) {

        System.out.println("input phone number(0+enter to exit): ");
        String n = sc.nextLine();

        System.out.println(decoder(n));


    }
}