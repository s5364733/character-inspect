package match;

import org.huifeng.execise.match.RemovedCharacterMatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author jack.liang
 */
public class RemovedCharacterMatchTests {
    private RemovedCharacterMatch stringProcessor;

    @BeforeEach
    void setUp() {
        stringProcessor = new RemovedCharacterMatch();
    }

    @Test
    void testNullInput() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            stringProcessor.prepareLaunch(null);
        });
        assertEquals("Input is not null!", exception.getMessage());
    }


    @Test
    void testBasicReplacement() {
        String input = "aabcccbbad";
        String expected = "d";
        String result = stringProcessor.prepareLaunch(input);
        assertEquals(expected, result, "Consecutive identical characters should be replaced by the previous character.");
    }



}
