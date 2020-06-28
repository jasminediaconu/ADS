package exam.FinalA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * In this assignment, you are expected to implement the MSD (most-significant-digit-first)
 * index sort algorithm to sort a sequence of words in non-decreasing alphabetic order.
 *
 * For example, if the content of the input array is [pig, cat, parrot, monkey],
 * the content of the output array should be [cat, monkey, parrot, pig].
 *
 * You may assume that every String in the input array only contains of the lowercase letters
 * (meaning the 26 letters a through z in the English alphabet).
 *
 * Your algorithm needs to run in O(n⋅l) time, where n is the number of items to sort and l
 * is the average length of a word.
 *
 * If null is passed as argument, radixSortMSD should throw a NullPointerException.
 */
public class RadixSort {
    /**
     * Sorts a list of words using MSD index sort.
     *
     * @param words
     *     The list of words to sort.
     * @return The sorted list of words.
     * @throws NullPointerException
     *     If `words` equals `null`.
     */
    public static List<String> radixSortMSD(List<String> words) {
        if(words == null) throw new NullPointerException();

        if(words.size() < 2) return words;

        return sort(words, 0);
    }

    public static List<String> sort(List<String> words, int index) {
        // 1. Create new ArrayList
        List<String> sorted = new ArrayList<String>();

        // 3. Buckets for each letter from a to z
        LinkedList<String>[] buckets = new LinkedList[26];

        // 2. Start checking elements inside the list to sort
        for(String el : words) {
            if(el.length() <= index) {
                sorted.add(el);
                continue;
            }

            // 3. Find bucket index
            int i = (int) el.charAt(index) - 'a';
            if(buckets[i] == null) buckets[i] = new LinkedList<>();

            buckets[i].add(el);
        }

        if(sorted.size() != words.size()) {
            for (LinkedList<String> list : buckets) {
                if (list == null) continue;
                sorted.addAll(sort(list, index + 1));
            }
        }
        return sorted;
    }
}
