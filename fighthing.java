package koko;
import java.util.Scanner;
public class fighthing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Boxer name:");
        String boxerName = sc.nextLine();
        System.out.println("Enter Boxer strength:");
        int boxerStrength = sc.nextInt();
        System.out.println("Enter Boxer stamina:");
        int boxerStamina = sc.nextInt();
        sc.nextLine();
        Boxer boxer = new Boxer(boxerName, boxerStrength, boxerStamina);
        System.out.println("\nEnter Karate fighter name:");
        String karateName = sc.nextLine();
        System.out.println("Enter Karate strength:");
        int karateStrength = sc.nextInt();
        System.out.println("Enter Karate stamina:");
        int karateStamina = sc.nextInt();
        Karate karate = new Karate(karateName, karateStrength, karateStamina);
        System.out.println("\n Round 1");
        boxer.attack(karate);
        boxer.criticalHit(karate);
        if (karate.stamina <= 0) {
            System.out.println("\nKnockout! " + karate.name + " has been defeated!");
            return;
        }
        karate.attack(boxer);
        karate.criticalHit(boxer);

        if (boxer.stamina <= 0) {
            System.out.println("\n Knouckout! " + boxer.name + " has been defeated!");
            return;
        }
        System.out.println("\n Fighters recover between rounds");
        boxer.recover();
        karate.recover();
        boxer.rest();
        karate.rest();
        System.out.println("\nRound 2");
        boxer.attack(karate);
        karate.attack(boxer);
        if (boxer.stamina > karate.stamina) {
            System.out.println("\nWinner: " + boxer.name);

        } else if (karate.stamina > boxer.stamina) {
            System.out.println("\n Winner: " + karate.name);
    } else {
            System.out.println("\n Draw");
}
        System.out.println("\nFinal status");
        boxer.showStatus();
        karate.showStatus();
        sc.close();
    }
}

