package keyboardteacher;

import java.io.File;

/**
 * Main program class, contains main method
 */
public class App {

    public static void main(String[] args) {
        validateNumberOfArguments(args);

        String filePath = getValidFilePath(args[0]);

        Help.printUsageInfo();
        Help.waitForUserInput();

        Teacher.startTeaching(filePath);
    }


    private static boolean isPathValid(String filePath) {
        File file = new File(filePath);
        return file.exists() && !file.isDirectory();
    }


    private static String getValidFilePath(String filePath) {
        boolean isPathValid = isPathValid(filePath);

        if (!isPathValid) {
            Help.printColoredMessage(
                    ConsoleColors.RED_BOLD,
                    "File path is invalid! Try again"
            );

            System.exit(-1);
        }

        return filePath;
    }


    private static void validateNumberOfArguments(String[] args) {
        if (args.length == 0) {
            Help.printColoredMessage(
                    ConsoleColors.RED_BOLD,
                    "Wrong number of arguments - no file path given!"
            );

            System.exit(-1);
        }
    }



}
