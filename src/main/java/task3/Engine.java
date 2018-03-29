package task3;

public class Engine {
    private boolean isWorking;
    public Noise push(Direction direction){
        Noise noise=new Noise("визг");
        System.out.println("[ engine "+direction+" "+noise.getSound()+" ]");
        return noise;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
}
