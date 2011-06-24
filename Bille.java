
public class Bille {

	private int couleur;
	
	static int couleurMin;
	static int couleurMax;
	
	public Bille() {
	}
	
	
	public Bille(int couleur) {
		if(setCouleur(couleur) == false) {
			System.out.println("Erreur : couleur \'"+couleur+"\' invalide.");
		}
	}
	
	public boolean verifierCouleur() {
		boolean ok = false;
		
		if (this.couleur >= couleurMin && this.couleur <= couleurMax) {
			ok = true;
		}
		
		return ok;
	}

	public int getCouleur() {
		return couleur;
	}
	
	public void setCouleur() {
		int r;
		boolean valid;
		do {
			valid = false;
			
			r = (int) (Math.random() * 10);
						
			if (r>=couleurMin && r<=couleurMax) {
				valid = true;
			}
		} while (valid == false);
		
		this.couleur = r;
	}

	public boolean setCouleur(int couleur) {
		boolean ok;
		
		if (couleur >= couleurMin && couleur <= couleurMax) {
			this.couleur = couleur;
			ok = true;
		} else {
			ok = false;
		}
		
		return ok;
	}

	public static int getCouleurMin() {
		return couleurMin;
	}

	public static boolean setCouleurMin(int couleurMin) {
		boolean ok;
		
		if (couleurMin < couleurMax && couleurMin >= 0) {
			Bille.couleurMin = couleurMin;
			ok = true;
		} else {
			ok = false;
		}
		
		return ok;
	}

	public static int getCouleurMax() {
		return couleurMax;
	}

	public static boolean setCouleurMax(int couleurMax) {
		boolean ok;
		
		if (couleurMax > couleurMin && couleurMax < 10) {
			Bille.couleurMax = couleurMax;
			ok = true;
		} else {
			ok = false;
		}
		
		return ok;
	}
	
	
}
