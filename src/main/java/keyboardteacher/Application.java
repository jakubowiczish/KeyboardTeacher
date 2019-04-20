package keyboardteacher;

import java.io.File;

/**
 * Main program class, contains main method
 */
public class Application {

    public static void main(String[] args) {
        validateUserInput(args);
        Help.printUsageInfo();
        Help.waitForUserInput();
        Teacher.startTeaching(args[0]);
    }


    private static boolean isPathValid(String filePath) {
        File file = new File(filePath);
        return file.exists() && !file.isDirectory();
    }


    private static void validateUserInput(String[] input) {
        if (input.length == 0) {
            Help.printColoredMessage(
                    ConsoleColors.RED_BOLD,
                    "Wrong number of arguments - no file path given!"
            );

            System.exit(-1);
        }

        if (!isPathValid(input[0])) {
            Help.printColoredMessage(
                    ConsoleColors.RED_BOLD,
                    "File path is invalid! Try again"
            );

            System.exit(-1);
        }
    }
}
