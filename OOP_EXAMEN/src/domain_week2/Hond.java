package domain_week2;

public class Hond extends Eigendom{
    private String naam;
    private int aantalHondenbrokkenPerDag;


    public Hond(Euro prijs, String naam, int aantalHondenbrokkenPerDag) {
        super(prijs);
        this.naam = naam;
        this.aantalHondenbrokkenPerDag = aantalHondenbrokkenPerDag;
    }

    public String getNaam() {
        return naam;
    }

    public int getAantalHondenbrokkenPerDag() {
        return aantalHondenbrokkenPerDag;
    }

    public int brokkenVoorAantalDagen(int dagen) {
        return this.getAantalHondenbrokkenPerDag()*dagen;
    }
}
