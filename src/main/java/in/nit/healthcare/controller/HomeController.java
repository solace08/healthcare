package in.nit.healthcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	//display home page
	@RequestMapping(value= {"/","healthcareapp"}, method=RequestMethod.GET)
	public String displayHealthCareHome() {
		return "index";
	}
}
