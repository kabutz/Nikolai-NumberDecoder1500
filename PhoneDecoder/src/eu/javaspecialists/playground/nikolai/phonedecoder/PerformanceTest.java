package eu.javaspecialists.playground.nikolai.phonedecoder;

import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * We need to convert this to a proper JMH benchmark, but
 * I still have to show you how to do that :-)
 */
public class PerformanceTest {
    private static final char[] alphabet = new char[10 + 26 * 2];
    private static String leak;

    static {
        for (int i = 0; i < 10; i++) {
            alphabet[i] = (char) ('0' + i);
        }
        for (int i = 0; i < 26; i++) {
            alphabet[i + 10] = (char) ('A' + i);
        }
        for (int i = 0; i < 26; i++) {
            alphabet[i + 36] = (char) ('a' + i);
        }
    }

    public static void main(String... args) {
        System.out.println("Testing performance:");

        String[] numbers = generateRandomStrings(100_000);
        for (int i = 0; i < 10; i++) {
            test(new PhoneNumberDecoderWithConverter(new CharacterConverterArray()), numbers);
            test(new PhoneNumberDecoderWithConverter(new CharacterConverterWithHashMap()), numbers);
            test(new PhoneNumberDecoderWithConverter(new CharacterConverterSwitch()), numbers);
            test(new PhoneNumberDecoderWithNestedIf(), numbers);
            System.out.println();
        }
    }

    private static String[] generateRandomStrings(int numberOfStrings) {
        String[] strings = new String[numberOfStrings];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = generateRandomString();
        }
        return strings;
    }

    private static String generateRandomString() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        char[] chars = new char[10];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = alphabet[current.nextInt(alphabet.length)];
        }
        return new String(chars);
    }

    private static void test(PhoneNumberDecoder decoder, String[] numbers) {
        System.out.print(decoder);
        var running = new AtomicBoolean(true);
        var timer = Executors.newSingleThreadScheduledExecutor();
        timer.schedule(() -> {
            running.set(false);
            timer.shutdown();
        }, 1, TimeUnit.SECONDS);
        long decodes = 0;
        int index = 0;
        while (running.get()) {
            leak = decoder.decode(numbers[index++]);
            if (index == numbers.length) index = 0;
            decodes++;
        }
        System.out.printf(Locale.US, " %,d%n", decodes);
    }
}