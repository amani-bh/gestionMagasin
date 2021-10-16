package tn.esprit.magasin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Facture implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFacture")
	private Long idFacture;
	private float montantRemise;
	private float montantFacture;
	@Temporal(TemporalType.DATE)
	private Date dateFacture;
	private Boolean active;

	@ManyToOne
	private Client client;

	public Facture(Long idFacture, float montantRemise, float montantFacture, Date dateFacture, Boolean active) {
		super();
		this.idFacture = idFacture;
		this.montantRemise = montantRemise;
		this.montantFacture = montantFacture;
		this.dateFacture = dateFacture;
		this.active = active;
	}

	public Facture() {
		super();
	}

	public Long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}

	public float getMontantRemise() {
		return montantRemise;
	}

	public void setMontantRemise(float montantRemise) {
		this.montantRemise = montantRemise;
	}

	public float getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(float montantFacture) {
		this.montantFacture = montantFacture;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((dateFacture == null) ? 0 : dateFacture.hashCode());
		result = prime * result + ((idFacture == null) ? 0 : idFacture.hashCode());
		result = prime * result + Float.floatToIntBits(montantFacture);
		result = prime * result + Float.floatToIntBits(montantRemise);
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
		Facture other = (Facture) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (dateFacture == null) {
			if (other.dateFacture != null)
				return false;
		} else if (!dateFacture.equals(other.dateFacture))
			return false;
		if (idFacture == null) {
			if (other.idFacture != null)
				return false;
		} else if (!idFacture.equals(other.idFacture))
			return false;
		if (Float.floatToIntBits(montantFacture) != Float.floatToIntBits(other.montantFacture))
			return false;
		if (Float.floatToIntBits(montantRemise) != Float.floatToIntBits(other.montantRemise))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", montantRemise=" + montantRemise + ", montantFacture="
				+ montantFacture + ", dateFacture=" + dateFacture + ", active=" + active + "]";
	}

}
