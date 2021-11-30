import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class MyHelper {

    public static <T, R> Set<R> map(Collection<T> set, Function<T, R> function) {
        return set.stream().map(function).collect(Collectors.toSet());
    }

    @SafeVarargs
    public static <T> Set<T> flatMap(Set<T>... sets) {
        return Arrays.stream(sets).flatMap(Collection::stream).collect(Collectors.toSet());
    }
}

public class Main2 {

    public static void main(String[] args) {
        Set<Integer> set = Set.of(1, 2, 3, 4);
        Function<Integer, String> function1 = x -> Integer.toString(x); //Integer::toString не работает
        Function<Integer, String> function2 = x -> "В этой строке число " + x;

        MyHelper.map(set, function1).forEach(System.out::print);
        System.out.println();
        MyHelper.map(set, function2).forEach(System.out::println);
        MyHelper.map(set, x -> "String " + x).forEach(System.out::print);

        /*----------ВТОРАЯ ЗАДАЧКА----------*/
        System.out.println('\n');
        System.out.println("ЗАДАЧА 2:");
        /*----------------------------------*/

        Set<String> emails1 = Set.of("email1", "email2");
        Set<String> emails2 = Set.of("email3", "email4");
        //Set<String>[] emails = new Set<String>[] {emails1, emails2}; //Generic Array Creation

        MyHelper.flatMap(emails1, emails2).forEach(System.out::println);
    }
}
