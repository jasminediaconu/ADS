package practice;

import org.junit.jupiter.api.Test;
import practice.WordLadderProblem.WordLadderProblem;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordLadderProblemTest {

    @Test
    public void testWordLadder() {
        ArrayList<String> dictionary = new ArrayList<>(Arrays.asList("poon", "plee", "same", "poie", "plea", "plie", "poin"));
        assertEquals(7, WordLadderProblem.wordLadderProblem(dictionary, "toon", "plea"));
    }
}
