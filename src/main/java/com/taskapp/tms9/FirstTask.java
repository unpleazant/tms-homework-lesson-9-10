package com.taskapp.tms9;

import java.util.Comparator;
import java.util.List;

import static com.taskapp.TaskHelper.log;
import static com.taskapp.TaskHelper.splitSentenceToWords;

/**
 * 1. Дана строка произвольной длины с произвольными словами.
 *   Найти самое короткое слово в строке и вывести его на экран.
 *   Найти самое длинное слово в строке и вывести его на экран.
 *   Если таких слов несколько, то вывести последнее из них.
 */
public class FirstTask {

    public static void main(String[] args) {
        String sentence = "Дана строка произвольной длины с произвольными словами";
        List<String> words = splitSentenceToWords(sentence);
        words.sort(Comparator.comparing(String::length));
        log.info("The Shortest word is: " + words.get(0));
        log.info("The Longest word is: " + words.get(words.size()-1));
    }

}
/**
 * /Library/Java/JavaVirtualMachines/jdk-10.0.1.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE 2.app/Contents/lib/idea_rt.jar=59188:/Applications/IntelliJ IDEA CE 2.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/evgeny/Documents/tms-homework-lesson-9-10/target/classes:/Users/evgeny/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar com.taskapp.tms9.FirstTask
 * May 17, 2021 5:38:46 PM com.taskapp.tms9.FirstTask main
 * INFO: Shortest word in string is: с
 * May 17, 2021 5:38:46 PM com.taskapp.tms9.FirstTask main
 * INFO: Longest word in string is: произвольными
 *
 * Process finished with exit code 0
 */