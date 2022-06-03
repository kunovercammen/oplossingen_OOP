package domain_week2;

public class Schilderij extends Eigendom {
    private String titel, maker;


    public Schilderij(Euro prijs, String titel, String maker) {
        super(prijs);
        this.titel = titel;
        this.maker = maker;
    }

    public String getTitel() {
        return titel;
    }

    public String getMaker() {
        return maker;
    }

}
