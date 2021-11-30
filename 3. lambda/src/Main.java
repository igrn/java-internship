import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Integer> numbers = Map.of(1, 1, 2, 2, 3, 3);

        List<Integer> list = numbers.entrySet().stream()
                .map(entry -> {



                    return entry.getKey() + entry.getValue();
                }).collect(Collectors.toList());

        list.forEach(System.out::println);


        List<Integer> list1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list1.stream().filter(e -> e > 5).forEach(System.out::println);
    }
}
