package tn.esprit.magasin.entities;

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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;
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

	
}
