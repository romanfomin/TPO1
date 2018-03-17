import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import task2.CountSort;
import task2.CountSortResult;

import java.util.Arrays;

public class Task2Test {

    private StringBuffer path;

    @BeforeEach
    public void setUp() {
        path = new StringBuffer();
    }

    private void createPath(short[] arr) {
        short max = (arr.length > 0) ? arr[arr.length - 1] : -1;
        path.append("checked ").append("max=").append(max).append(" ");
        for (short s : arr) {
            path.append("inc ");
        }
        for (short s : arr) {
            path.append("assign ");
        }
        path.append("end");
    }

    private void executeAndAssertEquals(short[] array) {
        Arrays.sort(array);
        createPath(array);
        CountSortResult csrExpected = new CountSortResult(array, path.toString());

        CountSort countSort = new CountSort(array);
        countSort.sort();
        CountSortResult csrActual = countSort.getCsr();

        Assertions.assertEquals(csrExpected, csrActual);
    }

    @Test
    @DisplayName("small sorted")
    public void testMethod1() {
        short[] array = {0, 1, 1, 5};
        executeAndAssertEquals(array);
    }

    @Test
    @DisplayName("small not sorted")
    public void testMethod2() {
        short[] array = {3, 1, 0, 3};
        executeAndAssertEquals(array);
    }

    @Test
    @DisplayName("one value")
    public void testMethod3() {
        short[] array = {5};
        executeAndAssertEquals(array);
    }

    @Test
    @DisplayName("large sorted")
    public void testMethod4() {
        short[] array = {1, 3, 6, 12, 23, 45, 68, 99, 123, 233, 443, 536, 4444, 7688, 7989};
        executeAndAssertEquals(array);
    }

    @Test
    @DisplayName("large not sorted")
    public void testMethod5() {
        short[] array = {3, 1, 7989, 12, 536, 45, 99, 123, 233, 6, 443, 68, 4444, 23, 7688};
        executeAndAssertEquals(array);
    }

    @Test
    @DisplayName("zeroes")
    public void testMethod6() {
        short[] array = {0, 0, 0, 0, 0};
        executeAndAssertEquals(array);
    }

    @Test
    @DisplayName("empty")
    public void testMethod7() {
        short[] array = new short[0];
        executeAndAssertEquals(array);
    }

    @Test
    @DisplayName("large vals")
    public void testMethod8() {
        short[] array = {Short.MAX_VALUE, Short.MAX_VALUE - 1, Short.MAX_VALUE / 2};
        executeAndAssertEquals(array);
    }

    @Test
    @DisplayName("single negative")
    public void testMethod9() {
        short[] array = {-1};
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CountSort(array));
    }

    @Test
    @DisplayName("negative with positive")
    public void testMethod10() {
        short[] array = {5, 3, -2, 8};
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CountSort(array));
    }
}
