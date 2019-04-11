package keyboardteacher;

public class Validator {
    private static int getFirstErrorIndex(String userInput, String lineFromFile) {
        if (userInput.equals(lineFromFile)) return -1;
        if (userInput.isEmpty()) return 0;

        int inputLength = userInput.length();
        int lineLength = lineFromFile.length();

        int i;
        int minLength = Math.min(inputLength, lineLength);
        for (i = 0; i < minLength; ++i) {
            if (userInput.charAt(i) != lineFromFile.charAt(i))
                return i;
        }

        if (inputLength != lineLength) {
            return i + 1;
        } else {
            return -1;
        }
    }

}
