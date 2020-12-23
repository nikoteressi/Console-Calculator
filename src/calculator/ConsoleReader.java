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
        if (calculator.CheckReadingStringFor.rightCharacters(expression)) {
            String[] numbers = expression.split("[+-/*]");
            String num1 = numbers[0];
            String num2 = numbers[1];
            int a;
            int b;

            if (calculator.CheckReadingStringFor.romanDigits(num1, num2)) {
                a = calculator.ConvertDigits.toArabic(num1);
                b = calculator.ConvertDigits.toArabic(num2);
                if ((a > 10 || a <= 0) || (b > 10 || b <= 0)) {
                    try {
                        throw new OutOfRangeExeption();
                    } catch (OutOfRangeExeption e) {
                        System.err.println("Вы превысили доспустимый диапазон значений! Допустимые диапазоны: 0-10 или I-X.");
                    }
                } else
                    System.out.println(ConvertDigits.toRoman((int) calculator.Operations.calculating(expression, a, b)));
            } else {
                try {
                    a = Integer.parseInt(num1);
                    b = Integer.parseInt(num2);
                    if ((a > 10 || a < 0) || (b > 10 || b < 0)) {
                        try {
                            throw new OutOfRangeExeption();
                        } catch (OutOfRangeExeption e) {
                            System.err.println("Вы превысили доспустимый диапазон значений! Допустимые диапазоны: 0-10 или I-X.");
                        }
                    } else
                        System.out.println(calculator.Operations.calculating(expression, a, b));
                } catch (NumberFormatException e) {
                    System.err.println("""
                            Вы ввели неверное значение!
                            В выражении должны быть только арабские числа либо только римские!
                            Вводите только правильные римские числа: "I II III IV V VI VII VIII IX X"
                            """);
                }
            }
        }
    }
}


