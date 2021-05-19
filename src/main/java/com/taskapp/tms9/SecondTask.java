package com.taskapp.tms9;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.taskapp.TaskHelper.log;
import static com.taskapp.TaskHelper.splitSentenceToWords;

/**
 * Дана строка произвольной длины с произвольными словами.
 * Найти слово, в котором число различных символов минимально.
 * Слово может содержать буквы и цифры.
 * Если таких слов несколько, найти первое из них.
 * Например, в строке "fffff ab f 1234 jkjk" найденное слово должно быть "fffff".
 */
public class SecondTask {

    public static void main(String[] args) {
        String targetWord = null;
        String someSentence = "qwerty1 333333 ddd qwerty1 zxccc eeeeeeeeeeeeeee";
        List<String> wordList = splitSentenceToWords(someSentence);
        Set<Character> charSet = new HashSet<>(), chatSet2 = new HashSet<>();

        for (int i = 0; i < wordList.size(); i++) {
            charSet.clear();
            for (Character ch : wordList.get(i).toCharArray()) charSet.add(ch);
            if (i == 0) {
                chatSet2 = new HashSet<>(charSet);
                targetWord = wordList.get(i);
                continue;
            }
            if (charSet.size() < chatSet2.size()) {
                chatSet2 = new HashSet<>(charSet);
                targetWord = wordList.get(i);
            }
        }
        log.info("The first word with the minimum number of distinct characters is \"" + targetWord + "\"");
    }

}
/**
 * /Library/Java/JavaVirtualMachines/jdk-10.0.1.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE 2.app/Contents/lib/idea_rt.jar=62517:/Applications/IntelliJ IDEA CE 2.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/evgeny/Documents/tms-homework-lesson-9-10/target/classes:/Users/evgeny/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar com.taskapp.tms9.SecondTask
 * May 18, 2021 9:50:01 PM com.taskapp.TaskHelper splitSentenceToWords
 * INFO: wordList: [qwerty1, 333333, ddd, qwerty1, zxccc, eeeeeeeeeeeeeee]
 * May 18, 2021 9:50:01 PM com.taskapp.tms9.SecondTask main
 * INFO: The first word with the minimum number of distinct characters is "333333"
 *
 * Process finished with exit code 0
 */