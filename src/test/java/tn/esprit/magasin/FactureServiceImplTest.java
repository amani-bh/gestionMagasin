package tn.esprit.magasin;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.magasin.services.FactureServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactureServiceImplTest {
	@Autowired
	FactureServiceImpl factureService;

}
