package tn.esprit.magasin.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class DetailFacture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetailFacture")
	private Long idDetailFacture;
	private int qte;
	private float prixTotal;
	private int pourcentageRemise;
	private float montantRemise;

	@ManyToOne
	private Produit produit;
	@ManyToOne
	private Facture facture;

	public DetailFacture() {
		super();
	}

}
