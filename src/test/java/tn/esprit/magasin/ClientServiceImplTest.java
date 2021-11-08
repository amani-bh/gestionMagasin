package tn.esprit.magasin;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.magasin.entity.CategorieClient;
import tn.esprit.magasin.entity.Client;
import tn.esprit.magasin.entity.Profession;
import tn.esprit.magasin.services.IClientService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceImplTest {
	@Autowired
	IClientService clientService;
	@Test
	public void testAddClient() throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy") ;
		Date dateNaissance=df.parse("02/09/1997");
		Client cl =new Client();
		//"yassine","makhlouf",dateNaissance,"yassine.makhlouf@esprit.tn","exmplepsw",Profession.Etudiant,CategorieClient.Fidele
	cl.setNom("yassine");
	cl.setPrenom("makhlouf");
	cl.setDateNaissance(dateNaissance);
	cl.setEmail("yassine.makhlouf@esprit.tn");
	cl.setPassword("sfsdjfo");
	cl.setProfession(Profession.Etudiant);
	cl.setCategorieClient(CategorieClient.Fidele);
	Client cl1=clientService.addClient(cl);
	assertNotNull(cl1.getIdClient());
	assertNotNull(cl1.getCategorieClient());
	assertNotNull(cl1.getProfession());
	assertTrue(cl1.getNom().length()>0);
	assertTrue(cl1.getPrenom().length()>0);
	assertTrue(cl1.getPassword().length()>0);
	clientService.deleteClient(cl1.getIdClient());
	
	}

	@Test
	public void TestDeleteClient() throws ParseException {
		Client cl =new Client();
		cl.setNom("yassine");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy") ;
		Date dateNaissance=df.parse("02/09/1997");
		cl.setPrenom("makhlouf");
		cl.setDateNaissance(dateNaissance);
		cl.setEmail("yassine.makhlouf@esprit.tn");
		cl.setPassword("sfsdjfo");
		cl.setProfession(Profession.Etudiant);
		cl.setCategorieClient(CategorieClient.Fidele);
		Client cl1=clientService.addClient(cl);
		clientService.deleteClient(cl1.getIdClient());
		Client delCl =clientService.retrieveClient(cl1.getIdClient());
		assertNull(delCl);
	}
}
