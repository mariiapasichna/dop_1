package com.mariiapasichna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSeach {

    public static List<Integer> performSearch(String text, String pattern) {
        int[] compliedPatternArray = compilePatternArray(pattern);
        int textIndex = 0;
        int patternIndex = 0;
        List<Integer> foundIndexes = new ArrayList<>();

        while (textIndex < text.length()) {
            if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
                patternIndex++;
                textIndex++;
            }
            if (patternIndex == pattern.length()) {
                foundIndexes.add(textIndex - patternIndex);
                patternIndex = compliedPatternArray[patternIndex - 1];
            } else if (textIndex < text.length() && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
                if (patternIndex != 0) {
                    patternIndex = compliedPatternArray[patternIndex - 1];
                } else {
                    textIndex = textIndex + 1;
                }
            }
        }
        return foundIndexes;
    }

    public static int[] compilePatternArray(String pattern) {
        int length = 0;
        int i = 1;
        int[] compliedPatternArray = new int[pattern.length()];
        compliedPatternArray[0] = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                compliedPatternArray[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = compliedPatternArray[length - 1];
                } else {
                    compliedPatternArray[i] = length;
                    i++;
                }
            }
        }
        //System.out.println(Arrays.toString(compliedPatternArray));
        return compliedPatternArray;
    }
}