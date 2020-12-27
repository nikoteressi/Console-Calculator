package calculator;

public class CalculatorEngine {

    public Number makeOperation(Number value1, Number value2, Operation operation) {
        switch (operation) {
            case ADD:
                return addNumbers(value1, value2);
            case DIV:
                return divNumbers(value1, value2);
            case MUL:
                return mulNumbers(value1, value2);
            case SUB:
                return subNumbers(value1, value2);
            default:
                throw new IllegalArgumentException(operation + " - неподдерживаемый тип операции");
        }
    }

    private Number mulNumbers(Number value1, Number value2) {
        int a = value1.toInt();
        int b = value2.toInt();
        if (value1.isRoman()) {
            return new RomanNumber(a * b);
        }
        return new ArabicNumber(a * b);
    }

    private Number divNumbers(Number value1, Number value2) {
        double a = value1.toDouble();
        double b = value2.toDouble();
        if (b == 0) {
            throw new IllegalArgumentException("На 0 делить нельзя!");
        }
        if (value1.isRoman()) {
            return new RomanNumber((int) (a / b));
        }
        return new ArabicNumber(a / b);
    }

    private Number addNumbers(Number value1, Number value2) {
        int a = value1.toInt();
        int b = value2.toInt();
        if (value1.isRoman()) {
            return new RomanNumber(a + b);
        }
        return new ArabicNumber(a + b);
    }

    private Number subNumbers(Number value1, Number value2) {
        int a = value1.toInt();
        int b = value2.toInt();
        if (value1.isRoman()) {
            return new RomanNumber(a - b);
        }
        return new ArabicNumber(a - b);
    }

}
