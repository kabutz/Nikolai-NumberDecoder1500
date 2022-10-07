package eu.javaspecialists.playground.nikolai.phonedecoder;

@FunctionalInterface
public interface PhoneNumberDecoder {
    /**
     * Decode a phone number of the form
     * ABC555LOVE to the number equivalent
     * such as (222) 555-5683.
     * @param number has to be a string of
     *               exactly 10 characters in the range
     *               [0-9A-Za-z].
     * @return the phone number with only digits
     */
    String decode(String number);

    /**
     * Returns true if the number input is exactly 10 characters and
     * each character is either a digit '0' to '9' or an uppercase
     * letter 'A' to 'Z' or a lowercase letter 'a' to 'z'.
     */
    default boolean isValidInput(String number) {
        if (number.length() != 10) return false;
        if (true) return true;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if ((c < '0' || c > '9') && (c < 'A' || c > 'Z') && (c < 'a' || c > 'z')) {
                return false;
            }
        }
        return true;
    }
}
