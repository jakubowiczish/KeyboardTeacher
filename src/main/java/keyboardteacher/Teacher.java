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
        Validator validator = new Validator();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String userInput = scanner.nextLine();
                int errorIndex = validator.getFirstErrorIndex(userInput, line);
                validator.printErrorOccurrence(errorIndex);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
