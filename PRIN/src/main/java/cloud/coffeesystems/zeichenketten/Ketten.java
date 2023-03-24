package cloud.coffeesystems.zeichenketten;

import java.util.Scanner;

public class Ketten {


    // Task 2
    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Gib einen Text ein: ");
            String text = scanner.nextLine();

            System.out.print("Gib ein Zeichen ein: ");
            char zeichen = scanner.nextLine().charAt(0);

            if (istCharInString(text, zeichen)) {
                System.out.printf("%c ist in \"%s\" enthalten.\n", zeichen, text);
            } else {
                System.out.printf("%c ist nicht in \"%s\" enthalten.\n", zeichen, text);
            }


            // Task 2

            System.out.print("Gib einen Text ein: ");
            String task2text = scanner.nextLine();
            System.out.print("Gib das zu zählende Zeichen ein: ");
            char c = scanner.next().charAt(0);
            int count = countChar(task2text, c);
            System.out.printf("%c ist in \"%s\" %dx enthalten.%n", c, task2text, count);

            //task 4
            allposabilities("abc");

            //task 5
            removeXExceptFirstLast("xHix");
        }


    }

    // Task 1

    //a
    public static String revert(String s) {
        char[] charArray = s.toCharArray();
        int i = 0;
        int j = charArray.length - 1;
        while (i < j) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }
        return new String(charArray);
    }

    //b
    public static boolean istPalindrom(String s) {
        String reversed = revert(s);
        return s.equals(reversed);
    }


    public static boolean istCharInString(String s, char c) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    public static int countChar(String text, char c) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }


    //task 3
    public static String capitalizeLastThree(String input) {
        if (input.length() <= 3) {
            return input.toUpperCase();
        } else {
            String firstPart = input.substring(0, input.length() - 3);
            String lastThree = input.substring(input.length() - 3).toUpperCase();
            return firstPart + lastThree;
        }
    }

    //task 4
    public static void allposabilities(String zeichen) {
        if (zeichen.length() != 3) {
            System.out.println("Fehler: Sie müssen genau drei Zeichen eingeben.");
            return;
        }

        char[] zeichenArray = zeichen.toCharArray();
        System.out.println("Alle möglichen Kombinationen:");
        System.out.println("-----------------------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i != j && i != k && j != k) {
                        System.out.println("" + zeichenArray[i] + zeichenArray[j] + zeichenArray[k]);
                    }
                }
            }
        }
    }

    public static String removeXExceptFirstLast(String str) {
        if (str == null || str.length() <= 2) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0)); // Add first character
        for (int i = 1; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            if (c != 'x' && c != 'X') {
                sb.append(c);
            }
        }
        sb.append(str.charAt(str.length() - 1)); // Add last character
        return sb.toString();
    }

}
