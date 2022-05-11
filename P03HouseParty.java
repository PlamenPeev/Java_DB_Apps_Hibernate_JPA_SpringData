package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        List<String> guests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] typeGoing = input.split(" ");
            String currentName = typeGoing[0];

            if(typeGoing[2].equals("going!")){
                // ako ne e в листа от гости, го вкарваме в него
                if(guests.contains(currentName)) {
                    System.out.printf("%s is already in the list!", currentName);
                    System.out.println();
                }else{
                    guests.add(currentName);
                }
            }else if(typeGoing[2].equals("not")){
                //ako e в листа, го махаме
                if(guests.contains(currentName)){
                    guests.remove(currentName);
                }else{
                    System.out.printf("%s is not in the list!", currentName);
                    System.out.println();
                }
            }
        }
        for ( String name : guests) {
            System.out.println(name);
        }
    }
}
