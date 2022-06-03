package Testen;

import java.awt.geom.Point2D;

public class Cirkel {
    private Point2D.Double middelpunt;
    private double straal;

    public Cirkel(Point2D.Double middelpunt, double straal) {
        if (straal <= 0) throw new IllegalArgumentException();
        if (middelpunt == null) throw new IllegalArgumentException();
        if (straal > Math.min(middelpunt.getX(),middelpunt.getY())) throw new IllegalArgumentException();
        this.middelpunt = middelpunt;
        this.straal = straal;
    }

    public Point2D.Double getMiddelpunt() {
        return new Point2D.Double(this.middelpunt.getX(),this.middelpunt.getY());
    }

    public double getStraal() {
        return straal;
    }

    public double oppervlakte(){
        return Math.PI * this.straal * this.straal;
    }

    public boolean ligtInCirkel(Point2D.Double punt){
        if (punt == null){
            throw new IllegalArgumentException();
        }
        double afstand = this.middelpunt.distance(punt);
        return afstand < this.straal;
    }

    public void vergrootstraal(double factor){
        if (factor <= 0) throw new IllegalArgumentException();
        double nieuweStraal = this.straal * factor;
        if (nieuweStraal > Math.min(middelpunt.getX(),middelpunt.getY())) throw new IllegalArgumentException();
        this.straal = nieuweStraal;
    }
}
