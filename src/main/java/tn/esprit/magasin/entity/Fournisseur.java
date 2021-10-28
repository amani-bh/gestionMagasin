package tn.esprit.magasin.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fournisseur implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFournisseur")
	private Long idFournisseur;
	private String code;
	private String libelle;
	
	
	public Fournisseur(Long idFournisseur, String code, String libelle) {
		super();
		this.idFournisseur = idFournisseur;
		this.code = code;
		this.libelle = libelle;
	}
	
	
	
	public Fournisseur() {
		super();
	}



	public Long getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(Long idFournisseur) {
		this.idFournisseur = idFournisseur;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((idFournisseur == null) ? 0 : idFournisseur.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
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
		Fournisseur other = (Fournisseur) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (idFournisseur == null) {
			if (other.idFournisseur != null)
				return false;
		} else if (!idFournisseur.equals(other.idFournisseur))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Fournisseur [idFournisseur=" + idFournisseur + ", code=" + code + ", libelle=" + libelle + "]";
	}
	
	
	
}
