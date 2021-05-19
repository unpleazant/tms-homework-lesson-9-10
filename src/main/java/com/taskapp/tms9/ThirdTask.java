package com.taskapp.tms9;

import java.util.InputMismatchException;
import java.util.List;

import static com.taskapp.TaskHelper.*;

/**
 * 3. Дана строка произвольной длины с произвольными словами.
 *   Написать программу для проверки является ли любое выюранное слово в строке полиндромом.
 *   Например, есть строка, вводится число 3, значит необходимо проверить является ли 3ей слово в этой строке полиндромом.
 *   Предусмотреть предупреждающие сообщения на случаи ошибочных ситуаций:
 *   например, в строке 5 слов, а на вход программе передали число 500 и т.п. ситуации.
 */
public class ThirdTask {

    private static List<String> wordList;

    public static void main(String[] args) {
        String sentence = "dniehb hhhhhhhhwewe 2mkmkmkkkkkkkkkkkkkk tenet";
        wordList = splitSentenceToWords(sentence);
        String word = wordList.get(wordIndexInput());
        validatePalindrome(word);
    }

    private static int wordIndexInput() {
        log.info("Enter word index: ");
        int wordIndex = input.nextInt();
        for (int i = 0; i < 3; i++) {
            if (wordIndex > wordList.size()) {
                log.warning("Wrong input data. Index out of baound. Try again.");
                wordIndex = input.nextInt();
            }
            else return wordIndex-1;
        }
        throw new InputMismatchException("Wrong input data");
    }

    private static void validatePalindrome(String word) {
        if (word.equals(reverseString(word))) log.info("Word \"" + word + "\" is a palindrome");
        else log.info("Word \"" + word + "\" is not a palindrome");
    }

    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

}
/**
 * /Library/Java/JavaVirtualMachines/jdk-10.0.1.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE 2.app/Contents/lib/idea_rt.jar=61284:/Applications/IntelliJ IDEA CE 2.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/evgeny/Documents/tms-homework-lesson-9-10/target/classes:/Users/evgeny/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar com.taskapp.tms9.ThirdTask
 * May 17, 2021 11:51:39 PM com.taskapp.tms9.ThirdTask wordIndexInput
 * INFO: Enter word index:
 * 11
 * May 17, 2021 11:51:44 PM com.taskapp.tms9.ThirdTask wordIndexInput
 * WARNING: Wrong input data. Index out of baound. Try again.
 * 4
 * May 17, 2021 11:51:54 PM com.taskapp.tms9.ThirdTask main
 * INFO: Word "tenet" is a palindrome
 *
 * Process finished with exit code 0
 */