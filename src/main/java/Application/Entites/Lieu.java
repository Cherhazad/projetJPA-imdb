package Application.Entites;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIEU")
public class Lieu {

	/** id **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	/** quartier **/
	@Column(name = "QUARTIER")
	private String quartier;

	/** ville **/
	@Column(name = "VILLE")
	private String ville;

	/** etat **/
	@Column(name = "ETAT")
	private String etat;

	/** realisateurs **/
	@OneToMany(mappedBy = "lieuNaissance")
	private Set<Realisateur> realisateurs = new HashSet<>();

	/** acteurs **/
	@OneToMany(mappedBy = "lieuNaissance")
	private Set<Acteur> acteurs = new HashSet<>();

	/** films **/
	@OneToMany(mappedBy = "lieuTournage")
	private Set<Film> films = new HashSet<>();

	/** pays **/
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PAYS")
	private Pays pays;

	/**
	 * Constructeur
	 * 
	 */
	public Lieu() {
	}

	/**
	 * Constructeur
	 * 
	 * @param quartier
	 * @param ville
	 * @param etat
	 * @param pays
	 */
	public Lieu(String quartier, String ville, String etat, Pays pays) {
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
	public int getId() {
		return id;
	}

	/**
	 * Setter pour id
	 * 
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter pour quartier
	 * 
	 * @return the quartier
	 */
	public String getQuartier() {
		return quartier;
	}

	/**
	 * Setter pour quartier
	 * 
	 * @param quartier the quartier to set
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

	/**
	 * Getter pour pays
	 * 
	 * @return the pays
	 */
	public Pays getPays() {
		return pays;
	}

	/**
	 * Setter pour pays
	 * 
	 * @param pays the pays to set
	 */
	public void setPays(Pays pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "Lieu [id=" + id + ", quartier=" + quartier + ", ville=" + ville + ", etat=" + etat + ", pays=" + pays
				+ "]";
	}

}
