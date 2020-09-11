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

    public Dimensions() {
        Random rand = new Random();
        this.width = 16 + rand.nextInt(10); // From 16 to 26 (standard, described in tester.checkDimensions: 25)
        this.length = 11 + rand.nextInt(10); // From 11 to 21 (standard: 20)
        this.depth = 6 + rand.nextInt(10); // From 6 to 16 (standard: 15)
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
