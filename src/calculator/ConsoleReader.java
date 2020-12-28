package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ConsoleReader {

    public static ArithmeticExpression readFromConsole() throws IOException {
        ArithmeticExpression expr = new ArithmeticExpression();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("""
                Введите выражение в формате 8-7 или III*V");
                Число не должно превышать диапазон 0-10 и I-X !");
                На ввод принимаются только целые Числа!
                """);
        String expression = reader.readLine().toUpperCase(Locale.ENGLISH);
        if (!CheckReadingStringFor.rightCharacters(expression)) {
            throw new IllegalArgumentException(expression + " - неверное выражение!");
        }

        Pattern p = Pattern.compile("[/\\-+*]");
        Matcher m = p.matcher(expression);
        if (m.find()) {
            expr.setOperation(Operation.valueOf(expression.charAt(m.start())));
        } else {
            throw new IllegalArgumentException("Wrong operation!");
        }

        String[] numbers = expression.split("[/\\-+*]");
        String num1 = numbers[0];
        String num2 = numbers[1];
        if (CheckReadingStringFor.romanDigits(num1, num2)) {
            expr.setNumber1(new RomanNumber(num1));
            expr.setNumber2(new RomanNumber(num2));
        } else {
            if ((Integer.parseInt(num1)<0 || Integer.parseInt(num1)>10)||
                    (Integer.parseInt(num2)<0 || Integer.parseInt(num2)>10)){
                throw new IllegalArgumentException("Вы превысили допустимый диапазон арабских цифр!");
            }
            expr.setNumber1(new ArabicNumber(Integer.parseInt(num1)));
            expr.setNumber2(new ArabicNumber(Integer.parseInt(num2)));
        }
        return expr;
    }
}
