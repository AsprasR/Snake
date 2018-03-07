package Simulation;

import java.util.Observable;

public class AppleTick extends Observable {

    @Override
    public synchronized void setChanged() {
        super.setChanged();
    }
}
