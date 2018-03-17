package task2;

public class CountSort {

    private short[] array;
    private StringBuffer path = new StringBuffer();
    private CountSortResult csr;

    public CountSort(short[] array) {
        this.array = array;
        checkArray();
    }

    public short[] sort() {
        int max = findMax();
        int[] supporting = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            supporting[array[i]]++;
            path.append("inc ");
        }
        int pos = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < supporting[i]; j++) {
                path.append("assign ");
                array[pos] = (short) i;
                pos++;
            }
        }
        path.append("end");
        csr = new CountSortResult(array, path.toString());
        return array;
    }

    private void checkArray() {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        for (int val : array) {
            if (val < 0) {
                throw new IllegalArgumentException();
            }
        }
        path.append("checked ");
    }

    private int findMax() {
        int max = -1;
        for (int val : array) {
            if (val > max) {
                max = val;
            }
        }
        path.append("max=").append(max).append(" ");
        return max;
    }

    public CountSortResult getCsr() {
        return csr;
    }
}
