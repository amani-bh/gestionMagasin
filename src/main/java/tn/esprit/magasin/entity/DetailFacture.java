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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private int pourcentageRemise;
	private float prixTotal;
	private float montantRemise;
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Produit produit;
	
	@ManyToOne
	@JsonIgnore
	private Facture facture;

	public DetailFacture() {
		super();
	}

}
