package keyboardteacher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Teacher {

    private static DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public static void startTeaching(String filePath) {
        File file = new File(filePath);
        Scanner scanner = new Scanner(System.in);
        double totalTime = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\t", "    ");

                System.out.println(line);
                printHintsForWhitespaces(line);

                long startTime = System.nanoTime();
                String userInput = scanner.nextLine();
                long endTime = System.nanoTime();

                int errorIndex = Validator.getFirstErrorIndex(userInput, line);
                Validator.printErrorOccurrence(errorIndex);

                double executionTime = getDurationTimeInSeconds(startTime, endTime);
                printDurationTimeInSeconds(executionTime);
                totalTime += executionTime;
            }

        } catch (IOException e) {
            System.out.println("Something wrong happened while reading a line from given file");
        }

        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Whole typing operation lasted " + decimalFormat.format(totalTime) + " seconds");
    }


    private static void printHintsForWhitespaces(String line) {
        System.out.println(setHintsForWhitespaces(line));
    }


    private static double getDurationTimeInSeconds(long startTime, long endTime) {
        return (double) (endTime - startTime) / 1000000000;
    }


    private static void printDurationTimeInSeconds(double durationTime) {

        String timeSentence =  "It took you " + decimalFormat.format(durationTime) + " seconds to retype the line!";
        System.out.println(ConsoleColors.YELLOW_BOLD + timeSentence + ConsoleColors.RESET);

    }


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
