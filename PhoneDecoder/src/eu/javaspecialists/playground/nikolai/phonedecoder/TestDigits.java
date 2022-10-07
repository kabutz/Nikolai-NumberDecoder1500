package eu.javaspecialists.playground.nikolai.phonedecoder;

public class TestDigits {
    public static void main(String... args) {
        System.out.println("Look at all these digits in Java");
        for (char c = 0; c < 65535; c++) {
            if (Character.isDigit(c)) {
                System.out.print(c);
            }
        }
        System.out.println();
    }
}
