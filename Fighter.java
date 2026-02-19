package combat.sports;
public abstract class Fighter {
    protected String name;
    protected int strength;
    protected int stamina;
    protected int fatigue;
    public Fighter(String name, int strength, int stamina) {
        this.name = name;
        this.strength = strength;
        this.stamina = stamina;
        this.fatigue = 0;
    }
    public void showStatus() {
        System.out.println("Status");
        System.out.println("Name: " + name);
        System.out.println("Strength: " + strength);
        System.out.println("Stamina: " + stamina);
        System.out.println("Fatigue: " + fatigue);
    }
    public abstract void attack(Fighter opponent);
}


