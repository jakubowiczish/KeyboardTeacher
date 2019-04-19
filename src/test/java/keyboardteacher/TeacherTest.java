package keyboardteacher;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TeacherTest {

    @Test
    public void setHintsForWhitespacesTest() {
        assertEquals(
                "Good.morning\\n",
                Teacher.setHintsForWhitespaces("Good morning")
        );

        assertNotEquals(
                "Hey...yy",
                Teacher.setHintsForWhitespaces("Hey  yy")
        );
    }
}
