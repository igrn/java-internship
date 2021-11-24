package task1;

import task1.car.Car;
import task1.factory.BMWFactory;
import task1.factory.MercedesFactory;

public class Task1 {
    BMWFactory bmwFactory = new BMWFactory();
    MercedesFactory mercedesFactory = new MercedesFactory();

    public void execute() {
        //Создаем объекты классов "БМВ" и "Мерседес"
        Car carBMW = bmwFactory.build("BMW X5");
        Car carMercedes = mercedesFactory.build("Mercedes E350");

        //Оба "машины" теперь находятся в куче и имеют ссылки, поэтому можем спокойно на них прокатиться :)
        System.out.println(carBMW.drive());
        System.out.println(carMercedes.drive());

        // Далее удалим единственную ссылку на объект машины "Мерседес"
        // Т.к. переменная carMercedes более не имеет ни одной ссылки на объект машины "Мерседес",
        // то данный объект будет удален сборщиком мусора при следующией сборке
        carMercedes = null;
    }
}
