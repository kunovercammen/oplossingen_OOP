package domain_herhalingstest;

import java.util.ArrayList;

public class Galerij {
    private String naam;
    private ArrayList<Kunstwerk> kunstwerken;

    public Galerij(String naam) {
        if(naam == null || naam.isBlank()) throw new DomainException();

        this.naam = naam;
        this.kunstwerken = new ArrayList<>();
    }

    public void voegKunstwerkToe(Kunstwerk kunstwerk) {
        if(kunstwerk == null) throw new DomainException();
        for (Kunstwerk k: kunstwerken) {
            if (k.equals(kunstwerk)) {
                throw new DomainException();
            }
        }
        kunstwerken.add(kunstwerk);
    }

    public ArrayList<Kunstwerk> geefUitleenbareKunstwerken() {
        ArrayList<Kunstwerk> kunstwerkenUitleenbaar = new ArrayList<>();
        for (Kunstwerk k: kunstwerken) {
            if (k.isUitleenbaar()) {
                kunstwerkenUitleenbaar.add(k);
            }
        }
        return kunstwerkenUitleenbaar;
    }

    public ArrayList<Kunstwerk> geefVerkoopbareKunstwerkenMetBepaaldePrijs(double maxPrijs) {
        ArrayList<Kunstwerk> kunstwerkenVerkoopBaarNietVerkocht = new ArrayList<>();

        for (Kunstwerk k: kunstwerken) {
            if (k instanceof Verkoopbaar) {
                if (!(k.isVerkocht())) {
                    if(((Verkoopbaar) k).getPrijs() < maxPrijs) {
                        kunstwerkenVerkoopBaarNietVerkocht.add(k);
                    }
                }
            }
        }
        return kunstwerkenVerkoopBaarNietVerkocht;
    }

    public ArrayList<Kunstwerk> verwijderOpBasisVanUitvoerder(String uitvoerder) {
        ArrayList<Kunstwerk> kunstwerkenVanUitvoerder = new ArrayList<>();
        for (Kunstwerk k: kunstwerken) {
            if (k.getUitvoerder().equalsIgnoreCase(uitvoerder)) {
                kunstwerkenVanUitvoerder.add(k);
                kunstwerken.remove(k);
            }
        }
        return kunstwerkenVanUitvoerder;
    }
}
