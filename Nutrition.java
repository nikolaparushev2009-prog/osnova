package combat.sports;
public class Nutrition {
    public void eat(String food, Fighter fighter) {
        switch (food.toLowerCase()) {
            case "meat":
                fighter.stamina += 30;
                System.out.println("+ 30 stamina");
                break;
            case "salad":
                fighter.stamina += 15;
                System.out.println("+15 stamina");
                break;
            case "junk":
                fighter.fatigue += 20;
                System.out.println("+20 fats");
                break;
            default:
                System.out.println("Other food");
        }
    }

}
