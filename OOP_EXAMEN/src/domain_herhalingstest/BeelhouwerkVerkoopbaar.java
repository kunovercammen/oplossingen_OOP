package domain_herhalingstest;

public class BeelhouwerkVerkoopbaar extends Beeldhouwerk implements Verkoopbaar{
    private double waarde;

    public BeelhouwerkVerkoopbaar(String titel, String uitvoerder, int gewicht, String materiaal, double waarde) {
        super(titel, uitvoerder, gewicht, materiaal);
        if(waarde <= 0) throw new DomainException();
        this.waarde = waarde;
    }


    @Override
    public double getPrijs() {
        return waarde*1.15;
    }

    @Override
    public String toString() {
        return super.toString() + "\nWaarde: " + waarde;
    }
}
