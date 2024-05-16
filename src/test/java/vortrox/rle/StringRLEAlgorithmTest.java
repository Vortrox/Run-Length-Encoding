package vortrox.rle;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class StringRLEAlgorithmTest {
    public static class CompressionAlgorithmTests {
        @Test
        public void test1APassCompress_aabb_a2b2() {
            assertEquals("a2b2", StringRLEAlgorithm.compress("aabb"));
        }

        @Test
        public void test2APassCompress_abbb_ab3() {
            assertEquals("ab3", StringRLEAlgorithm.compress("abbb"));
        }

        @Test
        public void test3APassCompress_aaab_a3b() {
            assertEquals("a3b", StringRLEAlgorithm.compress("aaab"));
        }

        @Test
        public void test4APassCompress_abcde_abcde() {
            assertEquals("abcde", StringRLEAlgorithm.compress("abcde"));
        }

        @Test
        public void test5APassCompress_aabbccddee_a2b2c2d2e2() {
            assertEquals("a2b2c2d2e2", StringRLEAlgorithm.compress("aabbccddee"));
        }

        @Test
        public void test6APassCompress_aaaabaaaa_a4ba4() {
            assertEquals("a4ba4", StringRLEAlgorithm.compress("aaaabaaaa"));
        }

        @Test
        public void test7APassCompress_aaaa_a4() {
            assertEquals("a4", StringRLEAlgorithm.compress("aaaa"));
        }

        @Test
        public void test8APassCompressEmptyString() {
            assertEquals("", StringRLEAlgorithm.compress(""));
        }

        @Test
        public void test9APassCompressSingleLetter() {
            assertEquals("a", StringRLEAlgorithm.compress("a"));
        }

        @Test
        public void test10AFailCompressInvalidChar() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.compress("#"));
        }

        @Test
        public void test11AFailCompressInvalidCharAtStart() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.compress("#aaaa"));
        }

        @Test
        public void test12AFailCompressInvalidCharAtEnd() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.compress("aaaa#"));
        }

        @Test
        public void test13AFailCompressInvalidCharAtMid() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.compress("aa#aa"));
        }

        @Test
        public void test14AFailCompressCapitalLetter() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.compress("A"));
        }

        @Test
        public void test15AFailCompressCapitalLetterAtStart() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.compress("Aaaaa"));
        }

        @Test
        public void test16AFailCompressCapitalLetterAtEnd() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.compress("aaAaa"));
        }

        @Test
        public void test17AFailCompressCapitalLetterAtMid() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.compress("aaaaA"));
        }
    }

    public static class DecompressionAlgorithmTests {
        @Test
        public void test1BPassDecompress_a2b2_aabb() {
            assertEquals("aabb", StringRLEAlgorithm.decompress("a2b2"));
        }

        @Test
        public void test2BPassDecompress_ab3_abbb() {
            assertEquals("abbb", StringRLEAlgorithm.decompress("ab3"));
        }

        @Test
        public void test3BPassDecompress_a3b_aaab() {
            assertEquals("aaab", StringRLEAlgorithm.decompress("a3b"));
        }

        @Test
        public void test4BPassDecompress_abcde_abcde() {
            assertEquals("abcde", StringRLEAlgorithm.decompress("abcde"));
        }

        @Test
        public void test5BPassDecompress_a2b2c2d2e2_aabbccddee() {
            assertEquals("aabbccddee", StringRLEAlgorithm.decompress("a2b2c2d2e2"));
        }

        @Test
        public void test6BPassDecompress_a4ba4_aaaabaaaa() {
            assertEquals("aaaabaaaa", StringRLEAlgorithm.decompress("a4ba4"));
        }

        @Test
        public void test7BPassDecompress_a4_aaaa() {
            assertEquals("aaaa", StringRLEAlgorithm.decompress("a4"));
        }

        @Test
        public void test8BPassDecompressEmptyString() {
            assertEquals("", StringRLEAlgorithm.decompress(""));
        }

        @Test
        public void test9BPassDecompressSingleLetter() {
            assertEquals("a", StringRLEAlgorithm.decompress("a"));
        }

        @Test
        public void test10BFailDecompressInvalidChar() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.decompress("#"));
        }

        @Test
        public void test11BFailDecompressInvalidCharAtStart() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.decompress("#a4"));
        }

        @Test
        public void test12BFailDecompressInvalidCharAtEnd() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.decompress("a4#"));
        }

        @Test
        public void test13BFailDecompressInvalidCharAtMid() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.decompress("a2#a2"));
        }

        @Test
        public void test14BFailDecompressCapitalLetter() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.decompress("A"));
        }

        @Test
        public void test15BFailDecompressCapitalLetterAtStart() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.decompress("Aa4"));
        }

        @Test
        public void test16BFailDecompressCapitalLetterAtMid() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.decompress("a2Aa2"));
        }

        @Test
        public void test17BFailDecompressCapitalLetterAtEnd() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.decompress("a4A"));
        }

        @Test
        public void test18BFailDecompressStartsWithNumber() {
            assertThrows(UnsupportedOperationException.class, () -> StringRLEAlgorithm.decompress("2a2b"));
        }
    }

    public static class CrossCheckTests {
        @Test
        public void test1CCrossCheckCompress_aabb() {
            String input = "aabb";
            assertEquals(AlternativeRLE.runLengthEncode(input), StringRLEAlgorithm.compress(input));
        }

        @Test
        public void test2CCrossCheckCompress_abbb() {
            String input = "abbb";
            assertEquals(AlternativeRLE.runLengthEncode(input), StringRLEAlgorithm.compress(input));
        }

        @Test
        public void test3CCrossCheckCompress_aaab() {
            String input = "aaab";
            assertEquals(AlternativeRLE.runLengthEncode(input), StringRLEAlgorithm.compress(input));
        }

        @Test
        public void test4CCrossCheckCompress_abcde() {
            String input = "abcde";
            assertEquals(AlternativeRLE.runLengthEncode(input), StringRLEAlgorithm.compress(input));
        }

        @Test
        public void test5CCrossCheckCompress_aabbccddee() {
            String input = "aabbccddee";
            assertEquals(AlternativeRLE.runLengthEncode(input), StringRLEAlgorithm.compress(input));
        }

        @Test
        public void test6CCrossCheckCompress_aaaabaaaa() {
            String input = "aaaabaaaa";
            assertEquals(AlternativeRLE.runLengthEncode(input), StringRLEAlgorithm.compress(input));
        }

        @Test
        public void test7CCrossCheckCompress_aaaa() {
            String input = "aaaa";
            assertEquals(AlternativeRLE.runLengthEncode(input), StringRLEAlgorithm.compress(input));
        }

        @Test
        public void test8CCrossCheckCompress_a() {
            String input = "a";
            assertEquals(AlternativeRLE.runLengthEncode(input), StringRLEAlgorithm.compress(input));
        }


        @Test
        public void test1DCrossCheckDecompress_a2b2() {
            String input = "a2b2";
            assertEquals(AlternativeRLE.runLengthDecode(input), StringRLEAlgorithm.decompress(input));
        }

        @Test
        public void test2DCrossCheckDecompress_ab3() {
            String input = "ab3";
            assertEquals(AlternativeRLE.runLengthDecode(input), StringRLEAlgorithm.decompress(input));
        }

        @Test
        public void test3DCrossCheckDecompress_a3b() {
            String input = "a3b";
            assertEquals(AlternativeRLE.runLengthDecode(input), StringRLEAlgorithm.decompress(input));
        }

        @Test
        public void test4DCrossCheckDecompress_abcde() {
            String input = "abcde";
            assertEquals(AlternativeRLE.runLengthDecode(input), StringRLEAlgorithm.decompress(input));
        }

        @Test
        public void test5DCrossCheckDecompress_a2b2c2d2e2() {
            String input = "a2b2c2d2e2";
            assertEquals(AlternativeRLE.runLengthDecode(input), StringRLEAlgorithm.decompress(input));
        }

        @Test
        public void test6DCrossCheckDecompress_a4ba4() {
            String input = "a4ba4";
            assertEquals(AlternativeRLE.runLengthDecode(input), StringRLEAlgorithm.decompress(input));
        }

        @Test
        public void test7DCrossCheckDecompress_a4() {
            String input = "a4";
            assertEquals(AlternativeRLE.runLengthDecode(input), StringRLEAlgorithm.decompress(input));
        }

        @Test
        public void test8DCrossCheckDecompress_a() {
            String input = "a";
            assertEquals(AlternativeRLE.runLengthDecode(input), StringRLEAlgorithm.decompress(input));
        }
    }

    public static class InverseOperationTests {
        @Test
        public void test1EInverseCheckCompress_aabb() {
            String input = "aabb";
            String result = StringRLEAlgorithm.compress(input);
            String inverseResult = StringRLEAlgorithm.decompress(result);

            assertEquals(input, inverseResult);
        }

        @Test
        public void test2EInverseCheckCompress_abbb() {
            String input = "abbb";
            String result = StringRLEAlgorithm.compress(input);
            String inverseResult = StringRLEAlgorithm.decompress(result);

            assertEquals(input, inverseResult);
        }

        @Test
        public void test3EInverseCheckCompress_aaab() {
            String input = "aaab";
            String result = StringRLEAlgorithm.compress(input);
            String inverseResult = StringRLEAlgorithm.decompress(result);

            assertEquals(input, inverseResult);
        }

        @Test
        public void test4EInverseCheckCompress_abcde() {
            String input = "abcde";
            String result = StringRLEAlgorithm.compress(input);
            String inverseResult = StringRLEAlgorithm.decompress(result);

            assertEquals(input, inverseResult);
        }

        @Test
        public void test5EInverseCheckCompress_aabbccddee() {
            String input = "aabbccddee";
            String result = StringRLEAlgorithm.compress(input);
            String inverseResult = StringRLEAlgorithm.decompress(result);

            assertEquals(input, inverseResult);
        }

        @Test
        public void test6EInverseCheckCompress_aaaabaaaa() {
            String input = "aaaabaaaa";
            String result = StringRLEAlgorithm.compress(input);
            String inverseResult = StringRLEAlgorithm.decompress(result);

            assertEquals(input, inverseResult);
        }

        @Test
        public void test7EInverseCheckCompress_aaaa() {
            String input = "aaaa";
            String result = StringRLEAlgorithm.compress(input);
            String inverseResult = StringRLEAlgorithm.decompress(result);

            assertEquals(input, inverseResult);
        }

        @Test
        public void test8EInverseCheckCompress_a() {
            String input = "a";
            String result = StringRLEAlgorithm.compress(input);
            String inverseResult = StringRLEAlgorithm.decompress(result);

            assertEquals(input, inverseResult);
        }


        @Test
        public void test1FInverseCheckDecompress_a2b2() {
            String input = "a2b2";
            String result = StringRLEAlgorithm.decompress(input);
            String inverseResult = StringRLEAlgorithm.compress(result);

            assertEquals(input, inverseResult);
        }

        @Test
        public void test2FInverseCheckDecompress_ab3() {
            String input = "ab3";
            String result = StringRLEAlgorithm.decompress(input);
            String inverseResult = StringRLEAlgorithm.compress(result);

            assertEquals(input, inverseResult);
        }

        @Test
        public void test3FInverseCheckDecompress_a3b() {
            String input = "a3b";
            String result = StringRLEAlgorithm.decompress(input);
            String inverseResult = StringRLEAlgorithm.compress(result);

            assertEquals(input, inverseResult);
        }

        @Test
        public void test4FInverseCheckDecompress_abcde() {
            String input = "abcde";
            String result = StringRLEAlgorithm.decompress(input);
            String inverseResult = StringRLEAlgorithm.compress(result);

            assertEquals(input, inverseResult);
        }

        @Test
        public void test5FInverseCheckDecompress_a2b2c2d2e2() {
            String input = "a2b2c2d2e2";
            String result = StringRLEAlgorithm.decompress(input);
            String inverseResult = StringRLEAlgorithm.compress(result);

            assertEquals(input, inverseResult);
        }

        @Test
        public void test6FInverseCheckDecompress_a4ba4() {
            String input = "a4ba4";
            String result = StringRLEAlgorithm.decompress(input);
            String inverseResult = StringRLEAlgorithm.compress(result);

            assertEquals(input, inverseResult);
        }

        @Test
        public void test7FInverseCheckDecompress_a4() {
            String input = "a4";
            String result = StringRLEAlgorithm.decompress(input);
            String inverseResult = StringRLEAlgorithm.compress(result);

            assertEquals(input, inverseResult);
        }

        @Test
        public void test8FInverseCheckDecompress_a() {
            String input = "a";
            String result = StringRLEAlgorithm.decompress(input);
            String inverseResult = StringRLEAlgorithm.compress(result);

            assertEquals(input, inverseResult);
        }
    }
}