package in.nit.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.nit.healthcare.entity.Specialization;
import in.nit.healthcare.service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {

	@Autowired
	private ISpecializationService service;
	
	@GetMapping("/register")
	public String displaySpecRegister() {
		return "SpecializationRegister";
	}
	
	@PostMapping("/create-spec")
	public String saveSpecialization(@ModelAttribute Specialization specialization,
			                                         Model map) {
		Long id=service.saveSpecialization(specialization);
		String message="Specialization created with id: "+id+" Successfully";
		map.addAttribute("message", message);
		return "SpecializationRegister";
	}
	
	//display all specialization
	@GetMapping("/all")
	public String displayAllSpecialization(@RequestParam(value="message", required=false) String message, Model map) {
		List<Specialization> splList=service.getAllSpecialization();
		map.addAttribute("splList", splList);
		map.addAttribute("message", message);
		
		return "SpecializationAll";
	}
	
	//delete specialization
	@GetMapping("/delete")
	public String deleteSpecialization(@RequestParam Long id, RedirectAttributes attributes) {
		service.deleteSpecialization(id);
		attributes.addAttribute("message", "Successfully Deleted");
		return "redirect:all";
		
	}
	
	//update specialization
	
	public String updateSpecialization(@ModelAttribute Specialization specialization, RedirectAttributes attribute) {
		//use service
		service.updateSpecialization(specialization);
		attribute.addAttribute("message", "Successfully Updated");
		return "redirect:all";
	}
	
}	

