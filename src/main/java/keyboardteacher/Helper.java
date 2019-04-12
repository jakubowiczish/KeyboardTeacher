package keyboardteacher;

public class Helper {

    public static void printUsageInfo() {
        System.out.println(getUsageInfo());
    }

    private static String getUsageInfo() {
        String usageInfo =
                "This program is dedicated to help you" +
                        " improve your typing skills!\n\n";

        String tutorialText = "Before we start let me tell you something\n\n" +
                "As soon as you start, you will see 2 lines until every line from file is processed\n" +
                "First one is just a regular line from given file\n" +
                "Second one is line with whitespaces highlighted - in order to help you type everything correctly!\n" +
                "In second line you may sometimes see these strange symbols\n - " +
                "they'll tell you what to type when there is whitespace character somewhere in the text\n" +
                "\".\" stands for space\n" +
                "\"--->\" stands for tab\n" +
                "\"\\n\" - that's when you ought to hit enter button.\n\n" +
                "Let's begin champ! Good luck!\n";

        return usageInfo + tutorialText;
    }
}
