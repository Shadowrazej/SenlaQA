package tasks;

import java.util.*;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String sentence = scanner.nextLine();

        //Array with words from sentence, can add toLowerCase() to ignore case
        String[] arrayWords = sentence.split(", | ");
        int count = 0;
        String sortedWords = "";

        Arrays.sort(arrayWords);

        for (String output : arrayWords) {
            sortedWords = sortedWords.concat(output + " ");
            count++;
        }

        System.out.println("Sorted String: " + sortedWords);
        System.out.println("Сount: " + count);

        scanner.close();
    }
}
