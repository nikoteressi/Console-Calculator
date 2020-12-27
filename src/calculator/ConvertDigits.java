package calculator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ConvertDigits {

    public static String toRoman(int arabicNumber) {

        if ((arabicNumber <= 0)) {
            throw new IllegalArgumentException("В римских цифрах нет нулевого и отрицательного значения!");
        }

        List<Roman> romanNumbers = Arrays.stream(Roman.values())
                .sorted(Comparator.comparing(Roman::getValue).reversed())
                .collect(Collectors.toList());
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((arabicNumber > 0) && (i < romanNumbers.size())) {
            if (romanNumbers.get(i).getValue() <= arabicNumber) {
                sb.append(romanNumbers.get(i).name());
                arabicNumber -= romanNumbers.get(i).getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static int toArabic(String romanDigit) {
        int arabicDigit = 0;
        Roman[] roman = Roman.values();
        String rom = romanDigit.toUpperCase(Locale.ENGLISH);

        for (Roman r : roman) {
            if (rom.equals(r.name())) {
                arabicDigit = r.getValue();
            }
        }
        return arabicDigit;
    }
}

