package metier;


import java.text.DecimalFormat;

public class CreditMetier {

    public double calculMensualite(double c, int duree,double taux) {
        double t=taux/100;
        double t1=c*t/12;
        double t2= 1- Math.pow((1+t/12),-1*duree);
        double mensualiteBrute= t1/t2;

        //gerder seulement deux chiffres après la vergule
        DecimalFormat df = new DecimalFormat("0.00");
        double mensualite = Double.parseDouble(df.format(mensualiteBrute));
        return mensualite;
    }



}
