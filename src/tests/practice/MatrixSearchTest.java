package practice;

import org.junit.jupiter.api.Test;

public class MatrixSearchTest {
    @Test
    public void testOneColumn() {
        String[][] data = {{"a"}, {"b"}, {"c"}, {"d"}, {"e"}, {"f"}, {"g"}};
//        MatrixSearch.findElement(data,"g");

        String[][] data2 = {{"a", "b"}, {"c", "d"}, {"e", "f"}, { "g", "h"}};
        MatrixSearch.findElement(data2,"h");
        MatrixSearch.findElement(data2,"b");


        /**
         * a | b
         * c | d
         * e | f
         */
    }
}
