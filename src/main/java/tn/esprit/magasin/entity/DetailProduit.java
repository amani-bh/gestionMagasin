package tn.esprit.magasin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DetailProduit implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetailProduit")
	private Long idDetailProduit;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Temporal(TemporalType.DATE)
	private Date  DerniereModification;
	private CategorieProduit categorieProduit;
	
	
	public DetailProduit(Long idDetailProduit, Date dateCreation, Date derniereModification,
			CategorieProduit categorieProduit) {
		super();
		this.idDetailProduit = idDetailProduit;
		this.dateCreation = dateCreation;
		DerniereModification = derniereModification;
		this.categorieProduit = categorieProduit;
	}
	
	
	
	public DetailProduit() {
		super();
	}



	public Long getIdDetailProduit() {
		return idDetailProduit;
	}
	public void setIdDetailProduit(Long idDetailProduit) {
		this.idDetailProduit = idDetailProduit;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDerniereModification() {
		return DerniereModification;
	}
	public void setDerniereModification(Date derniereModification) {
		DerniereModification = derniereModification;
	}
	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}
	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DerniereModification == null) ? 0 : DerniereModification.hashCode());
		result = prime * result + ((categorieProduit == null) ? 0 : categorieProduit.hashCode());
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((idDetailProduit == null) ? 0 : idDetailProduit.hashCode());
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
		DetailProduit other = (DetailProduit) obj;
		if (DerniereModification == null) {
			if (other.DerniereModification != null)
				return false;
		} else if (!DerniereModification.equals(other.DerniereModification))
			return false;
		if (categorieProduit != other.categorieProduit)
			return false;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (idDetailProduit == null) {
			if (other.idDetailProduit != null)
				return false;
		} else if (!idDetailProduit.equals(other.idDetailProduit))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DetailProduit [idDetailProduit=" + idDetailProduit + ", dateCreation=" + dateCreation
				+ ", DerniereModification=" + DerniereModification + ", categorieProduit=" + categorieProduit + "]";
	}
	
	
	

}
