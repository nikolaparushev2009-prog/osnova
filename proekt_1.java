public class proekt_1 {
    protected int produlzhenie_minuti;
    protected int intenzitet_trenirovka;
    public void Trainiing(int produlzhenie_minuti,int intenzitet_trenirovka){
        if(produlzhenie_minuti<=0 || intenzitet_trenirovka<=0){
            throw new IllegalArgumentException();
        }
        this.produlzhenie_minuti=produlzhenie_minuti;
        this.intenzitet_trenirovka=intenzitet_trenirovka;
    }
    public void Informacia(){
        System.out.println("Trenirovka");
        System.out.println("Produzlhenieto e"+produlzhenie_minuti+"minuti");
        System.out.println("Intensitetut e "+intenzitet_trenirovka);
    }
    public void Calorii(int height,double weight,String pol,int minuti){
        double calories=0;
        if (pol.equals("мъж") && weight <= 60 && height <= 170) {
            calories = 1800;
        } else if (pol.equals("мъж") && weight<= 60 && height> 170) {
            calories = 1900;
        } else if (pol.equals("мъж") && weight > 60 && weight <= 80 && height <= 170) {
            calories = 2000;
        } else if (pol.equals("мъж") && weight > 60 && weight <= 80 && height> 170) {
            calories = 2100;
        } else if (pol.equals("мъж") && weight > 80) {
            calories = 2300;
        }
        else if (pol.equals("жена") && weight <= 50 && height <= 160) {
            calories = 1500;
        } else if (pol.equals("жена") && weight<= 50 && height > 160) {
            calories = 1600;
        } else if (pol.equals("жена") && weight> 50 && weight <= 70 && height<= 160) {
            calories = 1700;
        } else if (pol.equals("жена") && weight> 50 && weight <= 70 && height > 160) {
            calories = 1800;
        } else if (pol.equals("жена") && weight> 70) {
            calories = 2000;
        }

        else {
            System.out.println("Непознат пол или стойности, не мога да изчисля калории.");
            return;
        }    
    }
}
