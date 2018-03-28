package task3;

public class Handle {
    private String function;
    private boolean isKnown;
    private boolean isHold;

    public Handle(String function) {
        this.function = function;
    }

    public String getFunction() {
        return function;
    }

    public boolean isKnown() {
        return isKnown;
    }

    public void setKnown(boolean known) {
        isKnown = known;
        System.out.println("[ guessed function of handle "+function+" ]");
    }

    public boolean isHold() {
        return isHold;
    }

    public void setHold(boolean hold) {
        if(hold) {
            System.out.println("[ handle " + function + " is now hold ]");
        }else{
            System.out.println("[ handle " + function + " is released ]");
        }
        isHold = hold;
    }
}
