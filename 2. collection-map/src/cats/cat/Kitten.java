package cats.cat;

public class Kitten extends Cat {
    private final Cat mom;

    public Kitten(String name, String color, Cat mom) {
        super(name, color);
        this.mom = mom;
    }

    public Cat getMom() {
        return mom;
    }

    @Override
    public String toString() {
        return String.format("Kitten: name = %s, color = %s, mom = %s",
                name, color, mom.getName());
    }
}
