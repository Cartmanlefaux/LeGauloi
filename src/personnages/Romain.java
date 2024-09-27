package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
	    if (force <= 0) {
	    	throw new IllegalArgumentException("La force d'un Romain doit être positive.");
	    }
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");

	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		if (force <= 0) {
            throw new IllegalStateException("La force d'un Romain doit être positive pour recevoir un coup.");
        }

        int forceInitiale = force;

        force -= forceCoup;

        if (force >= forceInitiale) {
            throw new IllegalStateException("La force d'un Romain doit avoir diminué après avoir reçu un coup.");
        }
        
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}

	}

	public static void main(String[] args) {
		Romain cesar = new Romain("César", 10);
		Romain minus = new Romain("Minus", 6);
		System.out.println(cesar.getNom());
		cesar.parler("Je suis le grand César");
		cesar.recevoirCoup(3);
		System.out.println("La force de César est de " + cesar.force);
	}

}
