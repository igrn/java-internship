package cats;

import cats.cat.Cat;
import cats.cat.Kitten;
import cats.key.Tag;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        int date = getRandomDate();
        System.out.println(date);


        Cat mom = new Cat("Mom cats.cat", "White");
        Map<Tag, Kitten> kittens = new HashMap<>();
        fillMap(mom, kittens);
        System.out.println("----------------");
        System.out.println("HASH MAP");
        System.out.println("----------------");
        printKittenInfo(kittens);

//        System.out.println();
        System.out.println("----------------");
        System.out.println("TREE MAP");
        System.out.println("----------------");
        kittens = new TreeMap<>(Comparator.comparingInt(Tag::getBirthday));
        fillMap(mom, kittens);
        printKittenInfo(kittens);
    }

    private static void fillMap(Cat mom, Map<Tag, Kitten> kittens) {
        for (int i = 0; i < 20; i++) {
            Tag tag = new Tag(getRandomDate(), "Name" + i, "Color" + i);
            Kitten kitten = new Kitten("Kitten " + i, "Color " + i, mom);
            kittens.put(tag, kitten);
        }
    }

    private static void printKittenInfo(Map<Tag, Kitten> kittens) {
        for (Map.Entry<Tag, Kitten> entry : kittens.entrySet()) {
            System.out.println("Tag: " + entry.getKey()
                    + " birthday = " + entry.getKey().getBirthday()
                    + " --- " + entry.getValue());
        }
    }

    private static int getRandomDate() {
        int day = ((int) (30 * Math.random() + 1)) * 1_000_000;
        int month = ((int) (12 * Math.random() + 1)) * 10_000;
        int year = (int) (2.5 * Math.random() + 2020);
        return day + month + year;
    }
}
