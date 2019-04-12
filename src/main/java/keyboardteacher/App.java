package keyboardteacher;

import java.io.File;

public class App {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Wrong number of arguments - no file path given!");
        } else {
            String filePath = getValidFilePath(args[0]);
            Helper.printUsageInfo();
            Teacher.startTeaching(filePath);
        }
    }

    private static boolean isPathValid(String filePath) {
        File file = new File(filePath);
        return file.exists() && !file.isDirectory();
    }

    private static String getValidFilePath(String filePath) {
        boolean isPathValid = isPathValid(filePath);
        if (!isPathValid) {
            System.out.println("File path is invalid! Try again");
            System.exit(-1);
        }
        return filePath;
    }
}
