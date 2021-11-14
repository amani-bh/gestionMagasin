package tn.esprit.magasin.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class DetailProduit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetailProduit")
	private Long idDetailProduit;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Temporal(TemporalType.DATE)
	private Date DerniereModification;
	private CategorieProduit categorieProduit;

	@OneToOne(mappedBy = "detailProduit")
	private Produit produit;

}
