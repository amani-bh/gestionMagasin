package tn.esprit.magasin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.magasin.entity.Produit;
import tn.esprit.magasin.entity.Rayon;
import tn.esprit.magasin.services.IRayonService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "Gestion de rayon ")
@RequestMapping("/rayon")
public class RayonRestController {
	@Autowired
	IRayonService rayonService;

	// http://localhost:8082/SpringMVC/rayon/retrieve-all-rayons
	@GetMapping("/retrieve-all-rayons")
	@ApiOperation(value = "Récupérer la liste des rayons")
	@ResponseBody
	public List<Rayon> getRayons() {
		List<Rayon> listRayons = rayonService.retrieveAllRayons();
		return listRayons;
	}

	// http://localhost:8082/SpringMVC/rayon/retrieve-rayon/1
	@GetMapping("/retrieve-rayon/{rayon-id}")
	@ApiOperation(value = "Récupérer un rayon par id")
	@ResponseBody
	public Rayon retrieveRayon(@PathVariable("rayon-id") Long rayonId) {
		return rayonService.retrieveRayon(rayonId);
	}

	// http://localhost:8082/SpringMVC/rayon/add-rayon
	@PostMapping("/add-rayon")
	@ApiOperation(value = "Ajouter un rayon")
	@ResponseBody
	public Rayon addRayon(@RequestBody Rayon r) {
		Rayon rayon = rayonService.addRayon(r);
		return rayon;
	}

	// http://localhost:8082/SpringMVC/rayon/remove-rayon/{rayon-id}
	@DeleteMapping("/remove-rayon/{rayon-id}")
	@ApiOperation(value = "Supprimer un rayon")
	@ResponseBody
	public void removeRayon(@PathVariable("rayon-id") Long rayonId) {
		rayonService.deleteRayon(rayonId);
	}

	// http://localhost:8082/SpringMVC/rayon/modify-rayon
	@PutMapping("/modify-rayon")
	@ApiOperation(value = "Modifier un rayon")
	@ResponseBody
	public Rayon modifyRayon(@RequestBody Rayon rayon) {
		return rayonService.updateRayon(rayon);
	}
	
	// http://localhost:8082/SpringMVC/rayon/rayon-produit/1
		@GetMapping("/rayon-produit/{produit-id}")
		@ApiOperation(value = "Récupérer un rayon par produit")
		@ResponseBody
		Rayon RayonByProduit(@PathVariable("produit-id") Long idProduit) {
			return rayonService.RayonByProduit(idProduit);
		}
		
		// http://localhost:8082/SpringMVC/rayon/produits-id-rayon/2
		@GetMapping("/produits-id-rayon/{rayon-id}")
		@ApiOperation(value = "Récupérer liste de produits par idRayon")
		@ResponseBody
		public List<Produit> RayonByIdProduit(@PathVariable("rayon-id")Long idRayon) {
			return rayonService.RayonByIdProduit(idRayon);
		}
}