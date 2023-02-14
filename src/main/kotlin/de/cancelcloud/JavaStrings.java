package de.cancelcloud;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class JavaStrings {

    public static void main(String[] args) {
        //task 1
        String task1 = "Java Exercises!";
        getCharAt(task1, 0);
        //task 2
        String task2 = "w3resource.com";
        getCodePointAt(task2, 5);
        //task 3
        String task3 = "w3resource.com";
        getCodePointBefore(task3, 5);
        //task 4
        String task4 = "w3resource.com";
        countUnicodePoints(task4);
        //task 5
        String task5_1 = "This is Exercise 1";
        String task5_2 = "This is Exercise 2";
        //task 6
        String task6_1 = "This is Exercise 1";
        String task6_2 = "This is Exercise 1";
        //task 7
        String task7_1 = "PHP Exercises and";
        String task7_2 = "Python Exercises";
        concatStrings(task7_1, task7_2);
        //task 8
        String task8_1 = "PHP Exercises and Python Exercises";
        containsString(task8_1, "and");
        //task 9
        String task9_1_1 = "example.com";
        String task9_1_2 = "example.com";
        String task9_2_1 = "Example.com";
        String task9_2_2 = "example.com";
        compareStrings(task9_1_1, task9_1_2);
        compareStrings(task9_2_1, task9_2_2);
        //task 10
        String task10_1_1 = "example.com";
        String task10_1_2 = "example.com";
        String task10_2_1 = "Example.com";
        String task10_2_2 = "example.com";
        equalsStringBuffer(task10_1_1, task10_1_2);
        //task 11
        char[] arr_num = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        mixIntString(arr_num);
        //task 12
        // does String end with "se"?
        String task12_1_1 = "Python Exercises";
        String task12_1_2 = "Python Exercise";
        endsWith(task12_1_1, "se");
        endsWith(task12_1_2, "se");
        //task 13
            /*
            "Stephen Edwin King" equals "Walter Winchell"? false
            "Stephen Edwin King" equals "Mike Royko"? false
            */
        stringContains("Stephen Edwin King", "Walter Winchell");
        stringContains("Stephen Edwin King", "Mike Royko");
        //task 14
        String task14_1 = "Stephen Edwin King"; // equals "Walter Winchell"? false
        String task14_2 = "Stephen Edwin King";  //equals "stephen edwin king"? true
        equalsIgnoreCase(task14_1, "Walter Winchell");
        equalsIgnoreCase(task14_2, "stephen edwin king");
        //task 15
        //print date with custom format
        printCurrentDate();
        //task 16
        String task16_1= "Im the default String";
        countBytes(task16_1);
        //task 17
        getCharArray("Im the default String");
        //task 18
        String task18_1 = "The hash for Python Exercises.";
        getHash(task18_1);
        //task 19
        String task19_1 = "Python Exercises are very unique!";
        getFirstIndex(task19_1);
        //task 20
        String task20_1 = "Python Exercises";
        checkequality(task20_1);

        //task 40
        String task40_1 = "PythonExercises";
        int chunkSize = 5;
        splitString(task40_1, chunkSize);

        //task 37
                /*
                Input String : pickoutthelongestsubstring
                The longest substring : [u, b, s, t, r, i, n, g]
                The longest Substring Length : 8
                */
        longSubString("pickoutthelongestsubstring");


    }


    public static Character getCharAt(String str, int index) {
        return str.charAt(index);
    }

    public static int getCodePointAt(String str, int index) {
        return str.codePointAt(index);
    }

    public static int getCodePointBefore(String str, int index) {
        return str.codePointBefore(index);
    }

    public static int countUnicodePoints(String str) {
        return str.codePointCount(0, str.length());
    }

    public static int compareStrings(String str1, String str2) {
        return str1.compareTo(str2);
    }

    public static String concatStrings(String str1, String str2) {
        return str1.concat(str2);
    }

    public static boolean containsString(String all, String criterea) {
        return all.contains(criterea);
    }

    public static boolean equalsStrings(String str1, String str2) {
        return str1.equals(str2);
    }

    public static boolean equalsStringBuffer(String str1, String str2) {
        StringBuilder strbuf = new StringBuilder(str1);
        return str1.contentEquals(strbuf);
    }

    public static String mixIntString(char[] arr_num) {
        return String.copyValueOf(arr_num, 1, 3);
    }

    public static boolean endsWith(String str, String criterea) {
        return str.endsWith(criterea);
    }

    public static boolean stringContains(String str, String criterea) {
        return str.contains(criterea);
    }

    public static boolean equalsIgnoreCase(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);
    }

    public static String printCurrentDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(date);
    }

    public static int countBytes(String str) {
        return str.getBytes().length;
    }

    public static String getCharArray(String str) {
        return Arrays.toString(str.toCharArray());
    }

    public static String getHash(String str) {
        return Integer.toHexString(str.hashCode());
    }

    public static void getFirstIndex(String str) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                System.out.println("Index of first occurrence of " + c + ": " + i);
            }
        }
    }

    public static void checkequality (String str) {
        {
            String str1 = "Java Exercises";
            String str2 = new StringBuffer("Java").append(" Exercises").toString();
            String str3 = str2.intern();

            System.out.println("str1 == str2? " + (str1.equals(str2)));
            System.out.println("str1 == str3? " + (str1.equals(str3)));
        }
    }

    public static void splitString(String str, int chunkSize) {
        for (int i = 0; i < str.length(); i += chunkSize) {
            System.out.println(str.substring(i, Math.min(str.length(), i + chunkSize)));
        }
    }

    public static void longSubString(String str) {
        int maxLength = 0;
        String longestSubstring = "";
        Set<Character> charSet = new HashSet<>();

        int i = 0, j = 0;
        while (j < str.length()) {
            if (!charSet.contains(str.charAt(j))) {
                charSet.add(str.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j - i);
                longestSubstring = str.substring(i, j);
            } else {
                charSet.remove(str.charAt(i));
                i++;
            }
        }
        System.out.println("The longest substring: " + longestSubstring);
        System.out.println("The longest substring length: " + maxLength);
    }

}