package keyboardteacher;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ValidatorTest {

    @Test
    public void testGetFirstErrorIndexMethod() {
        Validator validator = new Validator();

        String userInput = "Well he was smart. He was persistent.";
        String line = "Well he was smart. He was persistent.";
        int expectedResult = validator.getFirstErrorIndex(userInput, line);
        assertEquals(expectedResult, -1);

        String userInput2 = "morningg";
        String line2 = "morning";
        int expectedResult2 = validator.getFirstErrorIndex(userInput2, line2);
        assertEquals(expectedResult2, 7);

        String userInput3 = "";
        String line3 = "Start";
        int expectedResult3 = validator.getFirstErrorIndex(userInput3, line3);
        assertEquals(expectedResult3, 0);

        String userInput4 = "keeeyboardss";
        String line4 = "keyboard";
        int expectedResult4 = validator.getFirstErrorIndex(userInput4, line4);
        assertEquals(expectedResult4, 2);

        String userInput5 = "";
        String line5 = "";
        int expectedResult5 = validator.getFirstErrorIndex(userInput5, line5);
        assertEquals(expectedResult5, -1);

        String userInput6 = "Hello";
        String line6 = "";
        int expectedResult6 = validator.getFirstErrorIndex(userInput6, line6);
        assertEquals(expectedResult6, 0);
    }
}
