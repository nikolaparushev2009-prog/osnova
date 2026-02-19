package combat.sports;
public  class MMAFighter extends Fighter implements Recovery, Skill, CounterAttack, Bleeding {
    private boolean isBleeding = true;
    public MMAFighter(String name, int strength, int stamina) {
        super(name, strength, stamina);
        System.out.println(name + " enters the arena as an MMA Fighter!");
    }
    public void attack(Fighter opponent) {
        int damage = strength + skillBonus() + 3;
        opponent.stamina -= damage;
        fatigue += 12;
        System.out.println(name + " performs a brutal MMA combination");
        System.out.println(opponent.name + " loses " + damage + " stamina.");
    }
    public void counterAttack(Fighter opponent) {
        int damage = (strength + skillBonus()) / 2 + 5;
        opponent.stamina -= damage;
        System.out.println(name + " performs a deadly MMA counter");
    }
    public void criticalHit(Fighter opponent) {
        if (Math.random() <= 0.25) {
            opponent.stamina = 0;
            System.out.println("Critical MMA finish");
        }
    }
    public void rest() {
        fatigue -= 12;
        if (fatigue < 0) fatigue = 0;
        System.out.println(name + " rests and recovers");
    }
    public void recover() {
        stamina += 18;
        System.out.println(name + " recovers stamina");
    }
    public int skillBonus() {
        return 8;
    }
    public void showStyle() {
        System.out.println("MMA Style: Mixed striking and grappling.");
    }
    public void Bleedings() {
        if (isBleeding) {
            int loss = (int) (stamina * 0.10);
            stamina -= loss;
            System.out.println(name + " is bleeding" + loss + " stamina.");
        }
    }

    @Override
    public void BleedingDamage() {
    }
}
