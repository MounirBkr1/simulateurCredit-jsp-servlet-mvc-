package metier;

public class testMetier {

    public static void main(String[] args) {
        CreditMetier metier = new CreditMetier();
        double m= metier.calculMensualite(200000,240,4.5);
        System.out.println(m);
    }

}
