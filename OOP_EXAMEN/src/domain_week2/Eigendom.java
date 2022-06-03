package domain_week2;

public class Eigendom {
    private Euro prijs;

    public Eigendom(Euro prijs) {
        this.prijs = prijs;
    }

    public Euro getPrijs() {
        return this.prijs;
    }

    public String toString() {
        String s = this.prijs.geefInfoAlsString();
        return s;
    }
}
