package keyboardteacher;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ValidatorTest {

    @Test
    public void inputTheSameAsLine_shouldReturnNO_ERROR() {
        assertEquals(
                Validator.NO_ERROR,
                Validator.getFirstErrorIndex(
                        "Well he was smart. He was persistent.",
                        "Well he was smart. He was persistent."
                )
        );
    }


    @Test
    public void inputLongerThanLine_shouldReturnErrorAtIndex7() {
        assertEquals(
                7,
                Validator.getFirstErrorIndex(
                        "morningg",
                        "morning"
                )
        );
    }


    @Test
    public void inputEmpty_shouldReturnErrorAtIndex0() {
        assertEquals(
                0,
                Validator.getFirstErrorIndex(
                        "",
                        "Start"
                )
        );
    }


    @Test
    public void inputSignificantlyDifferent_shouldReturnErrorAtIndex2() {
        assertEquals(
                2,
                Validator.getFirstErrorIndex(
                        "keeeybisedss",
                        "keyboard"
                )
        );
    }


    @Test
    public void bothInputAndLineEmpty_shouldReturnNO_ERROR() {
        assertEquals(
                Validator.NO_ERROR,
                Validator.getFirstErrorIndex(
                        "",
                        ""
                )
        );
    }


    @Test
    public void lineEmpty_shouldReturnErrorAtIndex0() {
        assertEquals(
                0,
                Validator.getFirstErrorIndex(
                        "Hello",
                        ""
                )
        );
    }
}
