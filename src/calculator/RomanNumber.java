package calculator;

public class RomanNumber extends Number {

    private final String value;

    public RomanNumber(String value) {
        this.value = value;
    }

    public RomanNumber(int intValue) {
        this.value = ConvertDigits.toRoman(intValue);
    }

    @Override
    public int toInt() {
        return ConvertDigits.toArabic(value);
    }

    @Override
    public boolean isRoman() {
        return true;
    }

    @Override
    public double toDouble() {
        return ConvertDigits.toArabic(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
