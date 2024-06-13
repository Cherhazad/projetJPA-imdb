package Application.Entites;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ACTEUR")
public class Acteur {

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

	/** taille **/
	@Column(name = "TAILLE")
	private double taille; // pas sûre de ce type, faut il retirer le m et et faire des double ?

	/** url **/
	@Column(name = "URL")
	private String url;
	
	@ManyToMany
	@JoinTable(name = "CASTING_PRINCIPAL",
			joinColumns = @JoinColumn(name="ID_ACTEURS", referencedColumnName="ID"),
			inverseJoinColumns = @JoinColumn(name = "ID_FILM", referencedColumnName="ID")
	)
	private Set<Film> films = new HashSet<>();
	
	@OneToMany(mappedBy = "acteurs") 
	private Set<Role> roles = new HashSet<>();
	
	
	/** lieux **/
	@Embedded
	private Lieu lieux;

	/**
	 * Constructeur
	 * 
	 */
	public Acteur() {
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param identite
	 * @param dateNaissance
	 * @param taille
	 * @param url
	 */
	public Acteur(String id, String identite, LocalDate dateNaissance, double taille, String url) {
		this.id = id;
		this.identite = identite;
		this.dateNaissance = dateNaissance;
		this.taille = taille;
		this.url = url;
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
	 * Getter pour taille
	 * 
	 * @return the taille
	 */
	public double getTaille() {
		return taille;
	}

	/**
	 * Setter pour taille
	 * 
	 * @param taille the taille to set
	 */
	public void setTaille(double taille) {
		this.taille = taille;
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

	@Override
	public String toString() {
		return "Acteur [id=" + id + ", identite=" + identite + "]";
	}

	/** Getter pour films
	 * @return the films
	 */
	public Set<Film> getFilms() {
		return films;
	}

	/** Setter pour films
	 * @param films the films to set
	 */
	public void setFilms(Set<Film> films) {
		this.films = films;
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
