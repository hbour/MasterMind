
public class MasterMind {

	
	public static void main(String[] args) {
		Partie p;
		char reponse;
		
		System.out.println("\r      M A S T E R M I N D");
		
		do {
			System.out.println("\r--------------------------------");
			System.out.println("Configurez la difficulté du jeu.");
			boolean valid;
			int nbLignes;
			int nbCouleurs;
			int nbBilles;
			do {
				valid = false;
				System.out.println("Nombre d'essais (standard: 10) :");
				nbLignes = Lire.Entier();
				if (nbLignes > 0) {
					valid = true;
				} else {
					System.out.println("Erreur : nombre d'essais <= 0.");
				}
			} while (valid == false);
			
			do {
				valid = false;
				System.out.println("Nombres de couleurs au total (standard: 8, max: 10) :");
				nbCouleurs = Lire.Entier();
				if (nbCouleurs > 1 && nbCouleurs < 11) {
					valid = true;
				} else {
					System.out.println("Erreur : 1 < couleurs < 11");
				}
			} while (valid == false);
			
			do {
				valid = false;
				System.out.println("Nombre de billes à placer (standard: 4) :");
				nbBilles = Lire.Entier();
				if (nbBilles > 0 && nbBilles < nbCouleurs) {
					valid = true;
				} else {
					System.out.println("Erreur : nombre de billes hors limites.");
				}
			} while (valid == false);
			System.out.println("--------------------------------\r");
			
			p = new Partie(nbLignes, nbBilles, nbCouleurs);
			p.jouer();
			
			System.out.println("\rSouhaitez-vous rejouer? (oui | non)");
			reponse = Lire.Chaine().toLowerCase().charAt(0);
		} while (reponse == 'o');

	}

}
