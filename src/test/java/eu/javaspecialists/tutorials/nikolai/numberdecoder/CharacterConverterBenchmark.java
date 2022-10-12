package eu.javaspecialists.tutorials.nikolai.numberdecoder;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@Fork(3)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 10, time = 1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class CharacterConverterBenchmark {
    private final CharacterConverter converter = new CharacterConverter();
    private final char[] digits = "0123456789".toCharArray();
    private final char[] upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final char[] lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final char[] badLetters = "!@#$%^&*()ßåπø∑१२३४५".toCharArray();

    @Benchmark
    public void convertGoodDigits(Blackhole bh) {
        testGoodConversion(digits, bh);
    }

    @Benchmark
    public void convertGoodUpperCaseLetters(Blackhole bh) {
        testGoodConversion(upperCaseLetters, bh);
    }

    @Benchmark
    public void convertGoodLowerCaseLetters(Blackhole bh) {
        testGoodConversion(lowerCaseLetters, bh);
    }

    private void testGoodConversion(char[] digits, Blackhole bh) {
        for (char goodLetter : digits) {
            bh.consume(converter.convert(goodLetter));
        }
    }

    @Benchmark
    public void convertBadLetters(Blackhole bh) {
        for (char badLetter : badLetters) {
            try {
                char convert = converter.convert(badLetter);
                throw new AssertionError(
                        "Should have failed with char '" + convert + "'");
            } catch (Exception e) {
                bh.consume(e);
            }
        }
    }
}