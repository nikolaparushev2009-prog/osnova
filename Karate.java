package koko;
public abstract class Karate extends Fighter implements Recovery, Skill {
    private boolean focused;
    public Karate(String name) {
        super(name, 110, 120, 22, 8);
        this.focused = false;
    }
    public void attack(Fighter opponent) {
        System.out.println("\n " + name + " ataka");

        if (stamina < 20) {
            System.out.println(" Недостатъчна стамина");
            return;
        }
        if (!nutrition.hasEnergy(150)) {
            System.out.println("Липса на калории");
            return;
        }
        stamina -= 20;
        nutrition.burnCalories(150);
        int damage = power;
        if (focused) {
            damage += 15;
            focused = false;
            System.out.println(" ФОКУСИРАН УДАР!");
        }
        if (health < 40) {
            damage += 5;
            System.out.println(" Боен дух!");
        }
        opponent.takeDamage(damage);
        fatigue();
    }
    @Override
    public void specialMove(Fighter opponent) {

        System.out.println("\n " + name + " използва специален ход");

        if (stamina < 40 || !nutrition.hasEnergy(300)) {
            System.out.println(" Недостатъчни ресурси!");
            return;
        }

        stamina -= 40;
        nutrition.burnCalories(300);

        System.out.println(" ВЪРТЯЩ РИТНИК!");
        opponent.takeDamage(power + 25);
    }
    public void recover() {
        System.out.println("\n " + name + " медитира");
        if (!focused && stamina > 50) {
            focused = true;
            System.out.println(" Концентрация - следващ удар по-силен");
        }
        if (!nutrition.hasEnergy(400)) {
            nutrition.eat();
        }
        stamina += 25;
        if (stamina > 120) stamina = 120;
    }
}
