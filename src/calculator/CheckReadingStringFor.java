package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckReadingStringFor {

    public static boolean rightCharacters(String expression){
        boolean marker = false;
        Pattern p = Pattern.compile("([0-9]|[IVX]+)([-+/*])([0-9]|[IVX]+)");
        Matcher m = p.matcher(expression);
        if (!m.find()){
            try {
                throw new WrongExpressionException();
            }catch(WrongExpressionException e){
                System.err.println("Вы ввели неверное выражение!Формат ввода: II+V или 5-4.");
            }
        }
        else marker = true;

        return marker;
    }

    public static boolean romanDigits(String num1, String num2){

        boolean marker = false;
        Pattern p = Pattern.compile("[IVX]");
        Matcher m1 = p.matcher(num1);
        Matcher m2 = p.matcher(num2);

        if (m1.find() && m2.find()){ marker = true;}

            return marker;

    }
}
