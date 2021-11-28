package cats.cat;

public class Cat {
    protected String name;
    protected String color;

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("Cat: name = %s, color = %s", name, color);
    }
}
