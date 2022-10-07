package eu.javaspecialists.playground.nikolai.phonedecoder;

public interface CharacterConverter {
    /**
     * Converts the char to the correct phone number digit,
     * for example '0' stays '0', but 'A' becomes 2.
     *
     * @throws IllegalArgumentException if the character is
     *                                  neither Latin digit
     *                                  nor Latin characters a-zA-Z.
     */
    char convert(char c);
}
