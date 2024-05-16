package edu.deakin.sit333;

import java.util.Collections;

public class AlternativeRLE {
    /**
     * Example Java implementation of the run-length-encode algorithm. The code has been adapted to use the same RLE
     * format used by the rest of this software (with numbers going after the letters instead of before).
     * The original source can be viewed at: https://www.baeldung.com/java-rle-compression
     *
     * @author Kai Yuan
     */
    public static String runLengthEncode(String input) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (i + 1 < chars.length && c == chars[i + 1]) {
                count++;
            } else {
                result.append(c);
                if (count > 1) {
                    result.append(count);
                }
                count = 1;
            }
        }
        return result.toString();
    }

    /**
     * Java implementation of the run-length-decode algorithm by Kai Yuan but heavily modified to use the same RLE
     * format used by the rest of this software (with numbers going after the letters instead of before). I made the
     * modifications after viewing the problem through as a finite-state-machine which made it much easier to create
     * from a conceptual standpoint.
     * The original source can be viewed at: https://www.baeldung.com/java-rle-compression
     */
    public static String runLengthDecode(String rle) {
        StringBuilder result = new StringBuilder();
        char[] chars = rle.toCharArray();

        int count = 0;
        int state = 1;
        char lastLetter = 0;
        char prevChar = 0;
        for (char c : chars) {
            if (state == 1) {
                if (Character.isDigit(c)) {
                    count = Character.getNumericValue(c);
                    lastLetter = prevChar;
                    state = 2;
                } else {
                    result.append(c);
                }
            } else {
                if (Character.isDigit(c)) {
                    count = 10 * count + Character.getNumericValue(c);
                } else {
                    result.append(String.join("", Collections.nCopies(count - 1, String.valueOf(lastLetter)))).append(c);
                    count = 0;
                    state = 1;
                }
            }
            prevChar = c;
        }

        if (state == 2) {
            result.append(String.join("", Collections.nCopies(count - 1, String.valueOf(lastLetter))));
        }

        return result.toString();
    }
}
