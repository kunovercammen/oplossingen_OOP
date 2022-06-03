package domain_herhalingstest;

import java.util.Objects;

public abstract class Kunstwerk {
    private final String uitvoerder, titel;
    private boolean isVerkocht;

    public Kunstwerk(String titel, String uitvoerder) {
        if(uitvoerder == null || uitvoerder.isBlank()) throw new DomainException();
        if(titel == null || titel.isBlank()) throw new DomainException();

        this.uitvoerder = uitvoerder;
        this.titel = titel;
        this.isVerkocht = false;
    }

    public String getUitvoerder() {
        return uitvoerder;
    }

    public boolean isVerkocht() {
        if(this instanceof Verkoopbaar) return isVerkocht;
        else return false;
    }

    public double setIsVerkocht() {
        if(!(this instanceof Verkoopbaar)) throw new DomainException();
        if(this.isVerkocht) throw new DomainException();
        this.isVerkocht = true;
        return ((Verkoopbaar)this).getPrijs();
    }

    public abstract boolean isUitleenbaar();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kunstwerk kunstwerk = (Kunstwerk) o;
        return Objects.equals(uitvoerder, kunstwerk.uitvoerder) && Objects.equals(titel, kunstwerk.titel);
    }

    @Override
    public String toString() {
        String s = this.getClass() + "\nUitvoerder: " + uitvoerder + "\nTitel: " + titel;
        if(!(this instanceof Verkoopbaar)) {
            s += "\nNIET VERKOOPBAAR";
        } else {
            if(this.isVerkocht) {
                s += "\nVERKOCHT";
            } else {
                s += "\nNIET VERKOCHT";
            }
        }
        return s;
    }
}
