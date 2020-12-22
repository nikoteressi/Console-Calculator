package calculator;

import java.util.List;

public class ConvertDigits {

    public static String toRoman(int number) {
        try {
            if ((number <= 0)) {
                throw new IllegalArgumentException();
            }
        }   catch(IllegalArgumentException e){
                System.err.println("В римских цифрах нет нулевого значения!");
            }

        List<Roman> romanNumerals = Roman.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            Roman currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    public static int toArabic(String romanDigit) {
        int arabicDigit = 0;
        Roman[] r = Roman.values();
        String[] roman = new String[r.length];

        for (int i = r.length - 1; i >= 0; i--) {
            roman[i]=r[i].toString();
            if (romanDigit.equals(roman[i])){
              arabicDigit = r[i].getValue();
            }
        }
        if (arabicDigit == 0){
            try{
                throw new OutOfRangeExeption();
            }catch(OutOfRangeExeption e){
                System.err.println("Вы ввели неверное число!");
            }
        }
        return arabicDigit;
    }
        }

