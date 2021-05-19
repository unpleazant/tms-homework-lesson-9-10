package com.taskapp.tms9.nulltask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.taskapp.TaskHelper.log;
import static com.taskapp.TaskHelper.randomizer;

public class NullTaskHelper {

    private static StringBuilder sb = new StringBuilder();

    public static String twoDigitBlocks(String docNumber) {
        Pattern fourDigits = Pattern.compile("(\\d{4})");
        Matcher matcher = fourDigits.matcher(docNumber);
        String twoDigitBlocks = "";
        while (matcher.find()) twoDigitBlocks += matcher.group() + " ";
        return twoDigitBlocks;
    }

    public static String lettersFromDocNumber(String docNumber) {
        String strMask = "yyy/yyy/y/y";
        sb = new StringBuilder();
        StringBuilder letters = new StringBuilder(docNumber.replaceAll("[^a-zA-Z]", ""));
        for (Character ch : strMask.toCharArray()) {
            if (ch.equals('y')) {
                sb.append(letters.charAt(0));
                letters.deleteCharAt(0);
            }
            if (ch.equals('/')) sb.append('/');
        }
        return sb.toString();
    }

    public static String docNumberGenerator() {
        String setOfLetters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String setOfNumbers = "1234567890";
        String docMask = "xxxx-yyy-xxxx-yyy-xyxy";
        for (Character ch : docMask.toCharArray()) {
            if (ch.equals('y')) sb.append(getRandomSymbol(setOfLetters));
            if (ch.equals('x')) sb.append(getRandomSymbol(setOfNumbers));
            if (ch.equals('-')) sb.append('-');
        }
        log.info("Document number has been generated: " + sb.toString());
        return sb.toString();
    }

    public static void validateDocNumber(String docNumber) throws WrongDocumentNumberException {
        if (docNumber.contains("555") || docNumber.contains("1a2b") || docNumber.contains("abc")) {
            throw new WrongDocumentNumberException("The document contains an invalid sequence of characters");
        }
    }

    public static Character getRandomSymbol(String word) {
        return word.charAt(randomizer.nextInt(word.length() - 1));
    }

}
