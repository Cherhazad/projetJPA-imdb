package Application.Entites;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "REALISATEUR")
public class Realisateur {

	/** id **/
	@Id
	@Column(name = "ID")
	private String id;

	/** identite **/
	@Column(name = "IDENTITE")
	private String identite;

	/** dateNaissance **/
	@Column(name = "DATE_NAISSANCE")
	private LocalDate dateNaissance;

	/** url **/
	@Column(name = "URL")
	private String url;

	/** films **/
	@ManyToMany
	@JoinTable(name = "REALISATEURS_FILMS", joinColumns = @JoinColumn(name = "ID_REALISATEUR", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_FILM", referencedColumnName = "ID"))
	private Set<Film> films = new HashSet<>();

	/** lieuNaissance **/
	@ManyToOne
	@JoinColumn(name = "ID_LIEU_NAISSANCE")
	private Lieu lieuNaissance;

	/**
	 * Constructeur
	 * 
	 */
	public Realisateur() {
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param identite
	 * @param dateNaissance
	 * @param url
	 * @param films
	 * @param lieuNaissance
	 */
	public Realisateur(String id, String identite, LocalDate dateNaissance, String url, Set<Film> films,
			Lieu lieuNaissance) {
		this.id = id;
		this.identite = identite;
		this.dateNaissance = dateNaissance;
		this.url = url;
		this.films = films;
		this.lieuNaissance = lieuNaissance;
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
	 * Getter pour identite
	 * 
	 * @return the identite
	 */
	public String getIdentite() {
		return identite;
	}

	/**
	 * Setter pour identite
	 * 
	 * @param identite the identite to set
	 */
	public void setIdentite(String identite) {
		this.identite = identite;
	}

	/**
	 * Getter pour dateNaissance
	 * 
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Setter pour dateNaissance
	 * 
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
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

	/**
	 * Getter pour lieuNaissance
	 * 
	 * @return the lieuNaissance
	 */
	public Lieu getLieuNaissance() {
		return lieuNaissance;
	}

	/**
	 * Setter pour lieuNaissance
	 * 
	 * @param lieuNaissance the lieuNaissance to set
	 */
	public void setLieuNaissance(Lieu lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	@Override
	public String toString() {
		return "Realisateur [id=" + id + ", identite=" + identite + ", dateNaissance=" + dateNaissance + "]";
	}

}
