package Application;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "GENRE")
public class Genre {

	/** id **/
	@Id
	@Column(name = "ID")
	private String id;

	/** nom **/
	@Column(name = "NOM")
	private String nom;
	
	@ManyToMany
	@JoinTable(name = "GENRES_FILMS",
			joinColumns = @JoinColumn(name="ID_GENRE", referencedColumnName="ID"),
			inverseJoinColumns = @JoinColumn(name = "ID_FILM", referencedColumnName="ID")
	)
	private Set<Film> films = new HashSet<>();

	/**
	 * Constructeur
	 * 
	 */
	public Genre() {
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param nom
	 */
	public Genre(String id, String nom) {
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
		return "Genre [id=" + id + ", nom=" + nom + "]";
	}

}
