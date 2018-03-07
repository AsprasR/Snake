package Simulation;

import java.util.Observable;

public class SimulationTick extends Observable {

    @Override
    public synchronized void setChanged() {
        super.setChanged();
    }

}
