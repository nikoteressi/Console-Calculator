package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckReadingStringFor {

    public static boolean rightCharacters(String expression) {
        boolean marker = false;
        if (expression.matches("(\\d+|[IVXivx]+)[/\\-+*](\\d+|[IVXivx]+)")) {
            marker = true;
        }
        return marker;
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