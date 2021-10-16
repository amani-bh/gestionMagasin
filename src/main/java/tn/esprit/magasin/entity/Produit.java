package tn.esprit.magasin.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduit")
	private Long idProduit;
	private String code;
	private String libelle;
	private float prixUnitaire;

	@OneToOne
	private DetailProduit detailProduit;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Fournisseur> fournisseurs;

	@ManyToOne
	private Rayon rayon;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
	private List<DetailFacture> detailFactures;

	@ManyToOne
	private Stock stock;

	public Produit(Long idProduit, String code, String libelle, float prixUnitaire) {
		super();
		this.idProduit = idProduit;
		this.code = code;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
	}

	public Produit() {
		super();
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public DetailProduit getDetailProduit() {
		return detailProduit;
	}

	public void setDetailProduit(DetailProduit detailProduit) {
		this.detailProduit = detailProduit;
	}

	public List<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}

	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public Rayon getRayon() {
		return rayon;
	}

	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}

	public List<DetailFacture> getDetailFactures() {
		return detailFactures;
	}

	public void setDetailFactures(List<DetailFacture> detailFactures) {
		this.detailFactures = detailFactures;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((idProduit == null) ? 0 : idProduit.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + Float.floatToIntBits(prixUnitaire);
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
		Produit other = (Produit) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (idProduit == null) {
			if (other.idProduit != null)
				return false;
		} else if (!idProduit.equals(other.idProduit))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (Float.floatToIntBits(prixUnitaire) != Float.floatToIntBits(other.prixUnitaire))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", code=" + code + ", libelle=" + libelle + ", prixUnitaire="
				+ prixUnitaire + "]";
	}

}
