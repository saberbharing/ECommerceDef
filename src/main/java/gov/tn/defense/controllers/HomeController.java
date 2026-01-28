package gov.tn.defense.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller + @ResponseBody
@RestController
public class HomeController {

	@GetMapping("/hello")
	public String sayHello(@RequestParam(name = "n", 
			required = false, 
			defaultValue = "world") String nom)
	{
		return "Hello "+ nom + " !";
	}
	
	@PostMapping("/bye/{prenom}/{nom}")
	public String sayBye(@PathVariable String nom, 
			@PathVariable String prenom)
	{
		return "Bye "+ prenom + " " + nom + " !";
	}
	
	
	
}
