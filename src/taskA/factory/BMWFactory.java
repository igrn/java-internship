package taskA.factory;

import taskA.car.BMW;

public class BMWFactory extends CarFactory {

    @Override
    public BMW build(String model) {
        return new BMW(model);
    }
}
