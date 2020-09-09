package entities.camera;

import java.util.Objects;

public final class Dimensions implements Comparable<Dimensions> {

    private final Integer width;
    private final Integer length;
    private final Integer depth;

    public Dimensions(Integer width, Integer length, Integer depth) {
        this.width = width;
        this.length = length;
        this.depth = depth;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return width + "x" + length + "x" + depth;
    }

    @Override
    public int compareTo(Dimensions o) {
        return  (this.width <= o.width && this.length <= o.length && this.depth <= o.depth) ? 1 : -1;
    }

}
