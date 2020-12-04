package org.vermeg.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vermeg.bookstore.model.DocumentAchat;
import org.vermeg.bookstore.service.DocumentAchatService;

@RestController
@RequestMapping("/api/documentDocumentAchat")
public class DocumentAchatController {
	
	@Autowired
	DocumentAchatService documentAchatService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(){
        return "Hello";
    }
	
	@RequestMapping(value = "/getAllDocumentAchats", method = RequestMethod.GET, produces = "application/json")
	public List<DocumentAchat> getDocumentAchats(@PathVariable int iduser) {
		
		List<DocumentAchat> listOfDocumentAchats = documentAchatService.getAllDocumentAchats(iduser);
		
		return listOfDocumentAchats;
	}

	@RequestMapping(value = "/getDocumentAchat/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public DocumentAchat getDocumentAchatById(@PathVariable int id) {
		return documentAchatService.getDocumentAchat(id);
	}

	@RequestMapping(value = "/addDocumentAchat", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addDocumentAchat(@ModelAttribute("documentAchat") DocumentAchat documentAchat) {	
		if(documentAchat.getId()==0)
		{
			documentAchatService.addDocumentAchat(documentAchat);
		}
		else
		{	
			documentAchatService.updateDocumentAchat(documentAchat);
		}
		
		return "redirect:/getAllDocumentAchats";
	}

	@RequestMapping(value = "/updateDocumentAchat/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateDocumentAchat(@PathVariable("id") int id,@ModelAttribute("documentAchat") DocumentAchat documentAchat,Model model) {
		if(documentAchatService.getDocumentAchat(id)==null)
		{
			System.out.print( "le documentAchat souhaité n'existe pas");
		}
		else
		{
			documentAchatService.updateDocumentAchat(documentAchat);
			System.out.print( "modification avec succées");
		}
		return "redirect:/getAllDocumentAchats";
	}

	@RequestMapping(value = "/deleteDocumentAchat/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteDocumentAchat(@PathVariable("id") int id) {
		documentAchatService.deleteDocumentAchat(id);
		 return "redirect:/getAllDocumentAchats";

	}	

}
