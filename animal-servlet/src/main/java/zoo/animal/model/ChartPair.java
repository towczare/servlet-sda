package zoo.animal.model;

/**
 * Created by tomic on 16.06.18.
 */
public class ChartPair {

    private String x;
    private int value;

    public ChartPair(String x, int value) {
        this.x = x;
        this.value = value;
    }

    public String getX() {
        return x;
    }

    public int getValue() {
        return value;
    }
}
