package keyboardteacher;

public class Validator {
    public int getFirstErrorIndex(String userInput, String lineFromFile) {
        if (userInput.equals(lineFromFile)) return -1;
        if (userInput.isEmpty() || lineFromFile.isEmpty()) return 0;

        int inputLength = userInput.length();
        int lineLength = lineFromFile.length();

        int i;
        int minLength = Math.min(inputLength, lineLength);
        for (i = 0; i < minLength; ++i) {
            if (userInput.charAt(i) != lineFromFile.charAt(i))
                return i;
        }

        if (inputLength != lineLength) {
            return i;
        } else {
            return -1;
        }
    }

    public void printErrorOccurrence(int errorIndex) {
        if (errorIndex == -1) {
            System.out.println("Congratulations! You typed everything correctly");
        } else {
            System.out.println("Index of the first error that occured is: " + errorIndex);
        }
    }

}
