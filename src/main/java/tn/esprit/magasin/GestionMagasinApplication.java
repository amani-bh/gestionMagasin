package tn.esprit.magasin;

import javax.xml.ws.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.magasin.entity.Client;
import tn.esprit.magasin.repositories.IClientRepository;
import tn.esprit.magasin.services.IClientService;

@EnableSwagger2
@SpringBootApplication
public class GestionMagasinApplication {
	static IClientService  c ; 
	Client cl;
	public static void main(String[] args) {
	
		
		SpringApplication.run(GestionMagasinApplication.class, args);
		//System.out.println(	c.getByUserName("test"));
	}

}
