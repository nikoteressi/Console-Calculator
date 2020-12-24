package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckReadingStringFor {

    public static boolean rightCharacters(String expression) {

        Pattern p = Pattern.compile("([0-9]|[IVXivx]+)[-+/*]([0-9]|[IVXivx]+)");
        Matcher m = p.matcher(expression);

        if (expression.contains("."))
            throw new IllegalArgumentException("Калькулятор работает только с целыми числами!");

        return m.find();
    }

    public static boolean romanDigits(String num1, String num2) {

        boolean marker = false;

        Pattern p = Pattern.compile("[IVXivx]");
        Matcher m1 = p.matcher(num1);
        Matcher m2 = p.matcher(num2);

        if (m1.find() && m2.find()) {
            marker = true;
        }
        return marker;
    }
}