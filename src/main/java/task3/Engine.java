package task3;

public class Engine {
    public Noise push(Direction direction){
        Noise noise=new Noise("визг");
        System.out.println("[ engine "+direction+" "+noise.getSound()+" ]");
        return noise;
    }
}
