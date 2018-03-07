package Listener;

import GUI.BoxGUI;
import Simulation.Simulation;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    private final BoxGUI map;
    private final Simulation simulation;
    private boolean started = false;
    private boolean up, right, down, left;

    public KeyListener(BoxGUI map, Simulation simulation) {
        this.map = map;
        this.simulation = simulation;
        right = true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                if (!left && map.getStatus()) {
                    map.setDirection("Right");
                    right = true;
                    up = false;
                    down = false;
                    map.setStatus(false);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!right && map.getStatus()) {
                    map.setDirection("Left");
                    left = true;
                    up = false;
                    down = false;
                    map.setStatus(false);
                }
                break;
            case KeyEvent.VK_UP:
                if (!down && map.getStatus()) {
                    map.setDirection("Up");
                    up = true;
                    right = false;
                    left = false;
                    map.setStatus(false);
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!up && map.getStatus()) {
                    map.setDirection("Down");
                    down = true;
                    right = false;
                    left = false;
                    map.setStatus(false);
                }
                break;
            case KeyEvent.VK_SPACE: {
                if (!started) {
                    started = true;
                    simulation.resumeThread();
                } else {
                    started = false;
                    try {
                        simulation.pauseThread();
                    } catch (InterruptedException ex) {
                    }
                }
                break;
            }
            case KeyEvent.VK_1: 
                simulation.setSeconds(500);
                break;
            case KeyEvent.VK_2:
                simulation.setSeconds(150);
                break;
            default:
                break;
        }
    }

}
