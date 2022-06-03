package inlezenUitBestand.db;

import inlezenUitBestand.domain.Opdracht;
import inlezenUitBestand.domain.OpdrachtComparatorOpCategorieEnID;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OpdrachtDatabank {
    private List<Opdracht> opdrachten;

    public OpdrachtDatabank(String fileNaam){
        this.opdrachten = new ArrayList<>();
        leesBestand(fileNaam);
    }
        
    public void leesBestand(String fileNaam) {
        File personenFile = new File(fileNaam);
        try {
            Scanner scannerFile = new Scanner(personenFile);
            while (scannerFile.hasNextLine()) {
                String s = scannerFile.nextLine();
                String[] delen = s.split("\\t");
                Opdracht opdracht = new Opdracht(Integer.parseInt(delen[0]),delen[1],delen[2],
                        (delen[3].equals("true")),
                        delen[4],delen[5],delen[6]);

                this.opdrachten.add(opdracht);
            }
        }  catch (FileNotFoundException ex1) {
            throw new DbException(fileNaam+" niet gevonden");
        } catch (NumberFormatException ex2){
            throw new DbException("Fout bij het inlezen van "+fileNaam);
        }
    }

    public List<Opdracht> getOpdrachten() {
        return this.opdrachten;
    }

    public void voegToe(Opdracht o) {
        if (o == null) throw new IllegalArgumentException();
        if (this.opdrachten.contains(o)) throw new IllegalArgumentException();
        this.opdrachten.add(o);
    }
    
    public List<Opdracht> getOpdrachtenGesorteerdOpCategorie(){
    	/*List <Opdracht> opdrachten = this.getOpdrachten();
    	List <Opdracht> opdrachtenGeordend = new ArrayList<>();
    	for (int i = 0;i < opdrachten.size();i++) {opdrachtenGeordend.add(opdrachten.get(i));}*/
		List <Opdracht> opdrachtenGeordend = new ArrayList<>(this.getOpdrachten());
    	Collections.sort(opdrachtenGeordend);
    	return opdrachtenGeordend;
    }
    
    public List<Opdracht> getOpdrachtenGesorteerdOpCategorieEnID(){
    	List <Opdracht> opdrachtenGeordend = new ArrayList<>(this.getOpdrachten());
    	Collections.sort(opdrachtenGeordend,new OpdrachtComparatorOpCategorieEnID());
    	return opdrachtenGeordend;
    }
    
    public static void main(String [] args) {
    	OpdrachtDatabank opdrachtDatabank = new OpdrachtDatabank("opdrachtenQuiz.txt");
    	List <Opdracht> lijst = opdrachtDatabank.getOpdrachten();
    	System.out.println("NIET GEORDEND");
    	for (int i=0;i<5;i++) {
    		System.out.println(lijst.get(i));    		
    	}
    	System.out.println("GEORDEND OP CATEGORIE");
    	List <Opdracht> lijst2 = opdrachtDatabank.getOpdrachtenGesorteerdOpCategorie();
    	for (int i=0;i<5;i++) {
    		System.out.println(lijst2.get(i));    		
    	}
    	System.out.println("GEORDEND OP CATEGORIE EN ID");
    	List <Opdracht> lijst3 = opdrachtDatabank.getOpdrachtenGesorteerdOpCategorieEnID();
    	for (int i=0;i<5;i++) {
    		System.out.println(lijst3.get(i));    		
    	}
    	System.out.println("NIET GEORDEND");
    	for (int i=0;i<5;i++) {
    		System.out.println(lijst.get(i));    		
    	}
    }
}
