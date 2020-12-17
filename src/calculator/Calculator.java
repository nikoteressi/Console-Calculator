package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static void main(String[] args) throws IOException {

        System.out.println("Введите два числа и операцию в формате : (10*5) или (II + V)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expression = reader.readLine();

        /* Запуск проверки чисел в строке и извлечение их в массив */
        Pattern pattern = Pattern.compile("[0-9]+,[I-X]");
        Matcher matcher = pattern.matcher(expression);
        List digits = new ArrayList();
        while (matcher.find()) {
            int n = Integer.parseInt(matcher.group());
            digits.add(n);
        }
        int a = (int) digits.get(0);
        int b = (int) digits.get(1);
        if (a > 10 || b > 10) {
            System.out.println("Вы превысили допустимый диапазон чисел.");
            System.out.println("Пожалуйста, попробуйте заново...");
        } else {

            /*Проверка какую операцию необходимо выполнить*/
            char operation;
            if (expression.contains("+")) System.out.println(Operations.getSum(a, b));
            else if (expression.contains("-")) System.out.println(Operations.getDiff(a, b));
            else if (expression.contains("*")) System.out.println(Operations.getMulti(a, b));
            else if (expression.contains("/")) System.out.println(Operations.getDiv(a, b));
        }
    }
    }

