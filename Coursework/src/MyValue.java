import java.util.Objects;

public class MyValue {
    private int value;

    @Override
    public boolean equals(Object val) {
        if (this == val) return true;
        if (val == null || getClass() != val.getClass()) return false;
        return this.value == ((MyValue) val).getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int getValue() {
        return value;
    }

    public MyValue(int value) {
        this.value = value;
    }
}
