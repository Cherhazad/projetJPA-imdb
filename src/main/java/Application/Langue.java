package Application;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LANGUE")
public class Langue {

	/** id **/
	@Id
	@Column(name = "ID")
	private String id;

	/** nom **/
	@Column(name = "NOM")
	private String nom;

	/**
	 * Constructeur
	 * 
	 */
	public Langue() {
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param nom
	 */
	public Langue(String id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
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

	@Override
	public String toString() {
		return "Langue [id=" + id + ", nom=" + nom + "]";
	}

}
