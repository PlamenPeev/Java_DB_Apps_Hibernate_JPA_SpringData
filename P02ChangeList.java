package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "Delete":
                    int deleteElement = Integer.parseInt(commands[1]);
                    for (int i = 0; i < numbers.size()-1; i++) {
                        numbers.remove(Integer.valueOf(deleteElement));
                    }
                    break;
                case "Insert":
                    //Insert {element} {position}
                    int elementInsert = Integer.parseInt(commands[1]);
                    int positionInsert = Integer.parseInt(commands[2]);
                    numbers.add(positionInsert, elementInsert);
                    break;
            }
            input = scanner.nextLine();
        }
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
