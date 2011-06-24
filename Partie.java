
public class Partie {
	
	Plateau plateau;
	
	public Partie(int nbLignes, int nbBilles, int nbCouleurs) {
		plateau = new Plateau(nbLignes, nbBilles, nbCouleurs);
	}

	public void jouer() {
		boolean victoire = false;
		do {
			if (plateau.jouer()) {
				System.out.println("\rR�sultat : "+plateau.getResultat()+" - - -  Vous avez gagn� !");
				victoire = true;
				break;
			}
		} while (plateau.lignes.size() < plateau.getLignesParPlateau() || victoire == true);
	}
}
