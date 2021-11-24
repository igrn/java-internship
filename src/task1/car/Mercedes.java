package task1.car;

public class Mercedes extends Car {

    public Mercedes(String model) {
        super(model);
    }

    @Override
    public String drive() {
        return "Mercedes vrooom!";
    }
}
