package domain_herhalingstest;

public class Foto extends Kunstwerk implements Verkoopbaar {
    private boolean isZW;
    private static final double PRIJS_ZW = 100;
    private static final double PRIJS_KLEUR = 200;


    public Foto(String titel, String uitvoerder, boolean isZW) {
        super(titel, uitvoerder);
        this.isZW = isZW;
    }

    @Override
    public boolean isUitleenbaar() {
        return false;
    }

    @Override
    public double getPrijs() {
        if(this.isZW) return PRIJS_ZW;
        else return PRIJS_KLEUR;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
