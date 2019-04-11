package keyboardteacher;

public class App {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Wrong number of arguments - no file path given!");
        } else {
            String filePath = args[0];
            Teacher teacher = new Teacher();
            teacher.teach(filePath);
        }
    }



}
