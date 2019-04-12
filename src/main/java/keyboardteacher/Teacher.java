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
        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == ' ') {
                System.out.print(".");
            } else if (line.charAt(i) == '\t') {
                System.out.print("--->");
            } else if (line.charAt(i) == '\n') {
                System.out.print("\\n");
            } else {
                System.out.print(line.charAt(i));
            }
        }
        System.out.println("\\n");
    }
}
