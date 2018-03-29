package task3;

import java.util.List;

public class Ship {
    private List<Controller> controllers;
    private List<Engine> engines;
    private ShipState state = ShipState.START;

    public Ship(List<Controller> controllers, List<Engine> engines) {
        this.controllers = controllers;
        this.engines = engines;
    }

    public void startEngines(FordState fordState) {
        if (fordState != FordState.HOLDING) {
            return;
        }
        StringBuilder noise = new StringBuilder();
        int numberOfDirections = Direction.values().length;
        int i = 0;
        for (Engine engine : engines) {
            engine.setWorking(true);
            noise.append(engine.push(Direction.values()[i % numberOfDirections]));
            i++;
        }
        shake();
    }

    private void shake() {
        if (state != ShipState.START) {
            return;
        }
        state = ShipState.SHAKE;

        System.out.println("Корабль затрясло оттого, что его двигатели" +
                " с визгом начали толкать его одновременно во всех " +
                "направлениях.");
        System.out.println("[ shaking ]");

    }

    public void makeSteepArc(FordState fordState) {
        if(fordState!=FordState.RELEASED_HALF){
            return;
        }
        if (state != ShipState.SHAKE) {
            return;
        }
        state = ShipState.STEEP_ARC;

        System.out.println("и корабль, описав крутую дугу,");
    }

    public void turnRound() {
        if (state != ShipState.STEEP_ARC) {
            return;
        }
        state = ShipState.TURN_ROUND;

        System.out.println("развернулся кругом");
    }

    public void goTowardsRockets() {
        if (state != ShipState.TURN_ROUND) {
            return;
        }
        state = ShipState.GO_TOWARDS;

        System.out.println("и направился навстречу ракетам.");
    }

    public List<Controller> getControllers() {
        return controllers;
    }

    public List<Engine> getEngines() {
        return engines;
    }

    public void setState(ShipState state) {
        this.state = state;
    }

    public ShipState getState() {
        return state;
    }
}
