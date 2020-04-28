package projetFormation.entity;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "person")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_person", initialValue = 100, allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPersonne")
	@Column(name = "id_person")
	private Integer id;
	@Column(name = "first_name", length = 150, nullable = false)
	private String prenom;
	@Column(name = "last_name", length = 150, nullable = false)
	private String nom;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "dateInscription", column = @Column(name = "inscription_date_person", nullable = false)),
			@AttributeOverride(name = "mail", column = @Column(name = "mail_person", nullable = false)),
			@AttributeOverride(name = "motdePasse", column = @Column(name = "password_person", length = 50, nullable = false)) })
	private Inscription inscription;
	@Column(name = "title", length = 4)
	@Enumerated(EnumType.STRING)
	private Civilite civilite;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "number_person")),
			@AttributeOverride(name = "rue", column = @Column(name = "street_person", length = 200)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "zip_code_person", length = 20)),
			@AttributeOverride(name = "ville", column = @Column(name = "city_person", length = 150)) })
	private Adresse adresse;
	@OneToMany(mappedBy = "personne")
	private List<Avis> avis;
	@Version
	private int version;

	public Personne() {
	}

	public Personne(String prenom, String nom, Inscription inscription) {
		this.prenom = prenom;
		this.nom = nom;
		this.inscription = inscription;
	}


	public Personne(String prenom, String nom, Inscription inscription, Civilite civilite) {
		this.prenom = prenom;
		this.nom = nom;
		this.inscription = inscription;
		this.civilite = civilite;
	}

	
	public Personne(String prenom, String nom, Inscription inscription, Adresse adresse) {
		this.prenom = prenom;
		this.nom = nom;
		this.inscription = inscription;
		this.adresse = adresse;
	}

	
	public Personne(String prenom, String nom, Inscription inscription, Civilite civilite, Adresse adresse) {
		this.prenom = prenom;
		this.nom = nom;
		this.inscription = inscription;
		this.civilite = civilite;
		this.adresse = adresse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
	
}
