package tn.esprit.magasin.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idStock")
	private Long idStock;
	private int qte;
	private int qteMin;
	private String libelleStock;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
	private List<Produit> produits;

	public Stock(Long idStock, int qte, int qteMin, String libelleStock) {
		super();
		this.idStock = idStock;
		this.qte = qte;
		this.qteMin = qteMin;
		this.libelleStock = libelleStock;
	}

	public Stock() {
		super();
	}


	public Long getIdStock() {
		return idStock;
	}

	public void setIdStock(Long idStock) {
		this.idStock = idStock;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public int getQteMin() {
		return qteMin;
	}

	public void setQteMin(int qteMin) {
		this.qteMin = qteMin;
	}

	public String getLibelleStock() {
		return libelleStock;
	}

	public void setLibelleStock(String libelleStock) {
		this.libelleStock = libelleStock;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idStock == null) ? 0 : idStock.hashCode());
		result = prime * result + ((libelleStock == null) ? 0 : libelleStock.hashCode());
		result = prime * result + qte;
		result = prime * result + qteMin;
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
		Stock other = (Stock) obj;
		if (idStock == null) {
			if (other.idStock != null)
				return false;
		} else if (!idStock.equals(other.idStock))
			return false;
		if (libelleStock == null) {
			if (other.libelleStock != null)
				return false;
		} else if (!libelleStock.equals(other.libelleStock))
			return false;
		if (qte != other.qte)
			return false;
		if (qteMin != other.qteMin)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stock [idStock=" + idStock + ", qte=" + qte + ", qteMin=" + qteMin + ", libelleStock=" + libelleStock
				+ ", produits=" + produits + "]";
	}


}
