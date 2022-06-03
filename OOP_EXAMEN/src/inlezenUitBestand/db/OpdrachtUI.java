package inlezenUitBestand.db;

import inlezenUitBestand.domain.Opdracht;
import inlezenUitBestand.domain.Quiz;

import java.util.Scanner;

public class OpdrachtUI {

	public static void main(String[] args) {		

		Quiz quiz = new Quiz(new OpdrachtDatabank("C:\\Users\\kunov\\Documents\\TOEGEPASTE INFORMATICA\\OOP\\OOP_EXAMEN\\src\\inlezenUitBestand\\db\\OpdrachtenQuiz.txt"));
				
		Opdracht opdracht;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Beantwoord volgende 3 vragen");
		for (int i = 1; i <= 3;i++) {
			opdracht = quiz.getRandomOpdracht();
			System.out.println("\nVRAAG "+i+":"+opdracht.getVraag());
			if (!(opdracht.getAntwoordHint().equals("Geen hint"))) {
				System.out.println("HINT:"+opdracht.getAntwoordHint());
			}
			String antwoord = scanner.nextLine();
			if (opdracht.isHoofdletterGevoelig()){
				if (antwoord.equals(opdracht.getAntwoord())){
					System.out.println("Goed gedaan");
				}	
				else {
					System.out.println("Niet ok; het juiste antwoord is: " + opdracht.getAntwoord());
				}
			} 
			else {
				if (antwoord.equalsIgnoreCase(opdracht.getAntwoord())){
					System.out.println("Goed gedaan");
				}
				else {
					System.out.println("Niet ok; het juiste antwoord is: " + opdracht.getAntwoord());
				}
			}
		}
		System.out.println("\n"+"EINDE QUIZ");		
		scanner.close();
	}
}
