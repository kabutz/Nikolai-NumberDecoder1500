package eu.javaspecialists.tutorials.srp;

import java.util.Scanner;

import static java.lang.Character.*;

// TODO: Read input from user
// TODO: Determine if we are at the end
// TODO: Validating the input (is it 10 characters)
// DONE: Convert each character 0-9 -> 0-9, A-C -> 2, D-F -> 3, etc.
// TODO: Format the final String
// TODO: Send the final String somewhere, for example System.out
// TODO: Test cases for the conversion and validation
// TODO: Performance benchmark for conversion options
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