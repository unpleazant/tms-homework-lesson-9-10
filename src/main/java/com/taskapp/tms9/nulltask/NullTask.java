package com.taskapp.tms9.nulltask;

import static com.taskapp.TaskHelper.log;
import static com.taskapp.tms9.nulltask.NullTaskHelper.*;

/**
 * 0.Написать программу со следующим функционалом:
 * На вход передать строку(будем считать, что это номер документа).
 * Номер документа имеет формат xxxx-yyy-xxxx-yyy-xyxy, где x - это число, а y - это буква.
 * Вывести на экран в одну строку два первых блока по 4 цифры
 * Вывести на экран номер документа, но блоки из трех букв заменить на *(каждая буква заменятся на *)
 * Вывести на экран только одни буквы из номера документа в формате yyy/yyy/y/y в нижнем регистре
 * Вывести на экран буквы из номера документа в формате "Letters:yyy/yyy/y/y" в верхнем регистре(реализовать с помощью класса StringBuilder)
 * Проверить содержит ли номер документа последовательность abc и вывети сообщение содержит или нет(причем, abc и ABC считается одинаковой последовательностью).
 * Проверить начинается ли номер документа с последовательности 555.
 * Проверить заканчивается ли номер документа на последовательность 1a2b.
 * Все эти методы реализовать в отдельном классе в статических методах, которые на вход(входным параметром) будут принимать ввводимую на вход программы строку.
 * <p>
 * добработать нулевое домашнее задание предыдущего урока.
 * Теперь надо создать свои классы исключений на каждую ситуацию:
 * - Проверить содержит ли номер документа последовательность abc.
 * - Проверить начинается ли номер документа с последовательности 555.
 * - Проверить заканчивается ли номер документа на последовательность 1a2b.
 * <p>
 * Если номер документа не удовлетворяет условию - то "бросить" исключение.
 * В методе класса, в котором будут вызываться эти методы для демонстрации работы, перехватить исключение конструкцией try-catch и в блоке catch вывести сообщение для пользователя(сообщение на консоль).
 */
public class NullTask {

    public static void main(String[] args) throws WrongDocumentNumberException {
        String docNumber = docNumberGenerator();
        validateDocNumber(docNumber);

        // Вывести на экран в одну строку два первых блока по 4 цифры
        log.info("The two first blocks with numbers: " + twoDigitBlocks(docNumber));

        // Вывести на экран номер документа, но блоки из трех букв заменить на * (каждая буква заменятся на *)
        log.info("The document number after replacement of the three letters blocks: " + docNumber.replaceAll("\\b[a-zA-Z]{3}\\b", "***"));

        // Вывести на экран только одни буквы из номера документа в формате yyy/yyy/y/y в нижнем регистре
        log.info("The letters from docNumber at lower case: " + lettersFromDocNumber(docNumber).toLowerCase());

        // Вывести на экран буквы из номера документа в формате "Letters:yyy/yyy/y/y" в верхнем регистре(реализовать с помощью класса StringBuilder)
        log.info("The letters from docNumber at upper case: " + lettersFromDocNumber(docNumber).toUpperCase());
    }

}
/**
 * /Library/Java/JavaVirtualMachines/jdk-10.0.1.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE 2.app/Contents/lib/idea_rt.jar=63259:/Applications/IntelliJ IDEA CE 2.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/evgeny/Documents/tms-homework-lesson-9-10/target/classes:/Users/evgeny/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar com.taskapp.tms9.nulltask.NullTask
 * May 19, 2021 2:27:33 PM com.taskapp.tms9.nulltask.NullTaskHelper docNumberGenerator
 * INFO: Document number has been generated: 6547-CSf-9898-nkX-1p9V
 * May 19, 2021 2:27:33 PM com.taskapp.tms9.nulltask.NullTask main
 * INFO: The two first blocks with numbers: 6547 9898
 * May 19, 2021 2:27:33 PM com.taskapp.tms9.nulltask.NullTask main
 * INFO: The document number after replacement of the three letters blocks: 6547-***-9898-***-1p9V
 * May 19, 2021 2:27:33 PM com.taskapp.tms9.nulltask.NullTask main
 * INFO: The letters from docNumber at lower case: csf/nkx/p/v
 * May 19, 2021 2:27:33 PM com.taskapp.tms9.nulltask.NullTask main
 * INFO: The letters from docNumber at upper case: CSF/NKX/P/V
 *
 * Process finished with exit code 0
 */