package com.taskapp;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Класс с вспомогательными методами
 */
public class TaskHelper {

    public static Scanner input = new Scanner(System.in);

    public static Random randomizer = new Random();

    public static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static List<String> splitSentenceToWords(String sentence) {
        List<String> wordList = Arrays.stream(sentence.split(" ")).collect(Collectors.toList());
        log.info("wordList: " + wordList);
        return wordList;
    }

}