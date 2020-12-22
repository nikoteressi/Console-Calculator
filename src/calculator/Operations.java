package calculator;

public class Operations {

    public static double calculating(String expression, int a, int b ) {
        double result = 0;

        for (int i = 0; i < expression.length(); i++) {

            switch (expression.charAt(i)) {
                case '+' -> result = a + b;
                case '-' -> result = a - b;
                case '*' -> result = a * b;
                case '/' -> result = (double)a / b;
            }

        }

        return result;
    }
}
