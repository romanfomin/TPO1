import task2.CountSort;

public class Main {
    public static void main(String[] args) {

        short[] arr = new short[0];

        CountSort countSort = new CountSort(arr);
        short[] res = countSort.sort();

        for (Short re : res) {
            System.out.print(re + " ");
        }
    }
}
