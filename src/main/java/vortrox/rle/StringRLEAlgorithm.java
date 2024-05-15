package vortrox.rle;

public class StringRLEAlgorithm {
    public static String compress(String input) {
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
