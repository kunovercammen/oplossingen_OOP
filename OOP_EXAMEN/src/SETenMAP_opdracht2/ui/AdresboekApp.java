package SETenMAP_opdracht2.ui;

import SETenMAP_opdracht2.domain.Adresboek;
import SETenMAP_opdracht2.domain.Contact;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;



public class AdresboekApp {

	public static void main(String[] args) {
		Contact[] contactenLijst1 = {
				new Contact ("Depeel","Andi","016111111"),
				new Contact ("Depeel","Els","016111111"),
				new Contact ("Dox","Jo","016222211"),
				new Contact ("Adons","Andi","016111333"),
				new Contact ("Adons","Dirk","016111333"),
				new Contact ("Vranken","Rita","011999999"),
				new Contact ("Vangeel","Anja","011111112")
		};
		Contact [] contactenLijst2 = {
				new Contact ("Depeel","Els","016111111"),
				new Contact ("Degrijse","Jan","011224511"),
				new Contact ("Adons","Andi","016111333"),
				new Contact ("Depeel","Andi","016111111"),
				new Contact ("Adons","Robrecht","016111333"),
				new Contact ("Vranken","Rita","011999999"),
				new Contact ("Vanlo","Kris","016190111"),
				new Contact ("Dero","Eno","011111112")
		};
		Adresboek adresboek1 = new Adresboek(new LinkedHashSet<Contact>(Arrays.asList(contactenLijst1)));
		Adresboek adresboek2 = new Adresboek(new LinkedHashSet<Contact>(Arrays.asList(contactenLijst2)));
		System.out.println("Alle contacten uit adresboek 1 in volgorde van toevoeging");
		System.out.println(adresboek1);
		System.out.println("Alle contacten uit adresboek 2 in volgorde van toevoeging");
		System.out.println(adresboek2);
		System.out.println("Alle gemeenschappelijke contacten uit adresboek 1 en adresboek 2 in alfabetische volgorde achternaam/voornaam");
		System.out.println(adresboek1.gemeenschappelijkeContacten(adresboek2));
		System.out.println("Alle gezamelijke contacten uit adresboek 1 en adresboek 2 in alfabetische volgorde achternaam/voornaam");
		System.out.println(adresboek1.gezamelijkeContacten(adresboek2));
		System.out.println("Alle contacten uit adresboek 1 die niet voorkomen in adresboek 2 in alfabetische volgorde achternaam/voornaam");
		System.out.println(adresboek1.verschillendeContacten(adresboek2));
		Contact nieuwContact = new Contact ("Dox","Jo","016222211");
		System.out.println("Dox Jo"+ (adresboek1.voegToe(nieuwContact)?" toegevoegd ":" niet toegevoegd ")+"aan adresboek 1");
		nieuwContact = new Contact ("Rummens","Rani","013288338");
		System.out.println("Rummens Rani"+ (adresboek1.voegToe(nieuwContact)?" toegevoegd ":" niet toegevoegd ")+"aan adresboek 1");
		System.out.println ("Aantal verwijderde contacten met achtternaam Adons uit adresboek 1:"+adresboek1.verwijder("Adons"));
		System.out.println("Alle contacten uit adresboek 1 in volgorde van toevoeging na aanpassingen");
		System.out.println(adresboek1);
	}
}

/*
//Verwachte output
Alle contacten uit adresboek 1 in volgorde van toevoeging
Aantal contacten:7
Depeel         Andi            016111111
Depeel         Els             016111111
Dox            Jo              016222211
Adons          Andi            016111333
Adons          Dirk            016111333
Vranken        Rita            011999999
Vangeel        Anja            011111112

Alle contacten uit adresboek 2 in volgorde van toevoeging
Aantal contacten:8
Depeel         Els             016111111
Degrijse       Jan             011224511
Adons          Andi            016111333
Depeel         Andi            016111111
Adons          Robrecht        016111333
Vranken        Rita            011999999
Vanlo          Kris            016190111
Dero           Eno             011111112

Alle gemeenschappelijke contacten uit adresboek 1 en adresboek 2 in alfabetische volgorde achternaam/voornaam
Aantal contacten:4
Adons          Andi            016111333
Depeel         Andi            016111111
Depeel         Els             016111111
Vranken        Rita            011999999

Alle gezamelijke contacten uit adresboek 1 en adresboek 2 in alfabetische volgorde achternaam/voornaam
Aantal contacten:11
Adons          Andi            016111333
Adons          Dirk            016111333
Adons          Robrecht        016111333
Degrijse       Jan             011224511
Depeel         Andi            016111111
Depeel         Els             016111111
Dero           Eno             011111112
Dox            Jo              016222211
Vangeel        Anja            011111112
Vanlo          Kris            016190111
Vranken        Rita            011999999

Alle contacten uit adresboek 1 die niet voorkomen in adresboek 2 in alfabetische volgorde achternaam/voornaam
Aantal contacten:3
Adons          Dirk            016111333
Dox            Jo              016222211
Vangeel        Anja            011111112

Dox Jo niet toegevoegd aan adresboek 1
Rummens Rani toegevoegd aan adresboek 1
Aantal verwijderde contacten met achternaam Adons uit adresboek 1:2
Alle contacten uit adresboek 1 in volgorde van toevoeging na aanpassingen
Aantal contacten:6
Depeel         Andi            016111111
Depeel         Els             016111111
Dox            Jo              016222211
Vranken        Rita            011999999
Vangeel        Anja            011111112
Rummens        Rani            013288338
*/
