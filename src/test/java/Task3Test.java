import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import task3.*;

import java.util.ArrayList;
import java.util.List;

public class Task3Test {

    private Ford ford;
    private Ship ship;
    private FordState fordStateExpected;
    private ShipState shipStateExpected;

    @BeforeEach
    public void init() {

        ford = new Ford();
        List<Controller> controllers = new ArrayList<>();
        for (int k = 0; k < 5; k++) {
            List<Handle> handles = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                handles.add(new Handle(String.valueOf(i)));
            }
            controllers.add(new Controller(handles));
        }

        List<Engine> engines = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            engines.add(new Engine());
        }

        ship = new Ship(controllers, engines);
    }

    @Test
    @DisplayName("jump")
    public void testMethod1() {
        ford.setState(FordState.START);
        fordStateExpected = FordState.AT_CONTROLLERS;

        ford.jumpTo(ship.getControllers());

        Assertions.assertEquals(fordStateExpected, ford.getState());
    }

    @Test
    @DisplayName("guess")
    public void testMethod2() {
        ford.setState(FordState.AT_CONTROLLERS);
        fordStateExpected = FordState.GUESSED;

        ford.guessFunctionOfSome(ship.getControllers().get(0).getHandles());

        Assertions.assertEquals(fordStateExpected, ford.getState());
    }

    @Test
    @DisplayName("hold")
    public void testMethod3() {
        ford.setState(FordState.GUESSED);
        fordStateExpected = FordState.HOLDING;

        List<Handle> handles = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            handles.add(new Handle(String.valueOf(i * 3)));
        }

        ford.catchKnown(handles);

        Assertions.assertEquals(fordStateExpected, ford.getState());
    }

    @Test
    @DisplayName("shake")
    public void testMethod4() {
        ship.setState(ShipState.START);
        shipStateExpected = ShipState.SHAKE;
        ford.setState(FordState.HOLDING);

        ship.startEngines(ford.getState());

        Assertions.assertEquals(shipStateExpected, ship.getState());
    }

    @Test
    @DisplayName("release")
    public void testMethod5() {
        ford.setState(FordState.HOLDING);
        fordStateExpected = FordState.RELEASED_HALF;

        ship.setState(ShipState.SHAKE);
        List<Handle> handles = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            handles.add(new Handle(String.valueOf(i * 3)));
        }

        ford.releaseHalf(handles, ship.getState());

        Assertions.assertEquals(fordStateExpected, ford.getState());
    }

    @Test
    @DisplayName("steep arc")
    public void testMethod6() {
        ship.setState(ShipState.SHAKE);
        shipStateExpected = ShipState.STEEP_ARC;
        ford.setState(FordState.RELEASED_HALF);

        ship.makeSteepArc(ford.getState());

        Assertions.assertEquals(shipStateExpected, ship.getState());
    }

    @Test
    @DisplayName("turn round")
    public void testMethod7() {
        ship.setState(ShipState.STEEP_ARC);
        shipStateExpected = ShipState.TURN_ROUND;

        ship.turnRound();

        Assertions.assertEquals(shipStateExpected, ship.getState());
    }

    @Test
    @DisplayName("go towards")
    public void testMethod8() {
        ship.setState(ShipState.TURN_ROUND);
        shipStateExpected = ShipState.GO_TOWARDS;

        ship.goTowardsRockets();

        Assertions.assertEquals(shipStateExpected, ship.getState());
    }
}
