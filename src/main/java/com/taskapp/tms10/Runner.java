package com.taskapp.tms10;

import static com.taskapp.TaskHelper.*;

/**
 * Создать класс, в котором будет статический метод.
 * Этот метод принимает на вход три параметра:
 *   login
 *   password
 *   confirmPassword
 * Все поля имеют тип данных String.
 * Длина login должна быть меньше 20 символов и не должен содержать пробелы.
 * Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
 * Длина password должна быть меньше 20 символов, не должен содержать пробелом и должен содержать хотя бы одну цифру.
 * Также password и confirmPassword должны быть равны.
 * Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
 * WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами
 * – один по умолчанию, второй принимает сообщение исключения и передает его в конструктор класса Exception.
 * Метод возвращает true, если значения верны или false в другом случае.
 */
public class Runner {

    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        String login, password, confirmPassword;

        log.info("Enter login to console: ");
        login = input.nextLine();
        log.info("Enter password: ");
        password = input.nextLine();
        log.info("Confirm password: ");
        confirmPassword = input.nextLine();

        validateCredentials(login, password, confirmPassword);
    }

    private static void validateCredentials(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (isLoginCorrect(login)) {
            log.info("Login entered");
        } else throw new WrongLoginException();

        if (isPasswordCorrect(password)) {
            log.info("Password entered");
        } else throw new WrongPasswordException("Incorrect login or password");

        if (password.equals(confirmPassword)) {
            log.info("Password confirmed");
        } else throw new WrongPasswordException("Password is not match");
    }

    private static boolean isLoginCorrect(String login) {
        return login.length() <= 20 || !login.contains(" ");
    }

    private static boolean isPasswordCorrect(String password) {
        return password.length() <= 20 && !password.contains(" ") && password.matches("[a-zA-Z ]*\\d+.*");
    }

}