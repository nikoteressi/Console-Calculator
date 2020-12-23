package calculator;

public class Operations {

    public static double calculating(String expression, int a, int b) {
        double result = 0;

        int i = expression.length() - 1;
        while (i >= 0) {

            switch (expression.charAt(i)) {
                case '+' -> result = a + b;
                case '-' -> result = a - b;
                case '*' -> result = a * b;
                case '/' -> result = (double) a / b;
            }

            i--;
        }

        return result;
    }
}
