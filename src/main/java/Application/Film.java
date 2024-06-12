package Application;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
		super();
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

}
