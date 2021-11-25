package factory;

import car.Mercedes;

public class MercedesFactory extends CarFactory {

    @Override
    public Mercedes build(String model) {
        return new Mercedes(model);
    }
}
