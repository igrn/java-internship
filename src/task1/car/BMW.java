package task1.car;

public class BMW extends Car {

    public BMW(String model) {
        super(model);
    }

    @Override
    public String drive() {
        return "BMW vroom, vroom!";
    }
}
