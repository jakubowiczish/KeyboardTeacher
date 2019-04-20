package keyboardteacher;

import java.io.File;

/**
 * Main program class, contains main method
 */
public class Application {

    public static void main(String[] args) {
        validateUserInput(args);
        Help.INSTANCE.printUsageInfo();
        Help.INSTANCE.waitForUserInput();
        Teacher.startTeaching(args[0]);
    }


    private static boolean isPathValid(String filePath) {
        File file = new File(filePath);
        return file.exists() && !file.isDirectory();
    }


    private static void validateUserInput(String[] input) {
        if (input.length == 0) {
            Help.INSTANCE.printColoredMessage(
                    ConsoleColors.RED_BOLD,
                    ApplicationConfig.INSTANCE.getValue("wrongNumberOfArgumentsMessage")
            );

            System.exit(-1);
        }

        if (!isPathValid(input[0])) {
            Help.INSTANCE.printColoredMessage(
                    ConsoleColors.RED_BOLD,
                    ApplicationConfig.INSTANCE.getValue("invalidPathMessage")
            );

            System.exit(-1);
        }
    }
}
