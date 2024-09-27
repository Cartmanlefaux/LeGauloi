package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageois = 0;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		} else {
			System.out.println("Le village est plein, impossible d'ajouter");
		}
	}

	public Gaulois trouverHabitant(int numero) {
		if (0 < numero && numero < nbVillageois) {
			return villageois[numero];
		} else {
			System.out.println("Aucun habitant trouvé à l'index " + numero);
			return null;
		}
	}

	public String getNom() {
		return nom;
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);

		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);

		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);

		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);

		village.afficherVillageois();

	}

	public void afficherVillageois() {
		if (chef != null) {
			System.out.println("Dans village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		} else {
			System.out.println("Pas de chef pour ce village.");
		}

		for (int i = 0; i < nbVillageois; i++) {
			if (villageois[i] != null) {
				System.out.println("- " + villageois[i].getNom());
			}
		}
	}
}
