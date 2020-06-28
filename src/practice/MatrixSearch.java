package practice;

/**
 * Given a sorted matrix, search for the indeces of the given element. This search needs to have time complexity
 * O(log(nm)) where n is the number of rows and m the number of columns in the matrix.
 */
public class MatrixSearch {

    public static void findElement(String[][] matrix, String element) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        findElement(matrix, element, 0, 0, rows-1, cols -1);
    }

    public static void findElement(String[][] matrix, String element, int leftRow, int leftCol, int rightRow, int rightCol) {
        int cols = matrix[0].length;
        int ascii = element.charAt(0) - 'a';

        int leftElement = matrix[leftRow][leftCol].charAt(0) - 'a';
        int rightElement = matrix[rightRow][rightCol].charAt(0) - 'a';

        int pivot = (leftElement + rightElement) / 2;

        int row = pivot / cols;
        int col = pivot % cols;

        String piv = matrix[row][col];

        if(piv.compareTo(element) == 0) {
            System.out.println("Row: " + row + " Column: " + col);
            return;
        }

        else if(piv.compareTo(element) < 0) {
            // go to the right
            if(col == cols - 1) {
                col = 0;
                row++;
            }

            else col++;

            findElement(matrix, element, row, col, rightRow, rightCol);

        }

        else if(piv.compareTo(element) > 0) {
            // go to the left
            if(col == 0) {
                col = cols - 1;
                row = row--;
            }

            else col--;

            findElement(matrix, element, leftRow, leftCol,  row, col);
        }
    }
}
