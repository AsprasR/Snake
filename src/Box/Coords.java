package Box;

import java.util.ArrayList;
import java.util.Objects;

public class Coords {

    private final ArrayList<Integer> x, y;

    public Coords() {
        x = new ArrayList<>();
        y = new ArrayList<>();
    }

    public void setCoords(int a, int b) {
        x.add(a);
        y.add(b);
    }

    public boolean isContains(int a, int b) {
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i) == a && y.get(i) == b) {
                return true;
            }
        }
        return false;
    }

    public int getX(int index) {
        return x.get(index);
    }

    public int getY(int index) {
        return y.get(index);
    }

    public void removeCoordsX(int index) {
        x.remove(index);
    }

    public void removeCoordsY(int index) {
        y.remove(index);
    }

    public void changeCoordsX(int i, int elem) {
        x.set(i, elem);
    }

    public void changeCoordsY(int i, int elem) {
        y.set(i, elem);
    }

    public int size() {
        return x.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Coords) {
            Coords that = (Coords) o;
            if (x == that.x) {
                if (y == that.y) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 79 * Objects.hashCode(this.x) + Objects.hashCode(this.y);
    }

}
