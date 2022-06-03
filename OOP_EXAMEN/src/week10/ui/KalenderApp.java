package week10.ui;

import week10.domain.Persoon;
import week10.domain.VerjaardagsKalender;
import java.time.LocalDate;

public class KalenderApp {

	public static void main(String[] args) {
		VerjaardagsKalender kalender = new VerjaardagsKalender();
		Persoon tim = new Persoon("Frederiks","Tim",LocalDate.of(2011,12,1));
		Persoon tom = new Persoon("Adams","Tom",LocalDate.of(1999,12,12));
		Persoon ann = new Persoon("Alders","Ann",LocalDate.of(2014,4,1));
		Persoon jef = new Persoon("Jackers","Jef",LocalDate.of(2012,12,1));
		Persoon anne = new Persoon("Van anders","Anne",LocalDate.of(1987,11,1));
		
		kalender.voegVerjaardagToe(ann);
		kalender.voegVerjaardagToe(jef);
		kalender.voegVerjaardagToe(tom);
		kalender.voegVerjaardagToe(tim);
		kalender.voegVerjaardagToe(anne);

		System.out.println(kalender);
		System.out.println("________________________________");

		kalender.verwijderPersoon(jef);
		System.out.println("Jef uit kalender");
		System.out.println(kalender);
		System.out.println("________________________________");

		System.out.println("Tim uit kalender");
		kalender.verwijderPersoon(tim);
		System.out.println(kalender);
	}

}
