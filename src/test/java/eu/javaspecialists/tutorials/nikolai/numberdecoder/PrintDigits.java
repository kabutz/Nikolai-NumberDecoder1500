package eu.javaspecialists.tutorials.nikolai.numberdecoder;

public class PrintDigits {
    public static void main(String[] args) {
        for (int i = 0; i < 65536; i++) {
            if (Character.isDigit(i)) {
                System.out.print((char)i);
            }
        }
        System.out.println();
    }
}
