import task2.CountSort;

public class Main {
    public static void main(String[] args) {

//        short[] arr = {};         ab
//        short[] arr = {4,-1};     acdfgde
//        short[] arr = {2,1,1};    acdfgdfgdfhijklmkymkynopopoqrvwrstsuwrsux
        short[] arr = {2,1,1};

        CountSort countSort=new CountSort();
        short[] res = countSort.sort(arr);

        System.out.println(countSort.getCsr().getPath());
    }
}
