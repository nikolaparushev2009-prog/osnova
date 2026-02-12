package koko;
public  class Karate extends Fighter implements Recovery, Skill, CounterAttack {
    public Karate(String name, int strength, int stamina) {
        super(name, strength, stamina);
    }
    public void attack(Fighter opponent) {
        int damage = strength + skillBonus();
        opponent.stamina -= damage;
        fatigue += 8;
        System.out.println(name + "performs karate kick");
        System.out.println(opponent.name + "loses " + damage + "stamina");
    }
    public void counterAttack(Fighter opponent) {
        int damage = (strength + skillBonus()) / 2 + 3;
        opponent.stamina -= damage;
        System.out.println(name + "prepares a light kick");
        System.out.println(opponent.name + "loses" + damage + "stamina from counteratack");
    }
    public void criticalHit(Fighter opponent) {
        double chance = Math.random();
        //podgotvia chislo ot 0 do 1
        if (chance <= 0.2) {
            opponent.stamina = 0;
            System.out.println("Critical hit!!!!");
            System.out.println(name + "Knockout kick");
        } else {
            System.out.println(name + "Try knockout kick,but he failed!");
        }
    }
    public void rest() {
        fatigue -= 10;
        if (fatigue < 0) fatigue = 0;
        System.out.println(name + "Rest and recover");
    }
    public void recover() {
        stamina += 15;
        System.out.println(name + "Recover stamina");
    }
    @Override
    public int skillBonus() {
        return 7;
    }
    public void showStyle() {
        System.out.println("Karate style");
    }
}