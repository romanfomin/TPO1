import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AcosTest {

    private double accuracy = 10e-6;

    @Test
    @DisplayName("acos(-1)")
    public void testMethod1() {
        Taylor taylor = new Taylor();
        double x = -1;
        double expected = Math.acos(x);
        double actual = taylor.getAcos(x, accuracy);
        Assertions.assertTrue(Math.abs(actual - expected) < accuracy);
    }

    @Test
    @DisplayName("acos(0)")
    public void testMethod2() {
        Taylor taylor = new Taylor();
        double x = 0;
        double expected = Math.acos(x);
        double actual = taylor.getAcos(x, accuracy);
        Assertions.assertTrue(Math.abs(actual - expected) < accuracy);
    }

    @Test
    @DisplayName("acos(1)")
    public void testMethod3() {
        Taylor taylor = new Taylor();
        double x = 1;
        double expected = Math.acos(x);
        double actual = taylor.getAcos(x, accuracy);
        Assertions.assertTrue(Math.abs(actual - expected) < accuracy);
    }

    @Test
    @DisplayName("acos(-0.5)")
    public void testMethod4() {
        Taylor taylor = new Taylor();
        double x = -0.5;
        double expected = Math.acos(x);
        double actual = taylor.getAcos(x, accuracy);
        Assertions.assertTrue(Math.abs(actual - expected) < accuracy);
    }

    @Test
    @DisplayName("acos(0.6)")
    public void testMethod5() {
        Taylor taylor = new Taylor();
        double x = 0.6;
        double expected = Math.acos(x);
        double actual = taylor.getAcos(x, accuracy);
        Assertions.assertTrue(Math.abs(actual - expected) < accuracy);
    }

    @Test
    @DisplayName("acos(-5)")
    public void testMethod6() {
        Taylor taylor = new Taylor();
        double x = -5;
        Assertions.assertThrows(IllegalArgumentException.class, () -> taylor.getAcos(x, accuracy));
    }

    @Test
    @DisplayName("acos(10)")
    public void testMethod7() {
        Taylor taylor = new Taylor();
        double x = 10;
        Assertions.assertThrows(IllegalArgumentException.class, () -> taylor.getAcos(x, accuracy));
    }
}
