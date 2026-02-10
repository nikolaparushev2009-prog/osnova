package koko;
public abstract class Boxer extends Fighter implements Recovery {
    public Boxer(String name) {
        super(name, 130, 100, 28, 5);
    }
    
    public void attack(Fighter opponent) {
        System.out.println("\n" + name + " атакува (Бокс)");
        if (stamina < 15) {
            System.out.println(" Няма достатъчно стамина!");
            return;
        }
        if (!nutrition.hasEnergy(200)) {
            System.out.println(" Няма достатъчно калории!");
            return;
        }
        stamina -= 15;
        nutrition.burnCalories(200);
        int damage = power;
        if (stamina > 70 && nutrition.getCalories() > 1000) {
            damage += 10;
            System.out.println(" Пълен със енергия =силен удар");
        } else if (stamina < 30) {
            damage -= 8;
            System.out.println(" Уморен =слаб удар");
        }
        if (criticalHit()) {
            damage *= 2;
            System.out.println(" КРИТИЧЕН УДАР!");
        }
        opponent.takeDamage(damage);
        fatigue();
    }

    public void recover() {
        System.out.println("\n " + name + "  възстановява леко");
        if (!nutrition.hasEnergy(500)) {
            nutrition.eat();
        }
        if (stamina < 40) {
            stamina += 30;
            System.out.println(" Дълбоко дишане ");
        } else {
            stamina += 15;
            System.out.println(" Леко възстановяване");
        }
        if (stamina > 100) stamina = 100;
    }
}
