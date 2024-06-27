package Application.Entites;

public class ActeurLieu {

	private Acteur acteur;
	private Lieu lieu;

	public ActeurLieu(Acteur acteur) {
		this.acteur = acteur;
	}

	public ActeurLieu(Lieu lieu) {
		this.lieu = lieu;
	}

	public Acteur getActeur() {
		return acteur;
	}

	public Lieu getLieu() {
		return lieu;
	}

	@Override
	public String toString() {
		if (acteur != null) {
			return "Acteur: " + acteur.toString();
		} else if (lieu != null) {
			return "Lieu: " + lieu.toString();
		}
		return "Empty ActeurLieu";
	}
}
