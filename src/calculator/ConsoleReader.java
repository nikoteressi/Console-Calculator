package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleReader {

    public static void readerStart() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("""
                Введите выражение в формате 8-7 или III*V");
                Число не должно превышать диапазон 0-10 и I-X !");
                На ввод принимаются только целые Числа!
                """);

        String expression = reader.readLine();

        if (CheckReadingStringFor.rightCharacters(expression)) {

            String[] numbers = expression.split("[+-/*]");
            String num1 = numbers[0];
            String num2 = numbers[1];
            int a, b;


            if (CheckReadingStringFor.romanDigits(num1, num2)) {

                a = ConvertDigits.toArabic(num1);
                b = ConvertDigits.toArabic(num2);

                if (a == 0 || b == 0) {

                    throw new NumberFormatException("Вы ввели неверное римское число!");
                } else

                    ConvertDigits.toRoman((int) Operations.calculating(expression, a, b));
            } else {

                try {
                    a = Integer.parseInt(num1);
                    b = Integer.parseInt(num2);

                    if (expression.contains("/") && b == 0) throw new ArithmeticException("На 0 делить нельзя");

                    System.out.println(Operations.calculating(expression, a, b));

                } catch (NumberFormatException e) {

                    System.err.println("""
                            Вы ввели неверное значение!
                            В выражении должны быть только арабские числа либо только римские!
                            Пример правильного выражения: 10/6 или V*X . 
                            """);
                }
            }
        } else
            throw new NumberFormatException("""
                                        
                                        
                    Вы ввели неверный операнд!
                    Допустимые виды операций: + * - / .
                    """);
    }
}