package Simulation;

public class Simulation extends Thread {

    private final SimulationTick tick;
    private int seconds = 150;
    private final Object object;
    private boolean pause = false;

    public Simulation() {
        this.object = this;
        tick = new SimulationTick();
        simulate();
    }

    private void simulate() {
        start();
        try {
            pauseThread();
        } catch (InterruptedException e) {
        }
    }
    
    public void setSeconds( int s ) {
        seconds = s;
    }

    public SimulationTick getSimulation() {
        return tick;
    }

    public void pauseThread() throws InterruptedException {
        pause = true;
    }

    private void checkForPaused() {
        synchronized (object) {
            while (pause) {
                try {
                    object.wait();
                } catch (InterruptedException e) {

                }
            }
        }
    }

    private void threadSleep() throws InterruptedException {
        Thread.sleep(seconds);
    }

    public void resumeThread() {
        synchronized (object) {
            pause = false;
            object.notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                checkForPaused();
                threadSleep();
                tick.setChanged();
                tick.notifyObservers();
            } catch (InterruptedException e) {
                break;
            }
        }

    }
}
