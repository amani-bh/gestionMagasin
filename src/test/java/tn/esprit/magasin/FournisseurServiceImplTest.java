package tn.esprit.magasin;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.magasin.entity.Fournisseur;
import tn.esprit.magasin.services.IFournisseurService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FournisseurServiceImplTest  {
	@Autowired
	IFournisseurService fournisseurService;
	@Test
	public void testAddFournisseur() throws ParseException {
Fournisseur f1 =new Fournisseur();
f1.setCode("45ezae5");
f1.setLibelle("Libelle1azeza");
Fournisseur fr= fournisseurService.addFournisseur(f1);
assertNotNull(fr.getIdFournisseur());
assertNotNull(fr.getCode());
assertNotNull(fr.getLibelle());
assertTrue(fr.getIdFournisseur()>0);
assertTrue(fr.getCode().length()>0);
assertTrue(fr.getLibelle().length()>0);
fournisseurService.deleteFournisseur(fr.getIdFournisseur());
		
	}
	@Test
	public void TestDeleteFournisseur() throws ParseException {
		Fournisseur f1 =new Fournisseur();
		f1.setCode("45ezae5");
		f1.setLibelle("Libelle1azeza");
		Fournisseur fr= fournisseurService.addFournisseur(f1);
		fournisseurService.deleteFournisseur(fr.getIdFournisseur());
		Fournisseur delFr=fournisseurService.retrieveFournisseur(fr.getIdFournisseur());
		assertNull(delFr);
	}

}
