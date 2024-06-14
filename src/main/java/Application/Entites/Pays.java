package Application.Entites;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAYS")
public class Pays {

	/** id **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	/** nom **/
	@Column(name = "NOM")
	private String nom;

	/** url **/
	@Column(name = "URL")
	private String url;

	@OneToMany(mappedBy = "pays")
	private Set<Film> films = new HashSet<>();

	/**
	 * Constructeur
	 * 
	 */
	public Pays() {
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param nom
	 * @param url
	 */
	public Pays(String nom, String url) {
		this.nom = nom;
		this.url = url;
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
		return "Pays [nom=" + nom + ", url=" + url + "]";
	}

}
