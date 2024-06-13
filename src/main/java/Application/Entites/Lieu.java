package Application.Entites;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Lieu {

//	/** id **/
//	@Id
//	@Column(name = "ID")
//	private String id;

	/** rue **/
	@Column(name = "RUE")
	private String rue;

	/** ville **/
	@Column(name = "VILLE")
	private String ville;

	/** etat **/
	@Column(name = "ETAT")
	private String etat;

	/** pays **/
	@Column(name = "PAYS")
	private String pays;

	/**
	 * Constructeur
	 * 
	 */
	public Lieu() {
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param rue
	 * @param ville
	 * @param etat
	 * @param pays
	 */
	public Lieu(String rue, String ville, String etat, String pays) {
		this.rue = rue;
		this.ville = ville;
		this.etat = etat;
		this.pays = pays;
	}

	/**
	 * Getter pour rue
	 * 
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Setter pour rue
	 * 
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
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
	 * Getter pour pays
	 * 
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * Setter pour pays
	 * 
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "Lieu [rue=" + rue + ", ville=" + ville + ", etat=" + etat + ", pays=" + pays + "]";
	}

}
