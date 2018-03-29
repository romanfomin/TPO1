import task2.CountSort;
import task3.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Ford ford = new Ford();

        List<Controller> controllers = new ArrayList<>();
        for (int k = 0; k < 5; k++) {
            List<Handle> handles = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                handles.add(new Handle(String.valueOf(i)));
            }
            controllers.add(new Controller(handles));
        }

        List<Engine> engines = new ArrayList<>();
        for(int i=0;i<6;i++){
            engines.add(new Engine());
        }

        Ship ship = new Ship(controllers, engines);


        ford.jumpTo(ship.getControllers());
        List<Handle> guessed = ford.guessFunctionOfSome(ship.getControllers().get(0).getHandles());
        ford.catchKnown(guessed);
        ship.startEngines(ford.getState());
        ford.releaseHalf(guessed,ship.getState());
        ship.makeSteepArc(ford.getState());
        ship.turnRound();
        ship.goTowardsRockets();

    }
}
