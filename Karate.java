public class Karate extends proekt_1 {
    private String nivo; 

    public Karate(int produlzhenie_minuti, int intenzitet_trenirovka, String nivo) {
      //  super(produlzhenie_minuti, intenzitet_trenirovka);
        this.nivo = nivo;
    }

    public void Informacia(){
        System.out.println("Karate trenirovka");
        super.Informacia();
        System.out.println("Nivo: " + nivo);
    }

    public double Calorii(double weight){
        double koeficient;

        if(nivo.equals("nachinaesht")){
            koeficient = 0.10;
        } else if(nivo.equals("sredno")){
            koeficient = 0.13;
        } else {
            koeficient = 0.16;
        }

        return produlzhenie_minuti * intenzitet_trenirovka * koeficient * weight;
    }
}


