package week10.domain;

import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class VerjaardagsKalender {
	private Map<DagMaand,Set<Persoon>> kalender;
	
	public VerjaardagsKalender(){
		this.kalender = new TreeMap<>();
	}
	
	public void voegVerjaardagToe(Persoon p){
		//TO DO schrijf deze methode
		if(p != null) {
			DagMaand d = new DagMaand(p.getGeboorteDatum());
			if (!this.kalender.containsKey(d)) {
				this.kalender.put(d, new TreeSet<>());
			}
			this.kalender.get(d).add(p);
		}
	}

	public void verwijderPersoon(Persoon p){
		if (p!=null){
			DagMaand d = new DagMaand(p.getGeboorteDatum());
			if (this.kalender.containsKey(d)){
				Set<Persoon> personen = this.kalender.get(d);
				if (personen != null) {
					this.kalender.get(d).remove(p);
					if (this.kalender.get(d).size() == 0){
						this.kalender.remove(d);
					}
				}
			}
		}
	}
	
	public String toString(){
		String uit = "";
		for (DagMaand d : this.kalender.keySet()){
			uit+= d +  " " + this.kalender.get(d) + ":\n"; 
		}
		return uit;
	}
}
