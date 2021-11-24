package taskA.factory;

import taskA.car.Car;

public abstract class CarFactory {

    public Car build(String model) {
        return new Car(model);
    }
}
