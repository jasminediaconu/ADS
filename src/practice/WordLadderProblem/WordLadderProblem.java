package practice.WordLadderProblem;

import java.util.*;

public class WordLadderProblem {
    /**
     * Given a dictionary, and two words ‘start’ and ‘target’ (both of same length).
     * Find length of the smallest chain from ‘start’ to ‘target’ if it exists,
     * such that adjacent words in the chain only differ by one character and each word
     * in the chain is a valid word i.e., it exists in the dictionary.
     * It may be assumed that the ‘target’ word exists in dictionary and length of all
     * dictionary words is same.
     *
     * @param dictionary
     * @param start
     * @param target
     * @return
     */

    public static int wordLadderProblem(ArrayList<String> dictionary, String start, String target) {
        return find(dictionary, start, target);
    }

    public static int find(ArrayList<String> dictionary, String start, String target) {
        if(!dictionary.contains(target)) return 0;

        int level = 0, wordLength = start.length();

        // Push the starting word into the queue
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            level++;

            int currSize = queue.size();

            for (int i = 0; i < currSize; i++) {

                // Remove the first word from the queue
                char[] word = queue.peek().toCharArray();
                queue.remove();

                // For every character of the word
                for (int pos = 0; pos < wordLength; pos++) {
                    // Retain the original character
                    // at the current position
                    char orig_char = word[pos];

                    // Replace the current character with
                    // every possible lowercase alphabet
                    for (char c = 'a'; c <= 'z'; ++c)
                    {
                        word[pos] = c;

                        // If the new word is equal
                        // to the target word
                        if (String.valueOf(word).equals(target))
                            return level + 1;

                        // Remove the word from the set
                        // if it is found in it
                        if (dictionary.contains(String.valueOf(word))) {
                            dictionary.remove(String.valueOf(word));

                            // And push the newly generated word
                            // which will be a part of the chain
                            queue.add(String.valueOf(word));
                        }
                    }

                    // Restore the original character
                    // at the current position
                    word[pos] = orig_char;
                }
            }
        }
        return 0;
    }
}
