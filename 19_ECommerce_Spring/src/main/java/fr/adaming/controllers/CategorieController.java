package fr.adaming.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.modele.Categorie;
import fr.adaming.modele.Produit;
import fr.adaming.service.IServiceCategorie;

@Controller
@RequestMapping(value="/admin/categorie")
public class CategorieController {
	@Autowired
	private IServiceCategorie categrieService;
	
	public void setCategrieService(IServiceCategorie categrieService) {
		this.categrieService = categrieService;
	}
	
	/* ========================== Affichage ========================== */
	@RequestMapping(value="/recap", method=RequestMethod.GET)
	public ModelAndView afficherRecap() {
		List<Categorie> categories = categrieService.listerCategorie();
		return new ModelAndView("categorie_recap", "categories", categories);
	}
	@RequestMapping(value="/ajout", method=RequestMethod.GET)
	public ModelAndView afficherFormAjout() {
		return new ModelAndView("categorie_ajout", "categorie", new Categorie());
	}

	/* ========================== Actions ========================== */
	@RequestMapping(value="/ajouterCategorie", method=RequestMethod.POST)
	public String soumettreFormAjout(Model model, @Valid @ModelAttribute("categorie") Categorie categorie, BindingResult result) {
		if(result.hasErrors()) {
			return "categorie_ajout";
		}
		categrieService.ajouterCategorie(categorie);
		List<Categorie> categories = categrieService.listerCategorie();
		model.addAttribute("categories", categories);
		return "categorie_recap";
	}
	@RequestMapping(value="/modifierCategorie", method=RequestMethod.POST)
	public String soumettreFormModif(Model model, @Valid @ModelAttribute("categorie") Categorie categorie, BindingResult result) {
		if(result.hasErrors()) {
			return "categorie_modif";
		}
		categrieService.modifierCategorie(categorie);
		List<Categorie> categories = categrieService.listerCategorie();
		model.addAttribute("categories", categories);
		return "categorie_recap";
	}

	/* ========================== Actions via lien ========================== */
	@RequestMapping(value="/modifViaLien", method=RequestMethod.GET)
	public String affichageFormulaireModificationViaLien(Model model, @RequestParam("pId") int id) {
		Categorie cIn = new Categorie();
		cIn.setIdCategorie(id);
		cIn = categrieService.rechercherCategorieParId(cIn);
		model.addAttribute("categorie", cIn);
		List<Categorie> categories = categrieService.listerCategorie();
		model.addAttribute("categories", categories);
		return "categorie_modif";
	}
	@RequestMapping(value="/supprViaLien/{pId}", method=RequestMethod.GET)
	public String supprViaLink(Model model, @PathVariable("pId") int id) {
		Categorie cIn = new Categorie();
		cIn.setIdCategorie(id);
		cIn = categrieService.rechercherCategorieParId(cIn);
		categrieService.supprimerCategorie(cIn);
		List<Categorie> categories = categrieService.listerCategorie();
		model.addAttribute("categories", categories);
		return "categorie_recap";
	}
}
