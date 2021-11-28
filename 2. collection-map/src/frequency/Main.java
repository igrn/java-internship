package frequency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] data = generateIntArray(100);

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Arrays.stream(data).forEach(number -> {
            if (frequencyMap.containsKey(number)) {
                frequencyMap.put(number, frequencyMap.get(number) + 1);
            } else {
                frequencyMap.put(number, 1);
            }
        });

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
