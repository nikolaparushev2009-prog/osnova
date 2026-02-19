package combat.sports;
public  class Boxer extends Fighter implements Recovery, Skill, CounterAttack, Bleeding {
    private boolean isBleeding = true;

    public Boxer(String name, int strength, int stamina) {
        super(name, strength, stamina);

        if (stamina > 80) {
            System.out.println(name + " has excellent stamina!");
        } else {
            System.out.println(name + " needs conditioning!");
        }
    }
    public void attack(Fighter opponent) {
        int damage = strength + skillBonus();
        opponent.stamina -= damage;
        fatigue += 10;

        System.out.println(name + " throws a powerful punch!");
        System.out.println(opponent.name + " loses " + damage + " stamina.");
    }
    public void counterAttack(Fighter opponent) {
        int damage = (strength + skillBonus()) / 2;
        opponent.stamina -= damage;

        System.out.println(name + " performs a quick counter punch");
        System.out.println(opponent.name + " loses " + damage + " stamina from counterattack.");
    }
    public void criticalHit(Fighter opponent) {
        double chance = Math.random();

        if (chance <= 0.2) {
            opponent.stamina = 0;
            System.out.println("Critical hit");
            System.out.println(name + " delivers a devastating knockout punch");
        } else {
            System.out.println(name + " tried a critical hit but missed!");
        }
    }

    public void Bleedings() {
        if (isBleeding) {
            int loss = (int) (stamina * 0.08); // 8% загуба на рунд
            stamina -= loss;
            if (stamina < 0) stamina = 0;
            System.out.println(name + " is bleeding" + loss + " stamina.");
        }
    }
    public void rest() {
        fatigue -= 15;
        if (fatigue < 0) fatigue = 0;
        System.out.println(name + " is resting. Fatigue reduced.");
    }
    public void recover() {
        stamina += 20;
        System.out.println(name + " recovers stamina.");
    }
    public int skillBonus() {
        return 5;
    }
    public void showStyle() {
        System.out.println("Boxing style");
    }

    @Override
    public void BleedingDamage() {

    }
}
