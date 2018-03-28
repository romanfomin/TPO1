package task2;

public class CountSort {

    private StringBuffer path = new StringBuffer();
    private CountSortResult csr;

    public short[] sort(short[] array) {             // 8
        if(checkArray(array)==-1){
            csr = new CountSortResult(array, path.toString());
            return array;
        }
        int max = findMax(array);
        int[] supporting = new int[max + 1];
        for (int i = 0; i < array.length; i++) {            // 13
            if (i > 0) {
                path.append('p');
            }
            supporting[array[i]]++;
            path.append('o');
        }                                                   // 14

        path.append('q');

        int pos = 0;
        for (int i = 0; i <= max; i++) {                    // 15
            if (i > 0) {
                path.append('w');
            }
            path.append('r');
            for (int j = 0; j < supporting[i]; j++) {       // 16
                if (j > 0) {
                    path.append('t');
                }
                array[pos] = (short) i;
                pos++;
                path.append('s');
            }                                               // 17
            if (supporting[i] == 0) {
                path.append('v');
            } else {
                path.append('u');
            }
        }                                                   // 18

        path.append('x');

        csr = new CountSortResult(array, path.toString());
        return array;                                       // 19
    }

    private int checkArray(short[] array) {                             // 1
        path.append('a');
        if (array == null || array.length == 0) {                                // 2
            path.append('b');
            return -1;
//            throw new IllegalArgumentException();           // 3
        }
        path.append('c');

        for (int i = 0; i < array.length; i++) {            // 4
            if (i > 0) {
                path.append('g');
            }
            path.append('d');
            if (array[i] < 0) {                             // 5
                path.append('e');
                return -1;
//                throw new IllegalArgumentException();       // 6
            }
            path.append('f');
        }                                                   // 7

        path.append('h');
        return 0;
    }

    private int findMax(short[] array) {                                 // 9
        path.append('i');
        int max = -1;

        path.append('j');
        for (int i = 0; i < array.length; i++) {            // 10
            if (i > 0) {
                path.append('m');
            }
            path.append('k');
            if (array[i] > max) {                           // 11
                path.append('l');
                max = array[i];
            }else{                                          // 12
                path.append('y');
            }
        }

        path.append('n');


        return max;
    }

    public CountSortResult getCsr() {
        return csr;
    }
}
