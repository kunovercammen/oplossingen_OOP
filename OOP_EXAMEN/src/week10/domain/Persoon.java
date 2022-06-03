package week10.domain;

import SETenMAP_opdracht2.domain.Contact;

import java.time.LocalDate;
import java.util.Objects;

public class Persoon implements Comparable {
	private String naam, voornaam;
	private LocalDate geboorteDatum;
	
	public Persoon(String naam, String voornaam, LocalDate geboorteDatum) {
		if (naam == null || voornaam == null || geboorteDatum == null){
			throw new IllegalArgumentException();
		}
		this.naam = naam;
		this.voornaam = voornaam;
		this.geboorteDatum = geboorteDatum;
	}

	public String getNaam() {
		return naam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public LocalDate getGeboorteDatum() {
		return geboorteDatum;
	}
	
	
	public String toString(){
		return this.naam + " "   + this.voornaam + " " + this.geboorteDatum.getDayOfMonth()+"-"+this.geboorteDatum.getMonthValue()+"-"+this.geboorteDatum.getYear();
	}
	
	//TO DO vul de ontbrekende methodes aan
	// tip - personen zullen in volgorde van leeftijd worden bijgehouden in een TreeSet
	// ontbrekende methodes mogen gegenereerd worden in IntelliJ -> code->generate


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Persoon persoon = (Persoon) o;
		return naam.equals(persoon.naam) && voornaam.equals(persoon.voornaam) && geboorteDatum.equals(persoon.geboorteDatum);
	}

	@Override
	public int hashCode() {
		return Objects.hash(naam, voornaam, geboorteDatum);
	}

	@Override
	public int compareTo(Object o) {
		if(o == null) return 1;
		Persoon persoon = (Persoon) o;
		int terug = this.getGeboorteDatum().compareTo(persoon.getGeboorteDatum());
		if (terug == 0) this.naam.compareTo(persoon.getNaam());
		if(terug == 0) this.getVoornaam().compareTo(persoon.getVoornaam());
		return terug;
	}

}
