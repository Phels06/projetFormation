package projetFormation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "opinion")
@SequenceGenerator(name = "seqAvis", sequenceName = "seq_opinion", initialValue = 100, allocationSize = 1)
public class Avis {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAvis")
	@Column(name = "id_opinion")
	private Integer id;
	@Lob
	@Column(name = "opinion_dog_handler")
	private String avisMaitre;
	@ManyToOne
	@JoinColumn(name="id_person",foreignKey=@ForeignKey(name="opinion_personne_fk"))
	private Personne personne;

	public Avis() {
	}
	
	public Avis(Integer id, String avisMaitre) {
		this.id = id;
		this.avisMaitre = avisMaitre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAvisMaitre() {
		return avisMaitre;
	}

	public void setAvisMaitre(String avisMaitre) {
		this.avisMaitre = avisMaitre;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	
}
