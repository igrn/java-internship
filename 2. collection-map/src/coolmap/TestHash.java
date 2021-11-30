package coolmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestHash {

    public static void main(String[] args) {
        //List<Key> keys = new ArrayList<>();
        List<Integer> keys = new ArrayList<>();
        Random r = new Random();

        for (int i = 1; i <= 24; i++) {
            //keys.add(new Key(i, "Key " + i));
            keys.add(r.nextInt(100_000) + 100_000_000);
        }

        keys.forEach(key -> {
            String hash1 = Integer.toString(key.hashCode());
            String hash2 = Integer.toString(hash(key));
            String shift = Integer.toString(key.hashCode() >>> 16);
            Integer index1 = (32 - 1) & key.hashCode();
            Integer index2 = (32 - 1) & hash(key);
            System.out.printf("Val = %d; Hash: before = %s, after = %s, shift = %s, " +
                            "index1 = %d, index2 = %d\n",
                    key, hash1, hash2, shift, index1, index2);
        });
    }

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
