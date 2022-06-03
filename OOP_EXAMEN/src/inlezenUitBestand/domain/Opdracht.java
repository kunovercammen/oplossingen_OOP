package inlezenUitBestand.domain;

public class Opdracht implements Comparable<Opdracht>  {

	public static final String CATEGORIE_AARDRIJKSKUNDE = "Aardrijkskunde";
	public static final String CATEGORIE_GESCHIEDENIS = "Geschiedenis";
	public static final String CATEGORIE_NEDERLANDS = "Nederlands";
	public static final String CATEGORIE_WISKUNDE = "Wiskunde";
	public static final String CATEGORIE_WETENSCHAPPEN = "Wetenschappen";

	public static final String[] CATEGORIEEN = { CATEGORIE_AARDRIJKSKUNDE,
			CATEGORIE_GESCHIEDENIS, CATEGORIE_NEDERLANDS, CATEGORIE_WISKUNDE,
			CATEGORIE_WETENSCHAPPEN };

	/**
	 * Deze id wordt toegekend door de OpdrachtDatabase klasse wanneer een
	 * opdracht aan de opdrachtendatabase wordt toegevoegd. (deze ID begint met
	 * 1 en wordt altijd met 1 verhoogd)
	 */
	private int opdrachtID;

	/**
	 * De String vraag bevat de vraag die bij de opdracht behoort. Op een vraag
	 * moet kunnen geantwoord worden met 1 woord of getal. Voorbeeld: Wat is
	 * de hoofdstad van Frankrijk.
	 */
	private String vraag;

	/**
	 * De String antwoord bevat het verwachte antwoord op de vraag. Voorbeeld
	 * bij voorgaande vraag is het juiste antwoord: Parijs.
	 */
	private String antwoord;

	/**
	 * De boolean isHoofdletterGevoelig geeft aan of men bij het evalueren van
	 * het antwoord al dan niet rekening zal houden met het gebruik van
	 * hoofdletters. Indien niet zal bijvoorbeeld Parijs en parijs als hetzelfde
	 * antwoord beschouwd worden.
	 */
	private boolean isHoofdletterGevoelig;

	/**
	 * De String antwoordhint is een hulp voor de quizkandidaat bij het zoeken
	 * naar het juiste antwoord. Voorbeeld: bij de bovenstaande vraag kan een
	 * antwoordhint zijn: Men vindt er de Eifel toren. Een antwoordhint is
	 * optioneel bij een opdracht (hoeft niet verplicht ingevuld te worden bij
	 * elke opdracht)
	 */
	private String antwoordHint;

	/**
	 * De String categorie geeft aan tot welke categorie deze opdracht behoort.
	 * We maken opdrachten van 5 categorien: Aardrijkskunde, Geschiedenis,
	 * Nederlands, Wetenschappen en Wiskunde
	 */
	private String categorie;

	/**
	 * De auteur is de naam van wie heeft deze opdracht bedacht.
	 */
	private String auteur;

	/**
	 * Contructor voor het maken van een opdracht MET hint
	 * 
	 * @param id
	 *            de id voor deze opdracht (moet uit de opdrachten db komen)
	 * @param vraag
	 *            de vraag voor deze opdracht
	 * @param antwoord
	 *            het 1-woord-of-getal antwoord
	 * @param hoofdlettergevoelig
	 *            geeft aan of bij het antwoord rekening gehouden moet worden
	 *            met hoofdletters
	 * @param hint
	 *            de antwoord-hint
	 * @param categorie
	 *            een van de vijf bovenaan gedefinieerde categorieen
	 * @param auteur
	 *            de naam van de bedenker van deze opdracht
	 */
	public Opdracht(int id, String vraag, String antwoord,
			boolean hoofdlettergevoelig, String hint, String categorie,
			String auteur) {
		setOpdrachtID(id);
		setVraag(vraag);
		setAntwoord(antwoord);
		setHoofdletterGevoelig(hoofdlettergevoelig);
		setAntwoordHint(hint);
		setCategorie(categorie);
		setAuteur(auteur);
	}

	/**
	 * Constructor voor het maken van een opdracht ZONDER hint
	 * 
	 * @param id
	 *            de id voor deze opdracht (moet uit de opdrachten db komen)
	 * @param vraag
	 *            de vraag voor deze opdracht
	 * @param antwoord
	 *            het 1-woord-of-getal antwoord
	 * @param hoofdlettergevoelig
	 *            geeft aan of bij het antwoord rekening gehouden moet worden
	 *            met hoofdletters
	 * @param categorie
	 *            categorie een van de vijf bovenaan gedefinieerde categorieen
	 * @param auteur
	 *            de naam van de bedenker van deze opdracht
	 */
	public Opdracht(int id, String vraag, String antwoord,
			boolean hoofdlettergevoelig, String categorie, String auteur) {
		setOpdrachtID(id);
		setVraag(vraag);
		setAntwoord(antwoord);
		setHoofdletterGevoelig(hoofdlettergevoelig);
		setAntwoordHint("Er werd geen hint voorzien voor deze opdracht");
		setCategorie(categorie);
		setAuteur(auteur);
	}

	/**
	 * @return the opdrachtID
	 */
	public int getOpdrachtID() {
		return opdrachtID;
	}

	/**
	 * @param opdrachtID
	 *            the opdrachtID to set
	 */
	private void setOpdrachtID(int opdrachtID) {
		this.opdrachtID = opdrachtID;
	}

	/**
	 * @return de vraag voor deze opdracht
	 */
	public String getVraag() {
		return vraag;
	}

	/**
	 * @param vraag
	 *            de nieuwe waarde voor vraag
	 */
	private void setVraag(String vraag) {
		this.vraag = vraag;
	}

	/**
	 * @return het antwoord
	 */
	public String getAntwoord() {
		return antwoord;
	}

	/**
	 * @param antwoord
	 *            de nieuwe waarde voor antwoord
	 */
	private void setAntwoord(String antwoord) {
		this.antwoord = antwoord;
	}

	/**
	 * @return of bij het antwoord rekening gehouden moet worden
	 *            met hoofdletters
	 */
	public boolean isHoofdletterGevoelig() {
		return isHoofdletterGevoelig;
	}

	/**
	 * @param isHoofdletterGevoelig
	 *            de nieuwe waarde voor isHoofdletterGevoelig
	 */
	private void setHoofdletterGevoelig(boolean isHoofdletterGevoelig) {
		this.isHoofdletterGevoelig = isHoofdletterGevoelig;
	}

	/**
	 * @return de antwoordHint
	 */
	public String getAntwoordHint() {
		return antwoordHint;
	}

	/**
	 * @param antwoordHint
	 *            de nieuwe waarde voor antwoordHint
	 */
	private void setAntwoordHint(String antwoordHint) {
		this.antwoordHint = antwoordHint;
	}

	/**
	 * @return de categorie
	 */
	public String getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie
	 *            de nieuwe waarde voor categorie
	 */
	private void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return de auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * @param auteur
	 *            de nieuwe waarde voor auteur
	 */
	private void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	/**
	 * Methode om de gelijkheid van twee opdrachten te checken
	 * 
	 * @return true als ze gelijk zijn
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Opdracht))
            return false;
        Opdracht o = (Opdracht) object;
        return this.opdrachtID == o.opdrachtID ||
               this.vraag.equals(o.vraag)||
			   this.antwoord.equals(o.antwoord) ||
			   this.auteur.equals(o.auteur) ||
			   this.categorie.equals(o.categorie) ||
               this.antwoordHint.equals(o.antwoordHint)||
               this.isHoofdletterGevoelig == o.isHoofdletterGevoelig;
	}

	/**
	 * Methode om deze opdracht volledig uit te schrijven
	 */
	public String toString() {
		String dezeOpdracht = "";
		dezeOpdracht += getOpdrachtID() + " - " + getCategorie() + "\n";
		dezeOpdracht += "-------------------------------------------\n";
		dezeOpdracht += "auteur: " + getAuteur() + "\n";
		dezeOpdracht += "-------------------------------------------\n";
		dezeOpdracht += "vraag: " + getVraag() + "\n";
		dezeOpdracht += "hint: " + getAntwoordHint() + "\n";
		if (isHoofdletterGevoelig()) {
			dezeOpdracht += "hoofdlettergevoelig antwoord \n";
		} else {
			dezeOpdracht += "antwoord niet hoofdlettergevoelig \n";
		}
		dezeOpdracht += "-------------------------------------------\n";
		dezeOpdracht += "antwoord: " + getAntwoord() + "\n";
		dezeOpdracht += "---------------------------------------------";
		return dezeOpdracht;
	}

	@Override
	public int compareTo(Opdracht o) {
		return this.getCategorie().compareTo(o.getCategorie());
	}

}
