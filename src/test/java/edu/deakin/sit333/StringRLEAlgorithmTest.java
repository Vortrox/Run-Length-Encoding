package edu.deakin.sit333;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringRLEAlgorithmTest {
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

    // todo: separate compress and decompress tests
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