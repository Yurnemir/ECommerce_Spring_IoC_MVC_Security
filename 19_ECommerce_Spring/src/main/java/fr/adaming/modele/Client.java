package fr.adaming.modele;

/**
 * Classe repr�sentant un client qui sera enregistr� dans la base.
 * Elle poss�de les attributs suivants : 
 * <ul>
 * <li> idClient : Un identifiant dans la base de donn�es. int
 * <li> nomClient : Le nom du client String
 * <li> adresse : L'adresse du client String
 * <li> email : L'adresse mail du client String
 * <li> tel : Le num�ro de t�l�phine du client. String
 * <li> codePerso : Un code personel fourni par le site au client pour ses commandes futures String
 * </ul>
 */
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="clients")
public class Client {

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_client")
	private int idClient;
	private String nomClient;
	private String adresse;
	private String email;
	private String tel;
	private String codePerso;
	
	// Association avec Commande
	@OneToMany(mappedBy="client")
	private List<Commande> commandes;
	
	
	// Constructeurs
	public Client() {
		super();
	}
	
	public Client(String nomClient, String adresse, String email, String tel, String codePerso) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.codePerso = codePerso;
	}
	
	public Client(int idClient, String nomClient, String adresse, String email, String tel, String codePerso) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.codePerso = codePerso;
	}

	// Getters/Setters

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	

	public String getCodePerso() {
		return codePerso;
	}

	public void setCodePerso(String codePerso) {
		this.codePerso = codePerso;
	}

	
	
	
	// toString

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", adresse=" + adresse + ", email=" + email
				+ ", tel=" + tel + ", codePerso=" + codePerso + "]";
	}
	
	




	
}
