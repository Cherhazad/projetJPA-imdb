package Application;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role {

	/** id **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private String id;

	/** personnage **/
	@Column(name = "PERSONNAGE")
	private String personnage;

	/**
	 * Constructeur
	 * 
	 */
	public Role() {
	}

	/**
	 * Constructeur
	 * 
	 * @param personnage
	 */
	public Role(String personnage) {
		this.personnage = personnage;
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
	 * Getter pour personnage
	 * 
	 * @return the personnage
	 */
	public String getPersonnage() {
		return personnage;
	}

	/**
	 * Setter pour personnage
	 * 
	 * @param personnage the personnage to set
	 */
	public void setPersonnage(String personnage) {
		this.personnage = personnage;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", personnage=" + personnage + "]";
	}

}
