package vortrox.rle;

import java.util.regex.Pattern;

public class StringRLEAlgorithm {
    public static String compress(String input) {
        if (input.isEmpty()) {
            return "";
        }

        if (!Pattern.matches("^[a-z]+$", input)) {
            throw new UnsupportedOperationException("Invalid format");
        }

        StringBuilder output = new StringBuilder(input.length());
        char lastChar = input.charAt(0);
        output.append(lastChar);
        int runLength = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != lastChar) {
                if (runLength > 1) {
                    output.append(runLength);
                }

                output.append(input.charAt(i));
                runLength = 0;
            }

            runLength++;
            lastChar = input.charAt(i);
        }

        if (runLength > 1) {
            output.append(runLength);
        }

        return output.toString();
    }

    public static String decompress(String input) {
        StringBuilder output = new StringBuilder();
        // Assumes that the first character in the input will be a letter
        char lastLetter = input.charAt(0);
        output.append(lastLetter);
        StringBuilder digits = new StringBuilder();

        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                digits.append(c);
            } else {
                if (digits.length() > 0) {
                    // Append the last letter n - 1 times to the end of the output
                    for (int j = 0; j < Integer.parseInt(digits.toString()); j++) {
                        output.append(lastLetter);
                    }
                }

                digits = new StringBuilder();
                lastLetter = c;
                output.append(lastLetter);
            }
        }

        // Append the last letter n - 1 times to the end of the output
        for (int j = 1; j < Integer.parseInt(digits.toString()); j++) {
            output.append(lastLetter);
        }

        return output.toString();
    }
}
