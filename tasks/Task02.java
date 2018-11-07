package tasks;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter N: ");
        int N = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i < N; i += 2) {
            System.out.print(i + " ");
            sum += i;
        }

        System.out.println("\nSum of even numbers: " + sum);

        scanner.close();
    }
}
