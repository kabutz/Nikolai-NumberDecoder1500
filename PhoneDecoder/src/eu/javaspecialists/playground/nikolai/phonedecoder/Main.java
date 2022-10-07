package eu.javaspecialists.playground.nikolai.phonedecoder;

import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input 10-digit alphanumeric phone number (empty to exit): ");

        PhoneNumberDecoder decoder = new PhoneNumberDecoderWithArray();
        while (sc.hasNextLine()) {
            String n = sc.nextLine();
            if (n.isBlank()) return;
            if (!decoder.isValidInput(n)) {
                System.out.println("Input needs to be 10 characters in range [0-9A-Z]!");
            } else {
                System.out.println("Decoded number is: " + decoder.decode(n));
            }
        }
    }
}