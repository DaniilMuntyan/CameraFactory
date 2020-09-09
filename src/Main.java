import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            System.out.print(new Random().nextInt(2));
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }
}
