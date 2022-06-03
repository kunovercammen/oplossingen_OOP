package domain_herhalingstest;

public class Schilderij extends Kunstwerk implements Verkoopbaar{
    private final double breedte;
    private final double hoogte;
    private double waarde;


    public Schilderij(String titel, String uitvoerder, double breedte, double hoogte, double waarde) {
        super(titel, uitvoerder);
        if(breedte <= 0 || hoogte <= 0) throw new DomainException();

        this.breedte = breedte;
        this.hoogte = hoogte;
        setWaarde(waarde);
    }

    public void setWaarde(double waarde) {
        if(waarde <= 0) throw new DomainException();
        this.waarde = waarde;
    }

    @Override
    public boolean isUitleenbaar() {
        if (!(this.isVerkocht()) && hoogte < 150 && breedte < 150) return true;
        else return false;
    }

    @Override
    public double getPrijs() {
        return waarde*1.10;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public double getWaarde() {
        return this.waarde;
    }
}
