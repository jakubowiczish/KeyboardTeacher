package keyboardteacher;

import java.util.Scanner;

/**
 * Contains some methods that might be helpful for the user
 */
public final class Help {
    private Help() {
    }


    /**
     * Prints given message in given color
     *
     * @param color   a color of a message
     * @param message message to be printed
     */
    public static void printColoredMessage(ConsoleColors color, String message) {
        System.out.println(color.toString() + message + ConsoleColors.RESET);
    }


    /**
     * Prints some information that might be necessary for user
     */
    public static void printUsageInfo() {
        printColoredMessage(ConsoleColors.GREEN_BOLD, getUsageInfo());
        printColoredMessage(ConsoleColors.BLUE_BOLD_BRIGHT, getTutorialText());
    }


    /**
     * Waits for user to be ready, if he is not ready,
     */
    public static void waitForUserInput() {
        Scanner scanner = new Scanner(System.in);

        printColoredMessage(ConsoleColors.PURPLE_BOLD, getAreYouReadyText());
        String userInput = scanner.nextLine();

        if (userInput.toLowerCase().trim().equals("y")) {
            printColoredMessage(ConsoleColors.PURPLE_BOLD, getGoodLuckInfo());
        } else if (userInput.toLowerCase().trim().equals("n")) {
            printColoredMessage(ConsoleColors.BLUE_BOLD_BRIGHT, getStartAgainText());
            System.exit(0);
        } else {
            waitForUserInput();
        }
    }


    private static String getUsageInfo() {
        return "\nThis program is dedicated to help you" +
                " improve your typing skills!\n";
    }


    private static String getAreYouReadyText() {
        return "Are you ready?\ny/n\n";
    }


    private static String getStartAgainText() {
        return "Start again when you're ready!\n";
    }


    private static String getTutorialText() {
        return "Before we start let me tell you something\n\n" +
                "As soon as you start, you will see 2 lines until every line from file is processed\n" +
                "First one is just a regular line from given file\n" +
                "Second one is line with whitespaces highlighted - in order to help you type everything correctly!\n" +
                "In second line you may sometimes see these strange symbols\n" +
                "they'll tell you what to type when there is whitespace character somewhere in the text\n" +
                "\".\" stands for space\n" +
                "\"--->\" stands for tab\n" +
                "\"\\n\" stands for new line - that's when you ought to hit enter button.\n";
    }


    private static String getGoodLuckInfo() {
        return "\nLet's go champ! Good luck!\n";
    }
}

