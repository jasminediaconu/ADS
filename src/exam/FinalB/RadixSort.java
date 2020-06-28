package exam.FinalB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * In this assignment, you are expected to implement the LSD (least-significant-digit-first)
 * radix sort algorithm to sort a sequence of Dutch mobile phone numbers in non-decreasing order.
 *
 * For example, if the content of the input array is [0687654321, 0612301345, 0612300123, 0612345678],
 * the content of the output array should be [0612300123, 0612301345, 0612345678, 0687654321].
 *
 * You may assume that every String in the input array starts with 06 and is followed by eight digits.
 *
 * Your algorithm needs to run in O(n) time, where n is the number of items to sort.
 *
 * If null is passed as argument, radixSortLSD should throw a NullPointerException.
 */
public class RadixSort {
    /**
     * Sorts a list of Dutch mobile phone numbers using LSD radix sort.
     *
     * @param phoneNumbers
     *     The list of phone numbers to sort.
     * @return The sorted list of phone numbers.
     * @throws NullPointerException
     *     If `phoneNumbers` equals `null`.
     */
    public static List<String> radixSortLSD(List<String> phoneNumbers) {
        if(phoneNumbers == null) throw new NullPointerException();

        if(phoneNumbers.isEmpty()) return new ArrayList<>();

        return sort(phoneNumbers, 9);
    }

    public static List<String> sort(List<String> phoneNumbers, int index) {
        ArrayList<String> result = new ArrayList<>();
        LinkedList<String>[] buckets = new LinkedList[10];
        if(index < 0) return result;
        for(int i = 0; i < 10; i++) buckets[i] = new LinkedList<>();

        // 1. Sort phone numbers in the buckets
        for(String number : phoneNumbers) {
            int i = number.charAt(index) - '0';
            buckets[i].add(number);
        }

        // 2. Recursively check each bucket
        for(int i = 0; i < 10; i++) {
            if(!buckets[i].isEmpty()) {
                System.out.println(buckets[i].get(0));
                sort(buckets[i], index - 1);
            }
        }

        for(int i = 0; i < 10; i++) {
            result.addAll(buckets[i]);
        }
        return result;
    }

}
