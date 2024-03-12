package org.example.exception;
/**
 * Т.К. исключение не совсем обычный класс - модификатор доступа оставил
 */
public class InputDataNotCorrect extends Exception{

    public InputDataNotCorrect(String message) {
        super(message);
    }
}
