package keyboardteacher;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Class responsible for user input validation
 */
public class Validator {
    public static final int NO_ERROR = -1;


    /**
     * Finds index of first error that might have occurred in user input
     * if there is no error, returns NO_ERROR
     *
     * @param userInput    String value representing user input
     * @param lineFromFile String value - a single line from a file
     * @return Index of first error that occurred,
     * if there is no error, returns NO_ERROR: -1
     * @see Validator
     */
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


    /**
     * Prints error message or success message, depending whether there is some error found
     *
     * @param errorIndex index of the error, if there is no error, prints success message
     * @see Validator
     */
    public static void printErrorOccurrence(int errorIndex) {
        if (errorIndex == NO_ERROR) {
            printSuccessMessage();
        } else {
            printPositionOfError(errorIndex);
            Help.INSTANCE.printColoredMessage(
                    ConsoleColors.RED_BOLD,
                    "First error at index: " + errorIndex
            );
        }
    }


    /**
     * Prints arrow that points on an error
     *
     * @param errorIndex index of the error
     */
    private static void printPositionOfError(int errorIndex) {
        StringBuilder errorPlacement = new StringBuilder();
        for (int i = 0; i < errorIndex; ++i) {
            errorPlacement.append(" ");
        }
        errorPlacement.append("\u2191");

        Help.INSTANCE.printColoredMessage(
                ConsoleColors.RED_BOLD,
                errorPlacement.toString()
        );
    }


    /**
     * Prints some random message for user saying that he typed everything correctly
     */
    private static void printSuccessMessage() {
        List<String> successMessages = Arrays.asList(
                "Congrats!\n",
                "Keep it up!\n",
                "BANG!!!\n",
                "One more champ!\n",
                "Go on!\n",
                "Good for you!\n"
        );


        Random random = new Random();
        int randomIndex = random.nextInt(successMessages.size());

        Help.INSTANCE.printColoredMessage(
                ConsoleColors.GREEN_BOLD,
                successMessages.get(randomIndex)
        );
    }

}
