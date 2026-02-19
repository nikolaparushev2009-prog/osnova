package combat.sports;
import java.util.Scanner;
public class Fighterarena {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter Fighter 1 name:");
                String name = sc.nextLine();
                System.out.println("Choose type (1-Boxer, 2-Karate, 3-MMA):");
                int type = sc.nextInt();
                System.out.println("Strength:");
                int strength = sc.nextInt();
                System.out.println("Stamina:");
                int stamina = sc.nextInt();
                sc.nextLine();
                Fighter f;
                if (type == 1)
                        f = new Boxer(name, strength, stamina);
                else if (type == 2)
                        f = new Karate(name, strength, stamina);
                else
                        f = new MMAFighter(name, strength, stamina);
                System.out.println("\nEnter Fighter 2 name:");
                String name2 = sc.nextLine();
                System.out.println("Choose type (1-Boxer, 2-Karate, 3-MMA):");
                int type2 = sc.nextInt();
                System.out.println("Strength:");
                int strength2 = sc.nextInt();
                System.out.println("Stamina:");
                int stamina2 = sc.nextInt();
                Fighter f2;
                if (type2 == 1)
                        f2 = new Boxer(name2, strength2, stamina2);
                else if (type2 == 2)
                        f2 = new Karate(name2, strength2, stamina2);
                else
                        f2 = new MMAFighter(name2, strength2, stamina2);
                System.out.println("\nStart fight");
                f.attack(f2);
                f2.attack(f);
                ((Bleeding) f).BleedingDamage();
                ((Bleeding) f2).BleedingDamage();
                System.out.println("\nStatus");
                f.showStatus();
                f2.showStatus();
                if (f.isKnockedOut() && !f2.isKnockedOut()) {
                        System.out.println(f.getName() + " is knocked out");
                        System.out.println(f2.getName() + "is the champion");
                } else if (f2.isKnockedOut() && !f.isKnockedOut()) {
                        System.out.println(f2.getName() + " is knocked out");
                        System.out.println(f.getName() + "is the champion");
                } else if (f.isKnockedOut() && f2.isKnockedOut()) {
                        System.out.println("No winner!Double knockout");
                } else {
                        if (f.getStamina() > f2.getStamina()) {
                                System.out.println(f.getName() + "is the champion,more stamina");
                        } else if (f2.getStamina() > f.getStamina()) {
                                System.out.println(f2.getName() + " is the champion,more stamina");
                        } else {
                                System.out.println("Draw! Equal stamina");
                        }
                }
                sc.close();
        }
}