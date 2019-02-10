package sda.pizza;

public enum PizzaComponent {
    SALAMI("salami"),
    HAM("szyneczka"),
    PEPER("papryka"),
    MUSHROOMS("pieczarki"),
    OLIVES("oliwki"),
    SAUSAGE("kiełbasa"),
    ONION("cebula"),
    BACON("bekon"),
    BROCOLI("brokuły");

    private String polishSpelling;

    PizzaComponent(String polishSpelling) {
        this.polishSpelling = polishSpelling;
    }

    public String getPolishSpelling() {
        return polishSpelling;
    }
}
