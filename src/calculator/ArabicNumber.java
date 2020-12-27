package calculator;

public class ArabicNumber extends Number {

    private final double value;

    public ArabicNumber(double value) {
        this.value = value;
    }

    @Override
    public int toInt() {
        return (int) value;
    }

    @Override
    public boolean isRoman() {
        return false;
    }

    @Override
    public double toDouble() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
