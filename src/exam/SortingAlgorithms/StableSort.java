package exam.SortingAlgorithms;

/**
 * As input, you will receive a two-dimensional array (a table) of Strings and the index of
 * the “column” you should sort.
 * You should sort the rows by the values in the indicated column.
 * <p>
 * You can see the first index as a row index, and the second index as a column index.
 * For example, the following Java array and table correspond with each other:
 * <p>
 * String[][] table = {
 * {"a", "b"},
 * {"c", "d"}
 * };
 * <p>
 * <p>
 * 0   1
 * +---+---+
 * 0 | a | b |
 * +---+---+
 * 1 | c | d |
 * +---+---+
 * <p>
 * To continue on this example, table[0][1] will yield the value "b",
 * since it’s the item in row 0 and column 1.
 * <p>
 * You are allowed to implement any stable sorting algorithm with a worst-case time
 * complexity of O(n2).
 * (Remember that this includes algorithms with a complexity of O(nlogn).)
 * <p>
 * IMPORTANT: You are not allowed to use any sorting algorithm from the Java library,
 * for example Arrays.sort. In an exam setting, your grade will be overridden to 1
 * if you do use a Java library function to sort the array.
 */
public class StableSort {
    public static void stableSort(String[][] table, int column) {
        if (table == null || table.length == 0) return;

        boolean swapped = false;

        for (int i = 0; i < table.length - 1; i++) {
            for (int j = 0; j < table.length - i - 1; j++) {
                if (table[j][column].compareTo(table[j + 1][column]) > 0) {
                    String[] temp = table[j];
                    table[j] = table[j + 1];
                    table[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }
}
