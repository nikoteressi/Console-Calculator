package calculator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ConvertDigits {

    public static String toRoman(int arabicNumber) {

        //Создаём список типа Roman отсортированными задом наперёд значениями.
        //Инициируем счётчик и StringBuilder.
        //Запускаем цикл переборки всех элементов списка при условии что входная цифра больше 0.
        //Создаём новый обьект Roman, и присваиваем ему текущее значение из List
        //При условии, что арабское значение у объекта Roman меньше либо равно входного арабского значения.
        //Записать имя этого элемента в строку и отнять от входного арабского значение арабское значение элемента.
        //Иначе добавить один к счётчику.

        try {
            if ((arabicNumber <= 0)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("В римских цифрах нет нулевого и отрицательного значения!");
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

        //Сдесь создаём массив обьектов типа Roman.
        //Переводим риские цифры в большие, если они были введены маленькими.
        //Зпускаем цикл For Each и сравниваем значение введённого римского числа с числом из массива объектов.
        //если есть сосвпадение, то присваиваем переменной arabicDigit арабский аргумент римского числа.

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

