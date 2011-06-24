import java.util.ArrayList;


public class Ligne {
	
	static int billesParLigne;
	
	private ArrayList<Bille> billes = new ArrayList<Bille>();
	
	private int couleurPlacee = 0;
	private int couleurNonPlacee = 0;
	
	public Ligne() {
	}
	
	public Ligne(int nbBilles) {
		billesParLigne = nbBilles;
	}
	
	public int getBille(int position) {
		return billes.get(position).getCouleur();
	}
	
	public void setBilles() {			// aléatoire pour le résultat.
		Bille b = new Bille();			// première bille.
		b.setCouleur();
		billes.add(b);
		
		do {							// autres billes, différentes des précédentes.
			Bille bi = new Bille();
			bi.setCouleur();
			boolean doublon = false;
			for (Bille bil : billes) {
				if (bi.getCouleur() == bil.getCouleur()) {
					doublon = true;
				}
			}
			if (doublon == false) {
				billes.add(bi);
			}
		} while (billes.size() != billesParLigne);
		
	}

	public boolean setBilles(String entree) {		// entree de type "1234".
		boolean ok = false;
		int tailleEntree = entree.length();
		
		for (int i = 0; (i < tailleEntree && i < billesParLigne); i++) {
			int num = charToInt(entree.charAt(i));
			Bille b = new Bille(num);
			if (b.verifierCouleur()) {
				billes.add(b);
			}
		}
		
		if (billes.size() < billesParLigne) {
			System.out.println("Erreur : vous devez entrer "+billesParLigne+" billes.");
		} else {
			ok = true;
		}
		
		return ok;
	}
	
	public boolean verifierResultat(Ligne resultat) {
		boolean victoire = false;
		
		for (int i = 0; i < billesParLigne; i++) {
			if (resultat.getBille(i) == this.getBille(i)) {
				this.couleurPlacee++;
			} else {
				for (int j = 0; j < billesParLigne; j++) {
					if (j != i && resultat.getBille(i) == this.getBille(j)) {
						this.couleurNonPlacee++;
					}
				}
			}
		}
		
		if (couleurPlacee == billesParLigne) {
			victoire = true;
		}
		
		return victoire;
	}
	
	public int getCouleurPlacee() {
		return couleurPlacee;
	}

	public int getCouleurNonPlacee() {
		return couleurNonPlacee;
	}
	
	public static int charToInt(char num) {
		int result = -1;
		
		switch (num) {
		case '0': result = 0; break;
		case '1': result = 1; break;
		case '2': result = 2; break;
		case '3': result = 3; break;
		case '4': result = 4; break;
		case '5': result = 5; break;
		case '6': result = 6; break;
		case '7': result = 7; break;
		case '8': result = 8; break;
		case '9': result = 9; break;
		}
		
		return result;
	}
	
	public String toString() {
		String res = "";
		
		for (Bille b : billes) {
			res += b.getCouleur()+" ";
		}
		
		return res;
	}
	
}
