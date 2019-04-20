package keyboardteacher;

import java.util.Scanner;

/**
 * Contains some methods that might be helpful for the user
 */
public enum Help {
    INSTANCE;

    /**
     * Prints given message in given color
     *
     * @param color   a color of a message
     * @param message message to be printed
     */
    public void printColoredMessage(ConsoleColors color, String message) {
        System.out.println(color.toString() + message + ConsoleColors.RESET);
    }


    /**
     * Prints some information that might be necessary for user
     */
    public void printUsageInfo() {
        printColoredMessage(
                ConsoleColors.GREEN_BOLD,
                ApplicationConfig.INSTANCE.getValue("usageInfoMessage")
        );

        printColoredMessage(
                ConsoleColors.BLUE_BOLD_BRIGHT,
                ApplicationConfig.INSTANCE.getValue("tutorialMessage")
        );
    }


    /**
     * Waits for user to be ready, if he is not ready,
     */
    public void waitForUserInput() {
        Scanner scanner = new Scanner(System.in);

        printColoredMessage(
                ConsoleColors.PURPLE_BOLD,
                ApplicationConfig.INSTANCE.getValue("areYouReadyMessage")
        );

        String userInput = scanner.nextLine();

        if (userInput.toLowerCase().trim().equals("y")) {
            printColoredMessage(
                    ConsoleColors.PURPLE_BOLD,
                    ApplicationConfig.INSTANCE.getValue("goodLuckInfoMessage")
            );
        } else if (userInput.toLowerCase().trim().equals("n")) {
            printColoredMessage(
                    ConsoleColors.BLUE_BOLD_BRIGHT,
                    ApplicationConfig.INSTANCE.getValue("startAgainInfoMessage")
            );

            System.exit(0);
        } else {
            waitForUserInput();
        }
    }


}

