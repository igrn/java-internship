package task1.factory;

import task1.car.Car;

public abstract class CarFactory {

    public Car build(String model) {
        return new Car(model);
    }
}
