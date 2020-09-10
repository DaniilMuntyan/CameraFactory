package entities.camera;

import java.util.Objects;
import java.util.Random;

public final class Dimensions implements Comparable<Dimensions> {

    private final Integer width;
    private final Integer length;
    private final Integer depth;

    public Dimensions(Integer width, Integer length, Integer depth) {
        this.width = width;
        this.length = length;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return width + "x" + length + "x" + depth + " см³";
    }

    @Override
    public int compareTo(Dimensions o) {
        return  (this.width <= o.width && this.length <= o.length && this.depth <= o.depth) ? 1 : -1;
    }

}
