package keyboardteacher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Teacher {

    public static void startTeaching(String filePath) {
        File file = new File(filePath);
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                printHintsForWhitespaces(line);

                String userInput = scanner.nextLine();

                int errorIndex = Validator.getFirstErrorIndex(userInput, line);
                Validator.printErrorOccurrence(errorIndex);
            }

        } catch (IOException e) {
            System.out.println("Something wrong happened while reading a line from given file");
        }
    }


    private static void printHintsForWhitespaces(String line) {
        System.out.println(setHintsForWhitespaces(line));
    }


    public static String setHintsForWhitespaces(String line) {
        StringBuilder whitespaceBuilder = new StringBuilder();
        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == ' ') {
                whitespaceBuilder.append(".");
            } else if (line.charAt(i) == '\t') {
                whitespaceBuilder.append(setDashes(i)).append(">");
            } else if (line.charAt(i) == '\n') {
                whitespaceBuilder.append("\\n");
            } else {
                whitespaceBuilder.append(line.charAt(i));
            }
        }
        whitespaceBuilder.append("\\n");

        return whitespaceBuilder.toString();
    }

    private static String setDashes(int index) {
        String dashes;
        String dash = "-";

        if (index == 0) {
            dashes = dash.repeat(7);
        } else {
            dashes = dash.repeat(index + index % 4 - 1);
        }

        return dashes;
    }
}
