package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] operations = input.split("\\s+");

            switch (operations[0]) {
                case "Add":
                    // Add {number} - add number at the end
                    int numberAdd = Integer.parseInt(operations[1]);
                    numbers.add(numberAdd);
                    break;
                case "Insert":
                    // Insert {number} {index} - insert number at given index
                    int numberInsert = Integer.parseInt(operations[1]);
                    int indexInsert = Integer.parseInt(operations[2]);
                    boolean isValid = isValidIndex(indexInsert, numbers);
                    if(isValid) {
                        numbers.add(indexInsert, numberInsert);
                    }else{
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    // Remove {index} - remove that index
                    int indexRemove = Integer.parseInt(operations[1]);
                    boolean isValidRemove = isValidIndex(indexRemove, numbers);
                    if(isValidRemove) {
                        numbers.remove(indexRemove);
                    }else{
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(operations[2]);
                    if (operations[1].equals("left")) {
                        // Shift left {count} - first number becomes last 'count' times
                        getLeftTurn(numbers, count);
                    } else if (operations[1].equals("right")) {
                        // Shift right {count} - last number becomes first 'count' times
                        getRightTurn(numbers, count);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        for ( int num : numbers) {
            System.out.print(num + " ");
        }
    }

    private static boolean isValidIndex( int index,   List<Integer> list) {
        if ( index >= 0 && index <= list.size()-1){
            return true;
        }else{
            return false;
        }
    }

    private static void getRightTurn(List<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            int lastNum = list.get(list.size()-1);
            list.add(0, lastNum);
            list.remove(list.size()-1);

        }
    }

    private static void getLeftTurn(List<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            int firstNum = list.get(0);
            list.add(firstNum);
            list.remove(0);
        }
    }
}
