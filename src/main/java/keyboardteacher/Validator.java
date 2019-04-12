package keyboardteacher;

import java.util.ArrayList;
import java.util.Random;

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
            printSuccessMessage();
        } else {
            printPositionOfError(errorIndex);
            System.out.println(ConsoleColors.RED_BOLD + "First error at index: " + errorIndex + ConsoleColors.RESET);
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


    private static void printSuccessMessage() {
        ArrayList<String> successMessages = new ArrayList<>() {
            {
                add("Congrats!\n");
                add("Keep it up!\n");
                add("BANG!!!\n");
                add("One more champ!\n");
                add("Go on!\n");
                add("Good for you!\n");
            }
        };

        Random random = new Random();
        int randomIndex = random.nextInt(successMessages.size());
        System.out.println(ConsoleColors.GREEN_BOLD + successMessages.get(randomIndex) + ConsoleColors.RESET);
    }

}
