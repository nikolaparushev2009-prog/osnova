public class BoxTraining extends proekt_1 {
    private int broiRundove;
    public void Box( int produlzhenie_minuti,  int intenzitet_trenirovka,  int broiRundove) {
       // super(produlzhenie_minuti, intenzitet_trenirovka);
        this.broiRundove = broiRundove;
    }
    public void Informacia(){
        System.out.println("Boksova trenirovka");
        super.Informacia();
        System.out.println("Broy rundove: " + broiRundove);
    }
    public double Calorii(double weight){
        double calories;
        calories = produlzhenie_minuti * intenzitet_trenirovka * broiRundove * 0.15 * weight;
        return calories;
    }
}
