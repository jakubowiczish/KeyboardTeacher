package keyboardteacher;

public class Validator {
    public static final int NO_ERROR = -1;

    public static int getFirstErrorIndex(String userInput, String lineFromFile) {
        if (userInput.isEmpty() && lineFromFile.isEmpty()) return NO_ERROR;
        if (userInput.isEmpty() || lineFromFile.isEmpty()) return 0;

        int inputLength = userInput.length();
        int lineLength = lineFromFile.length();

        int minLength = Math.min(inputLength, lineLength);
        for (int i = 0; i < minLength; ++i) {
            if (userInput.charAt(i) != lineFromFile.charAt(i))
                return i;
        }

        if (inputLength != lineLength) {
            return minLength;
        }

        return NO_ERROR;
    }


    public static void printErrorOccurrence(int errorIndex) {
        if (errorIndex == NO_ERROR) {
            System.out.println("Congratulations! You typed everything correctly");
        } else {
            printPositionOfError(errorIndex);
            System.out.println("Index of the first error that occurred is: " + errorIndex);
        }
    }

    private static void printPositionOfError(int errorIndex) {
        StringBuilder errorPlacement = new StringBuilder();
        for (int i = 0; i < errorIndex; ++i) {
            errorPlacement.append(" ");
        }
        errorPlacement.append("\u2191");

        System.out.println(errorPlacement.toString());

    }

}
