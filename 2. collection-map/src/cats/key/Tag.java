package cats.key;

public class Tag {
    private final int birthday;
    private final String name;
    private final String color;

    public Tag(int birthday, String name, String color) {
        this.birthday = birthday;
        this.name = name;
        this.color = color;
    }

    public int getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;
        return birthday == tag.getBirthday()
                && (name == tag.getName() || (name != null && name.equals(tag.getName())))
                && (color == tag.getColor() || (color != null && color.equals(tag.getColor())));
    }

    @Override
    public int hashCode() {
        int result = birthday;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
