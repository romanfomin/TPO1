public class Main {
    public static void main(String[] args) {
        Taylor taylor=new Taylor();
        double x=0.6;
        System.out.println(taylor.getAcos(x,0.000001));
        System.out.println(Math.acos(x));
    }
}
