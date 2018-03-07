/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Box.Apple;
import Box.Coords;
import Simulation.AppleTick;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author dev
 */
public final class BoxGUI extends JPanel implements Observer {

    private final BoxColour[][] points;
    private final int col, rows, size;
    private final Dimension boxSize;
    private String direction;
    private final AppleTick tick;
    private final Coords coords;
    private int apple_x, apple_y, newX, newY;
    private final Apple apple;
    private boolean status;
    private final Score score;

    public BoxGUI(Coords coords, Score score, int col, int rows, int size) {
        this.direction = "Right";
        this.col = col;
        this.rows = rows;
        this.coords = coords;
        this.size = size;
        this.score = score;
        tick = new AppleTick();
        points = new BoxColour[rows][col];
        boxSize = new Dimension(this.size, this.size);

        setLayout(new GridLayout(rows, col));
        setBox();
        apple = new Apple(coords, col, rows);
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Apple getApple() {
        return apple;
    }

    public AppleTick getTick() {
        return tick;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    private void setBox() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (i == (rows / 2 - 1) && j >= col / 2 - 2 && j <= col / 2 + 1) {
                    points[i][j] = new BoxColour(Color.YELLOW);
                    coords.setCoords(i, j);
                } else {
                    points[i][j] = new BoxColour(Color.BLACK);
                }
                points[i][j].setOpaque(true);
                points[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
                points[i][j].setPreferredSize(boxSize);
                add(points[i][j]);
            }
        }
    }

    private void newPoint(int a, int b) {
        newX = coords.getX(coords.size() - 1) + a;
        newY = coords.getY(coords.size() - 1) + b;
    }

    private void clean(int i) {
        int tmpX = coords.getX(i);
        int tmpY = coords.getY(i);
        points[tmpX][tmpY].setState(Color.BLACK);
        coords.removeCoordsX(i);
        coords.removeCoordsY(i);
    }

    private void execute(int a, int b) {
        newPoint(a, b);

        if (newX >= rows) {
            newX = 0;
        }
        if (newY >= col) {
            newY = 0;
        }
        if (newX < 0) {
            newX = rows - 1;
        }
        if (newY < 0) {
            newY = col - 1;
        }

        for (int i = 0; i < coords.size(); i++) {
            if (coords.getX(i) == newX && coords.getY(i) == newY) {
                for (int j = coords.size() - 5; j >= 0; j--) {
                    clean(j);
                }
                score.resetPoints();
            }
        }

        points[newX][newY].setState(Color.YELLOW);
        coords.setCoords(newX, newY);

        if (newX != apple_x || newY != apple_y) {
            clean(0);
        } else if (newX == apple_x && newY == apple_y) {
            score.setPoints();
            apple.check();
            tick.setChanged();
            tick.notifyObservers();
        }
        status = true;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Apple) {
            apple_x = apple.getX();
            apple_y = apple.getY();
            points[apple_x][apple_y].setState(Color.RED);
            revalidate();
        }
        if (arg instanceof Coords) {
            switch (direction) {
                case "Right":
                    execute(0, 1);
                    break;
                case "Up":
                    execute(-1, 0);
                    break;
                case "Down":
                    execute(1, 0);
                    break;
                case "Left":
                    execute(0, -1);
                    break;
                default:
                    break;
            }
        }
    }
}
