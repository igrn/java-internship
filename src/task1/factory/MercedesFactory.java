package task1.factory;

import task1.car.Mercedes;

public class MercedesFactory extends CarFactory {

    @Override
    public Mercedes build(String model) {
        return new Mercedes(model);
    }
}
