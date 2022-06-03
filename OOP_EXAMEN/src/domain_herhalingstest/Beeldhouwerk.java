package domain_herhalingstest;

public class Beeldhouwerk extends Kunstwerk{
    private final int gewicht;
    private final String materiaal;

    public Beeldhouwerk(String titel, String uitvoerder, int gewicht, String materiaal) {
        super(titel, uitvoerder);
        if(gewicht <= 0) throw new DomainException();
        if(materiaal == null || materiaal.isBlank()) throw new DomainException();

        this.gewicht = gewicht;
        this.materiaal = materiaal;
    }

    @Override
    public boolean isUitleenbaar() {
        if(!this.isVerkocht() || gewicht < 15) return true;
        else return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMateriaal: " + materiaal + "\nGewicht: " + gewicht;
    }
}
