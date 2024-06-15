package Application.Entites;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIEU")
public class Lieu {

	/** id **/
	@Id
	@Column(name = "ID")
	private String id;

	/** rue **/
	@Column(name = "QUARTIER")
	private String quartier;

	/** ville **/
	@Column(name = "VILLE")
	private String ville;

	/** etat **/
	@Column(name = "ETAT")
	private String etat;

	/** pays **/
	@Column(name = "PAYS")
	private String pays;

	/** realisateurs **/
	@OneToMany(mappedBy = "lieuNaissance")
	private Set<Realisateur> realisateurs = new HashSet<>();

	/** acteurs **/
	@OneToMany(mappedBy = "lieuNaissance")
	private Set<Acteur> acteurs = new HashSet<>();

	/** films **/
	@OneToMany(mappedBy = "lieuTournage")
	private Set<Film> films = new HashSet<>();

	/**
	 * Constructeur
	 * 
	 */
	public Lieu() {
	}

	/**
	 * Constructeur
	 * 
	 * @param rue
	 * @param ville
	 * @param etat
	 * @param pays
	 */
	public Lieu(String quartier, String ville, String etat, String pays) {
		this.quartier = quartier;
		this.ville = ville;
		this.etat = etat;
		this.pays = pays;
	}

	/**
	 * Getter pour id
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter pour id
	 * 
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Getter pour rue
	 * 
	 * @return the rue
	 */
	public String getQuartier() {
		return quartier;
	}

	/**
	 * Setter pour rue
	 * 
	 * @param rue the rue to set
	 */
	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	/**
	 * Getter pour ville
	 * 
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Setter pour ville
	 * 
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Getter pour etat
	 * 
	 * @return the etat
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * Setter pour etat
	 * 
	 * @param etat the etat to set
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}

	/**
	 * Getter pour pays
	 * 
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * Setter pour pays
	 * 
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * Getter pour realisateurs
	 * 
	 * @return the realisateurs
	 */
	public Set<Realisateur> getRealisateurs() {
		return realisateurs;
	}

	/**
	 * Setter pour realisateurs
	 * 
	 * @param realisateurs the realisateurs to set
	 */
	public void setRealisateurs(Set<Realisateur> realisateurs) {
		this.realisateurs = realisateurs;
	}

	/**
	 * Getter pour acteurs
	 * 
	 * @return the acteurs
	 */
	public Set<Acteur> getActeurs() {
		return acteurs;
	}

	/**
	 * Setter pour acteurs
	 * 
	 * @param acteurs the acteurs to set
	 */
	public void setActeurs(Set<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	/**
	 * Getter pour films
	 * 
	 * @return the films
	 */
	public Set<Film> getFilms() {
		return films;
	}

	/**
	 * Setter pour films
	 * 
	 * @param films the films to set
	 */
	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Lieu [id=" + id + ", quartier=" + quartier + ", ville=" + ville + ", etat=" + etat + ", pays=" + pays + "]";
	}

}
