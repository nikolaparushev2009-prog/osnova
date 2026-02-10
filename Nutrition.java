package koko;
public class Nutrition {
    private int calories;
    public Nutrition(int calories) {
        this.calories=calories;
    }
    public int getCalories() {
        return calories;
    }
    public void burnCalories(int amount) {
        calories -= amount;
        if (calories < 0) calories = 0;
    }
    //zsshtita ot nezhelani stoinosti 
    public void eat() {
        if (calories < 300) {
            calories += 800;
            System.out.println("Тежко хранене до 800 калории");
        } 
        else if (calories>=300 && calories<800) {
            calories += 500;
            System.out.println("Леко хранене д0 500 калории");
        } else {
            calories += 200;
            System.out.println("Лека закуска до 200 калории");
        }
    }
//proveriava za fighter dali imash dostatuchno kalorii
    public boolean hasEnergy(int needed) {
        return calories >= needed;
    }
}
