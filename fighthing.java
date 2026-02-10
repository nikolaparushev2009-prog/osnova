package koko;
public class fighthing {
     public static void fight(Fighter a, Fighter b) {
        int round = 1;
        System.out.println("\n Начало");
        System.out.println(a.name + " VS " + b.name);
        while (a.isAlive() && b.isAlive()) {
            System.out.println("\n--- Рунд " + round + " ---");
            a.attack(b);
            if (!b.isAlive()) break;
            b.attack(a);
            if (!a.isAlive()) break;
            if (round % 2 == 0) {
                if (a instanceof Recovery ra) {
                    System.out.println(a.name + " опитва да възстанови");
                    ra.recover();
                }
                if (b instanceof Recovery rb) {
                    System.out.println(b.name + " опитва да възстанови");
                    rb.recover();
                }
            if (round % 3 == 0) {
                if (a instanceof Recovery ra) {
                    System.out.println(a.name + " опитва да възстанови");
                    ra.recover();
                }
                if (b instanceof Recovery rb) {
                    System.out.println(b.name + " опитва да възстанови");
                    rb.recover();
                }
            }
            if (round % 4 == 0) {
                if (a instanceof Skill sa) {
                    System.out.println(a.name + " използва специален ход");
                    sa.specialMove(b);
                }
                if (b instanceof Skill sb) {
                    System.out.println(b.name + " използва специален ход");
                    sb.specialMove(a);
                }
            }
            System.out.println("\n Състояние след рунда:");
            a.status();
            b.status();
            round++;
        }
        System.out.println("\n End of the fight");
        if (a.isAlive()) {
            System.out.println("Победител: " + a.name);
        } else {
            System.out.println("Победител: " + b.name);
        }
    }
     }
    }
