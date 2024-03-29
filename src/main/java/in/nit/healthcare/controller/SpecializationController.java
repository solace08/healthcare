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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.nit.healthcare.entity.Specialization;
import in.nit.healthcare.exceptions.SpecializationNotFoundException;
import in.nit.healthcare.service.ISpecializationService;
import in.nit.healthcare.view.SpecializationExcelView;

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
		try {
			service.deleteSpecialization(service.getOneSpecialization(id));
			attributes.addAttribute("message", "Successfully Deleted");
		} catch (SpecializationNotFoundException e) {
			attributes.addAttribute("message", e.getMessage()); 
		}
		return "redirect:all";

	}

	//update specialization

	@PostMapping("/update")
	public String updateSpecialization(@ModelAttribute Specialization specialization, RedirectAttributes attribute) {
		//use service
		service.updateSpecialization(specialization);
		attribute.addAttribute("message", "Successfully Updated");
		return "redirect:all";
	}

	//show edit specialization page;

	@GetMapping("/edit")
	public String showSpecEdit(@RequestParam Long id, Model map, RedirectAttributes attribute) {
		String page="";
		//map.addAttribute("specialization", service.getOneSpecialization(id));
		try {
			page="SpecializationEdit";
			map.addAttribute("specialization", service.getOneSpecialization(id));
			return page;
		} catch (SpecializationNotFoundException e) {
			//page="redirect:all";
			attribute.addAttribute("message", e.getMessage());
			return "redirect:all";

		}

	}

	// asynchronous response controller method
	@GetMapping("/check-spec-code")

	public @ResponseBody String ajaxSpecCode(@RequestParam String specCode, @RequestParam Long id) {
		String message="";
		if(id!=0 && service.isSpecCodeExistEdit(specCode, id)) return message+"**Code Already Exist";
			
		else if(id==0 && service.isSpecCodeExist(specCode)) return message+"**Code Already Exist";

		
		return message;
	}

	@GetMapping("/check-spec-name")
	public @ResponseBody String ajaxSpecName(@RequestParam String specName, @RequestParam Long id) {
		String message="";
		if(id==0 && service.isSpecNameExist(specName)) return message+"**Name Already Exist";
	
		else if(id!=0 && service.isSpecNameExistEdit(specName,id)) return message+"**Name Already Exist";
		return message;
	}

	//	Specialization excel export
	@GetMapping("/excel")
	public ModelAndView excelExport(ModelAndView mav) {
		mav.addObject("splList", service.getAllSpecialization());
		mav.setView((View) new SpecializationExcelView());
		return mav;
	}

}	

