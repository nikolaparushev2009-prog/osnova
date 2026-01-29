package koko;
import java.util.Random;
public abstract class Fighter {
 protected String name;
    protected int health;
    protected int stamina;
    protected int power;
    protected int defense;
    protected Nutrition nutrition;
    protected Random random = new Random();
    public Fighter(String name, int health, int stamina, int power, int defense) {
        this.name = name;
        this.health = health;
        this.stamina = stamina;
        this.power = power;
        this.defense = defense;
        this.nutrition = new Nutrition();
    }
    public abstract void attack(Fighter opponent);
    protected boolean criticalHit() {
        return random.nextInt(100) < 20;
    }
    public void takeDamage(int damage) {
        int realDamage = damage - defense;
        if (realDamage < 0) realDamage = 0;
        health -= realDamage;
        if (health < 0) health = 0;
        System.out.println(name + " получи " + realDamage + " щети | HP: " + health);
    }
    public void fatigue() {
        stamina -= 5;
        if (stamina < 0) stamina = 0;
    }
    public boolean isAlive() {
        return health > 0;
    }
    public void status()
    //pokazva tekushto sustioanie
     {
        System.out.println(name +"HP" + health +" stamina " + stamina +"calories " + nutrition.getCalories());
    }
}