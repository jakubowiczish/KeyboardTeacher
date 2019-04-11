package keyboardteacher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Wrong number of arguments - no file path given!");
        } else {
            String filePath = args[1];
            File file = new File(filePath);

            Scanner scanner = new Scanner(System.in);

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String userInput = scanner.nextLine();

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
