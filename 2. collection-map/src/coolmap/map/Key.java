package coolmap.map;

import java.util.Objects;

public class Key {
    private final int id;
    private final String name;

    public Key(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return id == key.getId() && Objects.equals(name, key.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
