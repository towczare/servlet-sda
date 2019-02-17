package sda.pizza;

public enum PizzaSize {
    MEDIUM("32 centymetry"),
    MEGA("45 centymetrów"),
    MAX("60 centymetrów");

    private String polishSize;

    PizzaSize(String polishSize) {
        this.polishSize = polishSize;
    }

    public String getPolishSize() {
        return polishSize;
    }
}
