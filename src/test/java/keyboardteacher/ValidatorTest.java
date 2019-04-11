package keyboardteacher;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ValidatorTest {

    @Test
    public void testGetFirstErrorIndexMethod() {
        Validator validator = new Validator();

        String line = "Well he was smart. He was persistent.";
        String userInput = "Well he was smart. He was persistent.";
        int expectedResult = validator.getFirstErrorIndex(userInput, line);
        assertEquals(expectedResult, -1);

        String line2 = "morning";
        String userInput2 = "morningg";
        int expectedResult2 = validator.getFirstErrorIndex(userInput2, line2);
        assertEquals(expectedResult2, 7);

        String line3 = "Start";
        String userInput3 = "";
        int expectedResult3 = validator.getFirstErrorIndex(userInput3, line3);
        assertEquals(expectedResult3, 0);

        String line4 = "keyboard";
        String userInput4 = "keeeyboardss";
        int expectedResult4 = validator.getFirstErrorIndex(userInput4, line4);
        assertEquals(expectedResult4, 2);
    }
}
