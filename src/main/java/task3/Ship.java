package task3;

import java.util.List;

public class Ship {
    private List<Controller> controllers;
    private List<Engine> engines;

    public Ship(List<Controller> controllers,List<Engine> engines) {
        this.controllers = controllers;
        this.engines = engines;
    }

    public void shake(List<Engine> engines,Direction[] directions){
        System.out.println("Корабль затрясло оттого, что его двигатели" +
                " с визгом начали толкать его одновременно во всех " +
                "направлениях.");
        System.out.println("[ shaking ]");
        StringBuilder noise=new StringBuilder();
        int numberOfDirections=directions.length;
        int i=0;
        for(Engine engine:engines){
            noise.append(engine.push(directions[i%numberOfDirections]));
            i++;
        }
    }

    public void makeSteepArc(){
        System.out.println("и корабль, описав крутую дугу,");
    }

    public void turnRound(){
        System.out.println("развернулся кругом");
    }

    public void goTowardsRockets(){
        System.out.println("и направился навстречу ракетам.");
    }

    public List<Controller> getControllers() {
        return controllers;
    }

    public List<Engine> getEngines() {
        return engines;
    }
}
