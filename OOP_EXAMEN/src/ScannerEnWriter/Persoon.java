package ScannerEnWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Persoon implements Comparable<Persoon> {
    private final String voornaam, naam;
    private final LocalDate geboortedatum;

    public Persoon(String voornaam, String naam, LocalDate geboortedatum) {
        if (voornaam == null || voornaam.trim().isEmpty())
            throw new DomainException("De voornaam van een persoon mag niet leeg zijn");
        if (naam == null || naam.trim().isEmpty())
            throw new DomainException("De naam van een persoon mag niet leeg zijn");
        if (geboortedatum == null) throw new DomainException("De geboortedatum van een persoon mag niet leeg zijn");
        this.voornaam = voornaam;
        this.naam = naam;
        this.geboortedatum = geboortedatum;
    }

    public String getVoornaam() {
        return this.voornaam;
    }

    public String getNaam() {
        return naam;
    }

    public int getLeeftijd() {
        int jaar = LocalDate.now().getYear() - this.geboortedatum.getYear();
        LocalDate verjaardag = LocalDate.of(LocalDate.now().getYear(), this.geboortedatum.getMonth(), this.geboortedatum.getDayOfMonth());
        if (verjaardag.isAfter(LocalDate.now())) jaar--;
        return jaar;
    }

    @Override

    public int compareTo(Persoon o) {
        if (o == null) return -1;
        else {
            int i = this.getLeeftijd() - o.getLeeftijd();
            if (i != 0) return i;
            else {
                i = this.naam.compareTo(o.naam);
                if (i != 0) return i;
                else
                    return this.voornaam.compareTo(o.voornaam);
            }
        }
    }

    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoon persoon = (Persoon) o;
        return voornaam.equals(persoon.voornaam) && naam.equals(persoon.naam) &&
                geboortedatum.equals(persoon.geboortedatum);
    }

    @Override
    public String toString() {
        return "Persoon{" + "voornaam='" + voornaam + '\'' + ", naam='" + naam + '\'' +
                ", geboortedatum=" + geboortedatum + '}';
    }

    private static ArrayList<Persoon> leesGegevensIn(String fileNaam) {
        ArrayList<Persoon> personen = new ArrayList<>();
        File personenFile = new File(fileNaam);
        try {
            Scanner scannerFile = new Scanner(personenFile);
            while (scannerFile.hasNextLine()) {
                String s = scannerFile.nextLine();
                String[] delen = s.split(";");
                int geboortejaar = Integer.parseInt(delen[2]);
                int geboortemaand = Integer.parseInt(delen[3]);
                int geboortedag = Integer.parseInt(delen[4]);
                Persoon persoon = new Persoon(delen[0], delen[1], LocalDate.of(geboortejaar, geboortemaand, geboortedag));
                personen.add(persoon);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("fout bij inlezen");
        } catch
        (NumberFormatException e) {
            System.out.println("data niet numeriek");
        }
        return personen;
    }

    private static void schrijfGegevensUit(ArrayList<Persoon> personen, String fileNaam) {
        File resultaatFile = new File(fileNaam);
        try {
            PrintWriter writer = new PrintWriter(resultaatFile);
            for (Persoon p : personen) {
                System.out.println(p);
                writer.print(p.getVoornaam());
                writer.print(";");
                writer.print(p.getNaam());
                writer.print(";");
                writer.println(p.getLeeftijd());
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fout bij het wegschrijven");
        }
    }


}


