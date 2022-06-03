package domain_week2;

import java.util.ArrayList;

public class Persoon {
    private ArrayList<Eigendom> eigendommen;

    public Persoon() {
        this.eigendommen = new ArrayList<>();
    }

    public void voegEigendomToe(Eigendom e) {
        this.eigendommen.add(e);
    }

    public Euro getTotaleWaarde() {
        Euro res = new Euro(0,0);
        for (Eigendom e: eigendommen) {
            res = res.som(e.getPrijs());
        }
        return res;
    }

    public int totaleHondenBrokken(int aantalDagen) {
        int res = 0;
        for (Eigendom e: eigendommen) {
            if (e instanceof Hond) {
                res += ((Hond) e).brokkenVoorAantalDagen(aantalDagen);
            }
        }
        return res;
    }

    public String toString(int dagen) {
        String s = "";
        for(Eigendom e:eigendommen) {
            s += "\nDe prijs van deze/dit " + e.getClass().getSimpleName() + " is "  + e.toString();
        }
        s += "\nDe totale waarde van alle eigendommen is " + this.getTotaleWaarde().geefInfoAlsString();
        s += "\nHet totale aantal hondenbrokken dat u nodig heeft is " + this.totaleHondenBrokken(dagen);
        return s;
    }
}
