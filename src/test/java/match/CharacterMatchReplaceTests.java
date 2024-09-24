package match;

import org.huifeng.execise.match.ReplaceCharacterMatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CharacterMatchReplaceTests {

    private ReplaceCharacterMatch stringProcessor;

    @BeforeEach
    void setUp() {
        stringProcessor = new ReplaceCharacterMatch();
    }

    @Test
    void testNullInput() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            stringProcessor.prepareLaunch(null);
        });
        assertEquals("Input is not null!", exception.getMessage());
    }

    @Test
    void testNoReplacementNeeded() {
        String input = "abcdef";
        String result = stringProcessor.prepareLaunch(input);
        assertEquals(input, result, "If no consecutive characters exist, result should remain the same.");
    }

    @Test
    void testBasicReplacement() {
        String input = "aabbbccc";
        String expected = "b";
        String result = stringProcessor.prepareLaunch(input);
        assertEquals(expected, result, "Consecutive identical characters should be replaced by the previous character.");
    }

    @Test
    void testMultipleReplacements() {
        String input = "aaa";
        String expected = ""; // All characters should eventually be replaced
        String result = stringProcessor.prepareLaunch(input);
        assertEquals(expected, result, "Recursive replacement should lead to an empty string.");
    }

    @Test
    void testEdgeCases_singleChar() {
        String input = "a";
        String result = stringProcessor.prepareLaunch(input);
        assertEquals("a", result, "Single character should not change.");
    }

    @Test
    void testEdgeCases_twoChars() {
        String input = "aa";
        String result = stringProcessor.prepareLaunch(input);
        assertEquals("aa", result, "Two identical characters should not be replaced.");
    }

    @Test
    void testLargeInput() {
        String input = "abcccbad";
        String expected = "d";
        String result = stringProcessor.prepareLaunch(input);
        assertEquals(expected, result, "Multiple sets of consecutive characters should be processed.");
    }
}
