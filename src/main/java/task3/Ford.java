package task3;

import java.util.ArrayList;
import java.util.List;

public class Ford {
    private FordState state = FordState.START;

    public void jumpTo(List<Controller> controllers) {
        if(state == FordState.START){
            state = FordState.AT_CONTROLLERS;
        }
        System.out.println("Форд подскочил к пультам;");
    }

    public List<Handle> guessFunctionOfSome(List<Handle> handles) {
        if(state == FordState.AT_CONTROLLERS){
            state = FordState.GUESSED;
        }

        System.out.println("он смог догадаться о назначении некоторых рукояток");
        List<Handle> guessed=new ArrayList<>();
        for(int i=0;i<handles.size();i++){
            if(i%3==0){
                handles.get(i).setKnown(true);
                guessed.add(handles.get(i));
            }
        }
        return guessed;
    }

    public void catchKnown(List<Handle> handles) {
        if(state == FordState.GUESSED){
            state = FordState.HOLDING;
        }

        System.out.println("и схватился за них.");
        for(Handle handle:handles){
            handle.setHold(true);
        }
    }

    public void releaseHalf(List<Handle> handles, ShipState shipState) {
        if(shipState!=ShipState.SHAKE){
            return;
        }
        if(state == FordState.HOLDING){
            state = FordState.RELEASED_HALF;
        }

        System.out.println("Форд отпустил половину рукояток");
        for(int i=0;i<handles.size()/2;i++){
            handles.get(i).setHold(false);
        }
    }

    public void setState(FordState state) {
        this.state = state;
    }

    public FordState getState() {
        return state;
    }
}
