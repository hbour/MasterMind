
public class Partie {
	
	Plateau plateau;
	
	public Partie(int nbLignes, int nbBilles, int nbCouleurs) {
		plateau = new Plateau(nbLignes, nbBilles, nbCouleurs);
	}

	public void jouer() {
		boolean victoire = false;
		do {
			if (plateau.jouer()) {
				System.out.println("\rRésultat : "+plateau.getResultat()+" - - -  Vous avez gagné !");
				victoire = true;
				break;
			}
		} while (plateau.lignes.size() < plateau.getLignesParPlateau() || victoire == true);
	}
}
