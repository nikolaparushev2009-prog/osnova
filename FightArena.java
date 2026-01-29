package koko;

public class FightArena {
    public static void fight(Fighter a, Fighter b) {
        int round = 1;
        System.out.println("\n " + a.name + " VS " + b.name + " ");
        while (a.isAlive() && b.isAlive()) {
            System.out.println("\n--- Рунд " + round + " ---");
            a.attack(b);
            if (!b.isAlive()) break;
            if (round % 4 == 0 && a instanceof Skill sa)
                sa.specialMove(b);
            b.attack(a);
            if (!a.isAlive()) break;
            if (round % 4 == 0 && b instanceof Skill sb)
                sb.specialMove(a);
            if (round % 3 == 0) {
                if (a instanceof Recovery ra) ra.recover();
                if (b instanceof Recovery rb) rb.recover();
            }
            a.status();
            b.status();
            round++;
        }
        System.out.println("\n Победител: " + (a.isAlive() ? a.name : b.name));
    }
}