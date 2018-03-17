package task2;

import java.util.Arrays;

public class CountSortResult {
    private short[] array;
    private String path;

    public CountSortResult(short[] array, String path) {
        this.array = array;
        this.path = path;
    }

    public short[] getArray() {
        return array;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        CountSortResult csr = (CountSortResult) o;
        return (Arrays.equals(array, csr.array) && path.equals(csr.path));
    }
}
