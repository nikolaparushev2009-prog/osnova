package combat.sports;
public class Karate extends Fighter implements Recovery, Skill, CounterAttack, Bleeding {
    public Karate(String name, int strength, int stamina) {
        super(name, strength, stamina);
    }
    public void attack(Fighter opponent) {
        int damage = strength + skillBonus();
        opponent.stamina -= damage;
        fatigue += 8;
        System.out.println(name + " performs a karate kick!");
        System.out.println(opponent.name + " loses " + damage + " stamina.");
    }
    public void counterAttack(Fighter opponent) {
        int damage = (strength + skillBonus()) / 2 + 3;
        opponent.stamina -= damage;
        System.out.println(name + " performs a lighthning counter kick!");
        System.out.println(opponent.name + " loses " + damage + " stamina from counterattack.");
    }
    public void criticalHit(Fighter opponent) {
        double chance = Math.random();
        if (chance <= 0.2) {
            opponent.stamina = 0;
            System.out.println(" Critical hit");
            System.out.println(name + " delivers a devastating knockout kick");
        } else {
            System.out.println(name + " tried a critical hit but failed!");
        }
    }
    public void BleedingDamage() {
        boolean isBleeding = true;
        int loss = (int) (stamina * 0.07); // 7% загуба
        stamina -= loss;
        System.out.println(name + " is bleeding! -" + loss + " stamina.");
    }
    public void rest() {
        fatigue -= 10;
        if (fatigue < 0) fatigue = 0;
        System.out.println(name + "Reduces fatigue.");
    }
    public void recover() {
        stamina += 15;
        System.out.println(name + " recovers stamina.");
    }
    public int skillBonus() {
        return 7;
    }
    public void showStyle() {
        System.out.println("Karate Style ");
    }
}