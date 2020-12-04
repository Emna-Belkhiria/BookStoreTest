package org.vermeg.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vermeg.bookstore.model.Achat;
import org.vermeg.bookstore.service.AchatService;

@RestController
@RequestMapping("/api/achat")
public class AchatController {
	
	@Autowired
	AchatService achatService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(){
        return "Hello";
    }
	
	@RequestMapping(value = "/getAllAchats/{idor}", method = RequestMethod.GET,headers = "Accept=application/json")
	public List<Achat> getAchats(@PathVariable int idor) {
		
		List<Achat> listOfAchats = achatService.getAllAchats(idor);
		achatService.calculeTotal(listOfAchats);
		
		return listOfAchats;
	}

	@RequestMapping(value = "/getAchat/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Achat getAchatById(@PathVariable int id) {
		return achatService.getAchat(id);
	}

	@RequestMapping(value = "/addAchat", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addAchat(@ModelAttribute("achat") Achat achat) {	
		if(achat.getNumLigne()==0)
		{
			achatService.addAchat(achat);
		}
		else
		{	
			achatService.updateAchat(achat);
		}
		
		return "redirect:/getAllAchats";
	}

	@RequestMapping(value = "/updateAchat/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateAchat(@PathVariable("id") int id,@ModelAttribute("achat") Achat achat,Model model) {
		if(achatService.getAchat(id)==null)
		{
			System.out.print( "le achat souhaité n'existe pas");
		}
		else
		{
			achatService.updateAchat(achat);
			System.out.print( "modification avec succées");
		}
		return "redirect:/getAllAchats";
	}

	@RequestMapping(value = "/deleteAchat/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteAchat(@PathVariable("id") int id) {
		achatService.deleteAchat(id);
		 return "redirect:/getAllAchats";

	}	

}
