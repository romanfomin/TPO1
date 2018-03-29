import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import task2.CountSort;
import task2.CountSortResult;


public class Task2Test {

    private String pathExpected;
    private short[] arrayExpected;
    private short[] arrayActual;

    private void executeAndAssertEquals() {
        CountSort countSort = new CountSort();
        CountSortResult csrExpected = new CountSortResult(arrayExpected, pathExpected);

        countSort.sort(arrayActual);
        CountSortResult csrActual = countSort.getCsr();

        Assertions.assertEquals(csrExpected, csrActual);
    }

    @Test
    @DisplayName("1-3")
    public void testMethod1() {
        arrayActual = new short[]{};
        arrayExpected = arrayActual;
        pathExpected = "ab";

        executeAndAssertEquals();
    }

    @Test
    @DisplayName("1-6")
    public void testMethod2() {
        arrayActual = new short[]{4, -1};
        arrayExpected = arrayActual;
        pathExpected = "acdfgde";

        executeAndAssertEquals();
    }

    @Test
    @DisplayName("1-19")
    public void testMethod3() {
        arrayActual = new short[]{2, 1, 1};
        arrayExpected = new short[]{1, 1, 2};
        pathExpected = "acdfgdfgdfhijklmkymkynopopoqrvwrstsuwrsux";

        executeAndAssertEquals();
    }
}
