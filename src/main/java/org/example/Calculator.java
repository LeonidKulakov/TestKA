package org.example;

import org.example.constantData.ExceptionMassage;
import org.example.exception.InputDataNotCorrect;

import java.util.Arrays;
import java.util.List;

/**
 * По условию задания добавленный класс не должен иметь модификатора доступа
 */
class Calculator {
    private static final String SPLIT_ELEMENT = "\s";
    private static final String ROME_TYPE = "rome";
    private static final String ARABIC_TYPE = "arabic";
    private String operation;
    private String numType;
    private int a;
    private int b;

    /**
     * Метод работы с данными
     */
    public String dataProcessing(String inputData) {
        try {
            validateInputData(convertInputData(inputData));
        } catch (InputDataNotCorrect e) {
            throw new RuntimeException(e);
        }
        System.out.println("Output:");
        switch (operation) {
            case "+" -> {
                if (numType.equals(ROME_TYPE)) {
                    printRoman(add());
                } else {
                    printArab(add());
                }
            }
            case "-" -> {
                if (numType.equals(ROME_TYPE) && a > b) {
                    printRoman(subtract());
                } else if (numType.equals(ROME_TYPE) && a < b) {
                    throw new RuntimeException(ExceptionMassage.ROMAN_NOT_CAN_BE_NEGATIVE.getValue());
                } else {
                    printArab(subtract());
                }
            }
            case "*" -> {
                if (numType.equals(ROME_TYPE)) {
                    printRoman(multiply());
                } else {
                    printArab(multiply());
                }
            }
            case "/" -> {
                if (numType.equals(ROME_TYPE)) {
                    printRoman(divide());
                } else {
                    printArab(divide());
                }
            }
            default -> throw new RuntimeException(ExceptionMassage.UNKNOWN_FAIL.getValue());
        }

        return null;
    }

    /**
     * Метод разбивает строку полученную из консоли в List
     *
     * @param inputData строка полученная из консоли
     */
    private List<String> convertInputData(String inputData) {
        return Arrays.asList(inputData.split(SPLIT_ELEMENT));
    }

    /**
     * Метод проверяет валидность введенных данных
     *
     * @param listData разбитая на элементы строка полученная из консоли
     */
    private void validateInputData(List<String> listData) throws InputDataNotCorrect {
        if (listData.size() != 3)
            throw new InputDataNotCorrect(ExceptionMassage.INCORRECT_INPUT.getValue());
        if (!checkParseInt(listData.get(0)).equals(checkParseInt(listData.get(2))))
            throw new InputDataNotCorrect(ExceptionMassage.INCORRECT_INPUT.getValue());
        if (!listData.get(1).equals("-")
                && !listData.get(1).equals("+")
                && !listData.get(1).equals("*")
                && !listData.get(1).equals("/"))
            throw new InputDataNotCorrect(ExceptionMassage.INCORRECT_INPUT.getValue());
        else operation = listData.get(1);
        if (numType.equals(ROME_TYPE)) {
            try {
                a = RomanNumeric.getInputNumbers().get(listData.get(0));
                b = RomanNumeric.getInputNumbers().get(listData.get(2));
            } catch (NullPointerException e) {
                throw new InputDataNotCorrect(ExceptionMassage.INCORRECT_INPUT.getValue());
            }
        } else {
            a = Integer.parseInt(listData.get(0));
            b = Integer.parseInt(listData.get(2));
        }
        if (!((a >= 1 && a <= 10) && (b >= 1 && b <= 10))) {
            throw new InputDataNotCorrect(ExceptionMassage.INCORRECT_INPUT.getValue());
        }
    }

    private String checkParseInt(String value) {
        try {
            int operand = Integer.parseInt(value);
            numType = ARABIC_TYPE;
            return ARABIC_TYPE;
        } catch (NumberFormatException e) {
            numType = ROME_TYPE;
            return ROME_TYPE;
        }
    }

    /**
     * Метод выводит в консоль результат римскими цифрами
     *
     * @param res данные для вывода в консоль
     */
    private void printRoman(int res) {
        if (res == 100) {
            System.out.println(RomanNumeric.HUNDRED);
            return;
        } else if (res == 0) {
            System.out.println(ExceptionMassage.ROMAN_IS_NOT_HAS_ZERO.getValue());
        }
        System.out.print(RomanNumeric.getSecondOutputNumbers().get(res / 10));
        System.out.print(RomanNumeric.getFirstOutputNumbers().get(res % 10));
    }

    /**
     * Метод выводит в консоль результат арабскими цифрами
     *
     * @param res данные для вывода в консоль
     */
    private void printArab(int res) {
        System.out.println(res);
    }

    public int add() {
        return a + b;
    }

    public int subtract() {
        return a - b;
    }

    public int multiply() {
        return a * b;
    }

    public int divide() {
        return a / b;
    }
}
