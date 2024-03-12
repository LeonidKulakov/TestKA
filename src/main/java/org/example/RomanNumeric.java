package org.example;

import java.util.HashMap;
import java.util.Map;
/**
 * Хранилище данных ждя конвертации, вся логика кроме инициализации вынесена в Calculator
 *
 * По условию задания добавленный класс не должен иметь модификатора доступа
 * */
final class RomanNumeric {
    public static final String HUNDRED = "C";
    private static Map<String, Integer> inputNumbers;
    private static Map<Integer, String> firstOutputNumbers;
    private static Map<Integer, String> secondOutputNumbers;

    private static void createInputNumbers() {
        inputNumbers = new HashMap<>();
        inputNumbers.put("I",1);
        inputNumbers.put("II",2);
        inputNumbers.put("III",3);
        inputNumbers.put("IV",4);
        inputNumbers.put("V",5);
        inputNumbers.put("VI",6);
        inputNumbers.put("VII",7);
        inputNumbers.put("VIII",8);
        inputNumbers.put("IX",9);
        inputNumbers.put("X",10);
    }
    private RomanNumeric(){
    }

    private static void createFirstOutputNumbers() {
        firstOutputNumbers = new HashMap<>();
        firstOutputNumbers.put(0,"");
        firstOutputNumbers.put(1,"I");
        firstOutputNumbers.put(2,"II");
        firstOutputNumbers.put(3,"III");
        firstOutputNumbers.put(4,"IV");
        firstOutputNumbers.put(5,"V");
        firstOutputNumbers.put(6,"VI");
        firstOutputNumbers.put(7,"VII");
        firstOutputNumbers.put(8,"VIII");
        firstOutputNumbers.put(9,"IX");
    }
    private static void createSecondOutputNumbers() {
        secondOutputNumbers = new HashMap<>();
        secondOutputNumbers.put(1,"X");
        secondOutputNumbers.put(2,"XX");
        secondOutputNumbers.put(3,"XXX");
        secondOutputNumbers.put(4,"XL");
        secondOutputNumbers.put(5,"L");
        secondOutputNumbers.put(6,"LX");
        secondOutputNumbers.put(7,"LXX");
        secondOutputNumbers.put(8,"LXXX");
        secondOutputNumbers.put(9,"XC");
        secondOutputNumbers.put(0,"");
    }

    public static Map<String, Integer> getInputNumbers() {
        if (inputNumbers == null) createInputNumbers();
        return inputNumbers;
    }

    public static Map<Integer, String> getFirstOutputNumbers() {
        if (firstOutputNumbers == null) createFirstOutputNumbers();
        return firstOutputNumbers;
    }

    public static Map<Integer, String> getSecondOutputNumbers() {
        if (secondOutputNumbers == null) createSecondOutputNumbers();
        return secondOutputNumbers;
    }
}
