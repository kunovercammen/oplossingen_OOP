package inlezenUitBestand.domain;

import java.util.Comparator;

public class OpdrachtComparatorOpCategorieEnID implements Comparator<Opdracht> {

	@Override
	public int compare(Opdracht o1, Opdracht o2) {
		int terug = o1.getCategorie().compareTo(o2.getCategorie());
		if (terug == 0){
			terug = o1.getOpdrachtID()-o2.getOpdrachtID();
		}
		return terug;
	}
}
