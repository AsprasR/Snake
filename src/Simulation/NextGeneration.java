package Simulation;

import Box.Apple;
import Box.Coords;
import java.util.Observable;
import java.util.Observer;

public class NextGeneration extends Observable implements Observer {

    private final Apple apple;
    private final Coords coords;

    public NextGeneration(Apple apple, Coords coords) {
        this.coords = coords;
        this.apple = apple;
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof AppleTick) {
            setChanged();
            notifyObservers(apple);
        }
        if (observable instanceof SimulationTick) {
            setChanged();
            notifyObservers(coords);
        }
    }
}
