package projetFormation.entity;

import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class Inscription {
	private LocalDate dateInscription;
	private String mail;
	private String motdePasse;
	
	
	public Inscription() {
	}


	public Inscription(LocalDate dateInscription, String mail, String motdePasse) {
		this.dateInscription = dateInscription;
		this.mail = mail;
		this.motdePasse = motdePasse;
	}

	public Inscription(String mail, String motdePasse) {
		this.dateInscription = LocalDate.now();
		this.mail = mail;
		this.motdePasse = motdePasse;
	}



	public LocalDate getDateInscription() {
		return dateInscription;
	}



	public void setDateInscription(LocalDate dateInscription) {
		this.dateInscription = dateInscription;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getMotdePasse() {
		return motdePasse;
	}



	public void setMotdePasse(String motdePasse) {
		this.motdePasse = motdePasse;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((motdePasse == null) ? 0 : motdePasse.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inscription other = (Inscription) obj;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (motdePasse == null) {
			if (other.motdePasse != null)
				return false;
		} else if (!motdePasse.equals(other.motdePasse))
			return false;
		return true;
	}
	
	
	
	
	
}
