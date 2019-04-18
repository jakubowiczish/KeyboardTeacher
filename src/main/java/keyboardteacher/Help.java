package keyboardteacher;

public final class Help {
    private Help() {
    }


    public static void printUsageInfo() {
        printColoredMessage(ConsoleColors.GREEN_BOLD, getUsageInfo());
        printColoredMessage(ConsoleColors.BLUE_BOLD_BRIGHT, getTutorialText());
        printColoredMessage(ConsoleColors.PURPLE_BOLD, getGoodLuckInfo());
    }


    private static String getUsageInfo() {
        return "\nThis program is dedicated to help you" +
                " improve your typing skills!\n";
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


    public static void printColoredMessage(ConsoleColors color, String message) {
        System.out.println(color.toString() + message + ConsoleColors.RESET);
    }
}

