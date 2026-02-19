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
    public abstract void attack(Fighter opponent);
    public void showStatus() {
        System.out.println("-----");
        System.out.println("Name: " + name);
        System.out.println("Stamina: " + stamina);
        System.out.println("Fatigue: " + fatigue);
        System.out.println("-----");
    }
    public boolean isKnockedOut() {
        return stamina <= 0;
    }
    public int getStamina() {
        return stamina;
    }
    public String getName() {
        return name;
    }
}


