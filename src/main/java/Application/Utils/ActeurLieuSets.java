package Application.Utils;

import java.util.HashSet;
import java.util.Set;

import Application.Entites.Acteur;
import Application.Entites.Lieu;

public class ActeurLieuSets {
	private Set<Acteur> acteurs = new HashSet<>();
	private Set<Lieu> lieux = new HashSet<>();

	public ActeurLieuSets(Set<Acteur> acteurs, Set<Lieu> lieux) {
		this.acteurs = acteurs;
		this.lieux = lieux;
	}

	public Set<Acteur> getActeurs() {
		return acteurs;
	}

	public Set<Lieu> getLieux() {
		return lieux;
	}
}
