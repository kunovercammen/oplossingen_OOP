package domain_week2;

public class Appeke {
    public static void main(String[] args) {
        Persoon kuno = new Persoon();
        Eigendom hond1 = new Hond(new Euro(10, 50), "Lasko", 100);
        Eigendom hond2 = new Hond(new Euro(10, 0), "Xena", 100);
        Eigendom hond3 = new Hond(new Euro(10, 0), "Vyas", 100);
        Eigendom schilderij1 = new Schilderij(new Euro(20,0),"Mona Lisa", "Da Vinci");
        Eigendom schilderij2 = new Schilderij(new Euro(20,0),"De Schreeuw", "Da Vinci");
        Eigendom schilderij3 = new Schilderij(new Euro(20,0),"Kaka", "Da Vinci");

        kuno.voegEigendomToe(hond1);
        kuno.voegEigendomToe(hond2);
        kuno.voegEigendomToe(hond3);
        kuno.voegEigendomToe(schilderij1);
        kuno.voegEigendomToe(schilderij2);
        kuno.voegEigendomToe(schilderij3);
        System.out.println(kuno.toString(5));




    }
}
