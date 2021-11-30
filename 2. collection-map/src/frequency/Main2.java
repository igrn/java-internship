package frequency;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {
        int[] data = generateIntArray(100);

        Map<Integer, Long> frequencyMap = Arrays.stream(data).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.printf("число %d повторяется %d раз(а)\n",
                        entry.getKey(), entry.getValue()));
    }

    public static int[] generateIntArray(int length) {
        int[] data = new int[length];
        Random r = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = r.nextInt(100);
        }
        return data;
    }
}
