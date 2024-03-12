package org.example.constantData;

public enum ExceptionMassage {
    INCORRECT_INPUT("Не корректный ввод"), ROMAN_IS_NOT_HAS_ZERO("В римских цифрах нет 0"),
    ROMAN_NOT_CAN_BE_NEGATIVE("Результат не может быть отрицательным"),UNKNOWN_FAIL("Неизвестный сбой");

    private String value;

    ExceptionMassage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
