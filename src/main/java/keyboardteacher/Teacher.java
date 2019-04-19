package keyboardteacher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Class that contains method that is responsible for handling user input
 */
public class Teacher {

    private static DecimalFormat decimalFormat = new DecimalFormat("#.##");


    /**
     * Reads from line by line, then does necessary operations
     * like getting input from user, checking it and printing information
     *
     * @param filePath path to file that contains lines which user is to retype
     */
    public static void startTeaching(String filePath) {
        File file = new File(filePath);
        Scanner scanner = new Scanner(System.in);
        double totalTypingTime = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\t", "    ");

                System.out.println(line);
                System.out.println(setHintsForWhitespaces(line));

                long startTime = System.nanoTime();
                String userInput = scanner.nextLine();
                long endTime = System.nanoTime();

                int errorIndex = Validator.getFirstErrorIndex(userInput, line);
                Validator.printErrorOccurrence(errorIndex);

                double typingTime = getTypingTime(startTime, endTime);
                printTypingTime(typingTime);

                totalTypingTime += typingTime;
            }

        } catch (IOException e) {
            Help.printColoredMessage(
                    ConsoleColors.RED_BOLD,
                    "Something wrong happened while reading a line from given file"
            );
        }

        Help.printColoredMessage(
                ConsoleColors.BLUE_BOLD_BRIGHT,
                "Whole typing operation lasted " + decimalFormat.format(totalTypingTime) + " seconds"
        );
    }


    /**
     * Returns time that it took user to type given line
     *
     * @param startTime start time of typing
     * @param endTime   end time of typing
     * @return typing time in seconds
     */
    private static double getTypingTime(long startTime, long endTime) {
        return (endTime - startTime) / 1000000000.0;
    }


    /**
     * Prints user typing time in seconds
     *
     * @param typingTime time that it took user to type the line
     */
    private static void printTypingTime(double typingTime) {
        String timeSentence = "It took you " + decimalFormat.format(typingTime) + " seconds to retype the line!";
        System.out.println(ConsoleColors.YELLOW_BOLD + timeSentence + ConsoleColors.RESET);
    }


    /**
     * Returns line that contains some hints for user about whitespaces in line
     *
     * @param line line from a file
     * @return line that contains some hints for user about whitespaces in given line
     * @see Teacher
     */
    public static String setHintsForWhitespaces(String line) {
        StringBuilder whitespaceBuilder = new StringBuilder();
        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == ' ') {
                whitespaceBuilder.append(".");
            } else if (line.charAt(i) == '\n') {
                whitespaceBuilder.append("\\n");
            } else {
                whitespaceBuilder.append(line.charAt(i));
            }
        }
        whitespaceBuilder.append("\\n");

        return whitespaceBuilder.toString();
    }
}
