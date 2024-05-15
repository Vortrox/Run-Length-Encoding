package edu.deakin.sit333;

public class StringRLEAlgorithm {
    public static String compress(String input) {
        if (input.isEmpty()) {
            return "";
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
        throw new UnsupportedOperationException();
    }
}
