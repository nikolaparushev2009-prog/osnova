package combat.sports;
import java.util.Scanner;
public class Fighterarena {
        public static Fighter createFighter(Scanner sc) {
                System.out.println("1 - Boxer");
                System.out.println("2 - Karate");
                System.out.println("3 - MMA");
                System.out.println("Choose fighter type:");
                int choice = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter name:");
                String name = sc.nextLine();
                System.out.println("Enter strength:");
                int strength = sc.nextInt();
                System.out.println("Enter stamina:");
                int stamina = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                        case 1:
                                return new Boxer(name, strength, stamina);
                        case 2:
                                return new Karate(name, strength, stamina);
                        case 3:
                                return new MMAFighter(name, strength, stamina);
                        default:
                                return new Boxer(name, strength, stamina);
                }
        }
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Create Fighter 1:");
                Fighter fighter1 = createFighter(sc);
                System.out.println("\nCreate Fighter 2:");
                Fighter fighter2 = createFighter(sc);
                System.out.println("\nRound 1 ");
                fighter1.attack(fighter2);
                ((Bleeding)fighter2).BleedingDamage();
                fighter2.attack(fighter1);
                ((Bleeding)fighter1).BleedingDamage();
                if (fighter1.stamina <= 0) {
                        System.out.println("Knockout " + fighter1.name + " lost!");
                        return;
                }
                if (fighter2.stamina <= 0) {
                        System.out.println(" Knockout " + fighter2.name + " lost!");
                        return;
                }
                System.out.println("\nRecovery between Rounds");
                ((Recovery)fighter1).recover();
                ((Recovery)fighter2).recover();
                ((Recovery)fighter1).rest();
                ((Recovery)fighter2).rest();
                System.out.println("\n Round 2");
                fighter1.attack(fighter2);
                fighter2.attack(fighter1);
                ((Bleeding)fighter1).BleedingDamage();
                ((Bleeding)fighter2).BleedingDamage();
                if (fighter1.stamina > fighter2.stamina) {
                        System.out.println(" Winner: " + fighter1.name);
                } else if (fighter2.stamina > fighter1.stamina) {
                        System.out.println("Winner: " + fighter2.name);
                } else {
                        System.out.println(" Draw!");
                }
                System.out.println("\nFinal status");
                fighter1.showStatus();
                fighter2.showStatus();
                sc.close();
        }
}