package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;

	public Romain(String nom, int force) {
		if (force <= 0) {
			throw new IllegalArgumentException("La force d'un Romain doit être positive.");
		}
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
		this.nbEquipement = 0;
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

	public void ajouterEquipement(Equipement equipement) {
		if (nbEquipement < equipements.length) {
			equipements[nbEquipement] = equipement;
			nbEquipement++;
		}
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
			} else {
				ajouterEquipement(equipement);
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
			}
			break;
		case 0:
			ajouterEquipement(equipement);
			System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) {

		Romain minus = new Romain("Minus", 10);

		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}

}
