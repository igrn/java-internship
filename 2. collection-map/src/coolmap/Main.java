package coolmap;

import coolmap.map.CoolMap;
import coolmap.map.Key;

public class Main {

    public static void main(String[] args) {
        CoolMap<String, Integer> coolMap = new CoolMap<>();

        coolMap.put("test", 10);
        coolMap.put("nullTest", 25);
        Integer testVal = coolMap.get("test");
        Integer nullVal = coolMap.get("nullTest");

        System.out.println(testVal + "; " + nullVal);

        /*---TEST WITH CUSTOM KEY CLASS---*/
        CoolMap<Key, String> keyCoolMap = new CoolMap<>();
        Key key1 = new Key(1, "Key 1");
        Key key2 = new Key(2, "Key 2");

        keyCoolMap.put(key1, "Test Value");
        keyCoolMap.put(key2, "Value 2");

        String string1 = keyCoolMap.get(key1);
        String string2 = keyCoolMap.get(key2);
        String string3 = keyCoolMap.get(new Key(1, "Key 1111"));

        System.out.println(string1 + "; " + string2 + "; " + string3);
    }
}
