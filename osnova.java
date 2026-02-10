package koko;
import java.util.Scanner;
public class osnova {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" FIGHT ARENA");
        System.out.print("Име на първия боец: ");
        String nameA = sc.nextLine();
        System.out.print("Начални калории за " + nameA + ": ");
        int caloriesA = sc.nextInt();
        sc.nextLine();
        System.out.print("Име на втория боец:");
        String nameB = sc.nextLine();
        System.out.print("Начални калории за " + nameB + ": ");
        int caloriesB = sc.nextInt();
        //polimorfizum
        Fighter fighterA = new Boxer(nameA) {};
        Fighter fighterB = new Karate(nameB) {};
        fighterA.nutrition = new Nutrition(caloriesA);
        fighterB.nutrition = new Nutrition(caloriesB);
        fighthing.fight(fighterA, fighterB);
        sc.close();
    }
}

