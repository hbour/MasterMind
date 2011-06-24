import java.util.ArrayList;


public class Plateau {

	private int lignesParPlateau;
	
	protected ArrayList<Ligne> lignes = new ArrayList<Ligne>();
	
	private Ligne resultat = new Ligne();
	
	
	public Plateau() {
		lignesParPlateau = 10;
		resultat.setBilles();
	}
	
	public Plateau(int nbLignes, int nbBilles, int nbCouleurs) {
		lignesParPlateau = nbLignes;
		Ligne.billesParLigne = nbBilles;
		if (nbCouleurs <= 10 && nbCouleurs > 0) {
			Bille.couleurMin = 0;
			Bille.couleurMax = nbCouleurs-1;
		} else {
			System.out.println("Erreur : nombre de couleurs incorrect.");
		}
		resultat.setBilles();
	}

	public int getLignesParPlateau() {
		return lignesParPlateau;
	}

	public void setLignesParPlateau(int nbLignes) {
		if (nbLignes > 1) {
			lignesParPlateau = nbLignes;
		}
	}
	
	public Ligne getResultat() {
		return resultat;
	}
	
	public boolean jouer() {
		boolean victoire = false;
		if (lignes.size() <= lignesParPlateau) {
			String ex = "";
			for (int i=0; i<Ligne.billesParLigne; i++) {
				ex += i;
			}
			System.out.println("\rEntrez "+Ligne.billesParLigne+" nombres différents de "+Bille.couleurMin+" à "
					+Bille.couleurMax+" (par exemple \'"+ex+"\') :");
			Ligne tour = new Ligne();
			if (tour.setBilles(Lire.Chaine())) {
				if (tour.verifierResultat(this.resultat)) {
					victoire = true;
				}
				lignes.add(tour);
			}
			System.out.println(this);
		}
		return victoire;
	}

	public String toString() {
		String res = "\r";
		
		for (Ligne l : lignes) {
			String cp, cnp;
			if (l.getCouleurPlacee() > 1) {
				cp = l.getCouleurPlacee()+" bien placées";
			} else {
				cp = l.getCouleurPlacee()+" bien placée";
			}
			if (l.getCouleurNonPlacee() > 1) {
				cnp = l.getCouleurNonPlacee()+" mal placées";
			} else {
				cnp = l.getCouleurNonPlacee()+" mal placée";
			}
			res += "|   "+l+"  |   Bonnes couleurs : "+cp+" et "+cnp+".\r";
		}
		
		if (lignes.size() == lignesParPlateau) {
			res+= "\rIl fallait trouver : "+resultat;
		} else {
			int tour = lignesParPlateau - lignes.size();
			if (tour > 1) {
				res += "\rIl vous reste "+tour+" essais.";
			} else if (tour == 1) {
				res += "\rIl vous reste 1 essai.";
			} else {
				res += "\rFin de partie.";
			}
			
		}
		
		return res;
	}
	
	
}
