package org.vermeg.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vermeg.bookstore.model.Utilisateur;
import org.vermeg.bookstore.service.UtilisateurService;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {
	
	@Autowired
	UtilisateurService utilisateurService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(){
        return "Hello";
    }
	
	@RequestMapping(value = "/getAllUtilisateurs", method = RequestMethod.GET, produces = "application/json")
	public List<Utilisateur> getUtilisateurs() {
		
		List<Utilisateur> listOfUtilisateurs = utilisateurService.getAllUtilisateurs();
		
		return listOfUtilisateurs;
	}

	@RequestMapping(value = "/getUtilisateur/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Utilisateur getUtilisateurById(@PathVariable int id) {
		return utilisateurService.getUtilisateur(id);
	}

	@RequestMapping(value = "/addUtilisateur", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur) {	
		if(utilisateur.getId()==0)
		{
			utilisateurService.addUtilisateur(utilisateur);
		}
		else
		{	
			utilisateurService.updateUtilisateur(utilisateur);
		}
		
		return "redirect:/getAllUtilisateurs";
	}

	@RequestMapping(value = "/updateUtilisateur/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateUtilisateur(@PathVariable("id") int id,@ModelAttribute("utilisateur") Utilisateur utilisateur,Model model) {
		if(utilisateurService.getUtilisateur(id)==null)
		{
			System.out.print( "le utilisateur souhaité n'existe pas");
		}
		else
		{
			utilisateurService.updateUtilisateur(utilisateur);
			System.out.print( "modification avec succées");
		}
		return "redirect:/getAllUtilisateurs";
	}

	@RequestMapping(value = "/deleteUtilisateur/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteUtilisateur(@PathVariable("id") int id) {
		utilisateurService.deleteUtilisateur(id);
		 return "redirect:/getAllUtilisateurs";

	}	

}
