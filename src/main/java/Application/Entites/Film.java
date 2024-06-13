package Application.Entites;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "FILM")
public class Film {

	/** id **/
	@Id
	@Column(name = "ID")
	private String id;

	/** nom **/
	@Column(name = "NOM")
	private String nom;

	/** annee **/
	@Column(name = "ANNEE")
	private int annee; // récup que les 4 dernières valeurs dans la méthode du split pour les périodes
						// de temps

	/** rating **/
	@Column(name = "RATING")
	private double rating; // dans le split mettre les 2 types de séparateurs

	/** url **/
	@Column(name = "URL")
	private String url;

	/** resume **/
	@Column(name = "RESUME")
	private String resume;

	@ManyToMany
	@JoinTable(name = "CASTING_PRINCIPAL", 
		joinColumns = @JoinColumn(name = "ID_FILM", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "ID_ACTEURS", referencedColumnName = "ID"))
	private Set<Acteur> acteurs = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "REALISATEURS_FILMS", joinColumns = @JoinColumn(name = "ID_FILM", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_REALISATEUR", referencedColumnName = "ID"))
	private Set<Realisateur> realisateurs = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "GENRES_FILMS", joinColumns = @JoinColumn(name = "ID_FILM", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_GENRE", referencedColumnName = "ID"))
	private Set<Genre> genres = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "ID_LANGUE")
	private Langue langues;

	@ManyToOne
	@JoinColumn(name = "ID_PAYS")
	private Pays pays;
	
	@OneToMany(mappedBy = "films") 
	private Set<Role> roles = new HashSet<>();

	@Embedded
	private Lieu lieux;

	/**
	 * Constructeur
	 * 
	 */
	public Film() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param nom
	 * @param annee
	 * @param rating
	 * @param url
	 * @param resume
	 */
	public Film(String id, String nom, int annee, double rating, String url, String resume) {
		this.id = id;
		this.nom = nom;
		this.annee = annee;
		this.rating = rating;
		this.url = url;
		this.resume = resume;
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
	 * Getter pour nom
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter pour nom
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter pour annee
	 * 
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * Setter pour annee
	 * 
	 * @param annee the annee to set
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}

	/**
	 * Getter pour rating
	 * 
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * Setter pour rating
	 * 
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * Getter pour url
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Setter pour url
	 * 
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Getter pour resume
	 * 
	 * @return the resume
	 */
	public String getResume() {
		return resume;
	}

	/**
	 * Setter pour resume
	 * 
	 * @param resume the resume to set
	 */
	public void setResume(String resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", nom=" + nom + ", annee=" + annee + ", rating=" + rating + "]";
	}

	/** Getter pour acteurs
	 * @return the acteurs
	 */
	public Set<Acteur> getActeurs() {
		return acteurs;
	}

	/** Setter pour acteurs
	 * @param acteurs the acteurs to set
	 */
	public void setActeurs(Set<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	/** Getter pour realisateurs
	 * @return the realisateurs
	 */
	public Set<Realisateur> getRealisateurs() {
		return realisateurs;
	}

	/** Setter pour realisateurs
	 * @param realisateurs the realisateurs to set
	 */
	public void setRealisateurs(Set<Realisateur> realisateurs) {
		this.realisateurs = realisateurs;
	}

	/** Getter pour genres
	 * @return the genres
	 */
	public Set<Genre> getGenres() {
		return genres;
	}

	/** Setter pour genres
	 * @param genres the genres to set
	 */
	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	/** Getter pour langues
	 * @return the langues
	 */
	public Langue getLangues() {
		return langues;
	}

	/** Setter pour langues
	 * @param langues the langues to set
	 */
	public void setLangues(Langue langues) {
		this.langues = langues;
	}

	/** Getter pour pays
	 * @return the pays
	 */
	public Pays getPays() {
		return pays;
	}

	/** Setter pour pays
	 * @param pays the pays to set
	 */
	public void setPays(Pays pays) {
		this.pays = pays;
	}

	/** Getter pour roles
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/** Setter pour roles
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/** Getter pour lieux
	 * @return the lieux
	 */
	public Lieu getLieux() {
		return lieux;
	}

	/** Setter pour lieux
	 * @param lieux the lieux to set
	 */
	public void setLieux(Lieu lieux) {
		this.lieux = lieux;
	}

}
