package tasks;

import java.util.*;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number");
        int num1 = scanner.nextInt();
        System.out.println("Enter second number");
        int num2 = scanner.nextInt();
        System.out.println("Enter third number");
        int num3 = scanner.nextInt();

        String[] array = new String[6];

        array[0] = num1 + "" + num2 + "" + num3;
        array[1] = num1 + "" + num3 + "" + num2;
        array[2] = num2 + "" + num1 + "" + num3;
        array[3] = num2 + "" + num3 + "" + num1;
        array[4] = num3 + "" + num1 + "" + num2;
        array[5] = num3 + "" + num2 + "" + num1;

        //Remove duplicates with HashSet
        Set<String> set = new HashSet<String>(Arrays.asList(array));
        ArrayList<String> list = new ArrayList<String>(set);

        //Remove numbers which start with 0
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith("0")) {
                list.remove(i--);
            }
        }

        System.out.print("All sorts of combinations: ");
        for (String out : list) {
            System.out.print(out + " ");
        }

        scanner.close();
    }
}
