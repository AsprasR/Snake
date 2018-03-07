package Box;

import java.util.Random;

public final class Apple {

    private final Coords coords;
    private static Random r;
    private int x, y;
    private final int col, rows;

    public Apple(Coords coords, int col, int rows) {
        this.coords = coords;
        this.col = col;
        this.rows = rows;
        check();
    }

    public void check() {
        while (true) {
            r = new Random();
            x = r.nextInt(rows);
            y = r.nextInt(col);
            if (!coords.isContains(x, y)) {
                break;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
