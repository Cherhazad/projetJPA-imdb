package Application;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAYS")
public class Pays {

	/** id **/
	@Id
	@Column(name = "ID")
	private String id;

	/** nom **/
	@Column(name = "NOM")
	private String nom;

	/** url **/
	@Column(name = "URL")
	private String url;

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
	public Pays(String id, String nom, String url) {
		super();
		this.id = id;
		this.nom = nom;
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

	@Override
	public String toString() {
		return "Pays [id=" + id + ", nom=" + nom + "]";
	}

}
