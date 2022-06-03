package domain_week2;

/**
 * De klasse Euro stelt een bedrag in euro voor.
 * Je kan een Euro-object maken op basis van het aantal euro en het aantal eurocenten.
 * Je kan bij een bedrag een bedrag optellen, dit resulteert in een nieuw bedrag.
 * Je kan een bedrag verminderen met een ander bedrag, dit resulteert in een nieuw bedrag.
 * Je kan een bedrag vermenigvuldigen met een gegeven aantal, dit resulteert in een nieuw bedrag.
 * Je kan een bedrag delen door een gegeven aantal. Dit resulteert in een nieuw bedrag.
 * Je kan nagaan of een bedrag het zelfde is als een ander gegegeven bedrag.
 * Je kan een bedrag omzetten naar een sting vorm bijvoorbeeld "15€ en 50 eurocent".
 */
public class Euro {
    private int totaalEurocenten;

    /**
     * Maakt een Euro-object op basis van een gegeven aantal dat het aantal euro voorstelt en een gegeven aantal dat de eurocenten voorstelt
     * @param euro gegeven aantal euro
     * @param eurocent gegeven aantal eurocent
     */
    public Euro(int euro, int eurocent){
        this.totaalEurocenten = euro * 100 + eurocent;
    }

    /**
     * berekent de som van dit euro-object met een gegeven euro-object
     * @param bedrag het gegeven euro-object
     * @return de som van dit euro-object met het gegeven euro-object
     * @throws IllegalArgumentException als het gegeven euro-object null is
     */
    public Euro som(Euro bedrag){
        if (bedrag == null) throw new IllegalArgumentException();
        int totaal = this.totaalEurocenten + bedrag.totaalEurocenten;

        return new Euro(0,totaal);
    }

    /**

     * berekent het verschil van dit euro-object en een gegeven euro-object
     * @param bedrag het gegeven euro-object
     * @return het verschil van dit euro-object en het gegeven euro-object
     * @throws IllegalArgumentException als het gegeven euro-object null is
     */
    public Euro verschil(Euro bedrag){
        if (bedrag == null) throw new IllegalArgumentException();
        int totaal = this.totaalEurocenten - bedrag.totaalEurocenten;
        return new Euro(0,totaal);
    }

    /**
     * berekent het produkt van dit euro-object met een gegeven aantal
     * @param aantal gegeven aantal
     * @return nieuw euro-object dat produkt is van dit euro-object en gegeven aantal
     */
    public Euro produkt(int aantal){
        return new Euro(0,aantal * this.totaalEurocenten);
    }
    /**
     * berekent de deling van dit euro-object met een gegeven aantal
     * @param aantal gegeven aantal
     * @return nieuw euro-object dat deling is van dit euro-object met gegeven aantal
     */
    public Euro deling(int aantal){
        return new Euro(0,this.totaalEurocenten/aantal);
    }

    /**
     * geeft true terug indien dit euro-object overeenkomt met 0€ en 0 eurocent
     * @return true indien dit euro-object overeenkomt met 0€ en 0 eurocent, false anders
     */
    public boolean isNul(){
        return this.totaalEurocenten == 0;
    }

    /**
     * geeft true terug indien dit euro-object een positieve waarde heeft
     * @return true indien dit euro-object een positieve waarde heeft, false anders
     */
    public boolean isPositief(){
        return this.totaalEurocenten > 0;
    }
    /**
     * geeft true terug indien dit euro-object een negatieve waarde heeft
     * @return true indien dit euro-object een negatieve waarde heeft, false anders
     */
    public boolean isNegatief(){
        return this.totaalEurocenten < 0;
    }
    /**
     * geeft true terug indien dit euro-object dezelfde waarde heeft als het gegeven euro-object
     * @param anderBedrag gegeven euro-object
     * @return true indien dit euro-object dezelfde waarde heeft als het gegeven euro-object, false anders
     */
    public boolean isZelfde(Euro anderBedrag){
        if (anderBedrag == null) return false;
        return this.totaalEurocenten == anderBedrag.totaalEurocenten;
    }

    /**
     * Geeft String vorm terug van dit euro-object bijvoorbeeld 12€ en 15 eurocent
     * @return String vorm van dit euro-object bijvoorbeeld 12€ en 15 eurocent
     */

    public String geefInfoAlsString(){
        return this.totaalEurocenten/100 + "€ en " +  this.totaalEurocenten%100 + "eurocent";
    }
}
