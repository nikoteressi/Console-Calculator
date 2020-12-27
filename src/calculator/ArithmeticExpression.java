package calculator;

public class ArithmeticExpression {

    private Number number1;
    private Number number2;
    private Operation operation;

    public Number getNumber1() {
        return number1;
    }

    public void setNumber1(Number number1) {
        this.number1 = number1;
    }

    public Number getNumber2() {
        return number2;
    }

    public void setNumber2(Number number2) {
        this.number2 = number2;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
