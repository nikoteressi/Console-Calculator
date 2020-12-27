package calculator;

import java.io.IOException;

public class CalculatorStart {

    public static void main(String[] args) throws IOException {
        ArithmeticExpression arithmeticExpression = ConsoleReader.readFromConsole();
        CalculatorEngine calculatorEngine = new CalculatorEngine();
        System.out.println(calculatorEngine.makeOperation(arithmeticExpression.getNumber1(),
                arithmeticExpression.getNumber2(), arithmeticExpression.getOperation()));
    }
}
