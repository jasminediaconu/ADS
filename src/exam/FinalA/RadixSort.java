package exam.FinalA;

import java.util.LinkedList;
import java.util.List;

/**
 * In this assignment, you are expected to implement the MSD (most-significant-digit-first)
 * radix sort algorithm to sort a sequence of words in non-decreasing alphabetic order.
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
     * Sorts a list of words using MSD radix sort.
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
        LinkedList<String> result = new LinkedList<>();

        LinkedList<String>[] buckets = new LinkedList[26];

        // 1. Initialize the array
        for(int i = 0; i < 26; i++) {
            buckets[i] = new LinkedList();
        }

        // 2. Check the length of the string
        for(String word : words) {
            if(word.length() >= index) result.add(word);
        }

        // 3. Add the string in the corresponding bucket
        for(int i = 0; i < words.size(); i++) {
            int a = words.get(i).charAt(index) - 'a';
            buckets[a].add(result.get(i));
        }

        // 4. Recursively sort each bucket
        for(LinkedList bucket : buckets) {
            if(bucket == null || bucket.size() < 2) continue;
            sort(bucket, index+1);
        }

        return result;
    }
}
