package taskA.factory;

import taskA.car.Mercedes;

public class MercedesFactory extends CarFactory {

    @Override
    public Mercedes build(String model) {
        return new Mercedes(model);
    }
}
