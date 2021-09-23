package in.nit.healthcare.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.nit.healthcare.entity.Doctor;
import in.nit.healthcare.exception.DoctorNotFoundException;
import in.nit.healthcare.service.IDoctorService;
import in.nit.healthcare.service.ISpecializationService;
import in.nit.healthcare.utility.FileUploadUtil;
import in.nit.healthcare.utility.convertListToMapUtil;

@Controller
@RequestMapping("/doc")
public class DoctorController {
	@Autowired
	private IDoctorService service;
	@Autowired
	private ISpecializationService specService;



	//  1. display doctor register page;

	@GetMapping("/register")
	public String displayRegister(Model map) {
    //System.out.println(specService.getSpecNameAndCode());
		map.addAttribute("specMap", specService.getSpecNameAndCode());
		return "DoctorRegister";
	}


	// 2. display all page;
	@GetMapping("/all")
	public String displayAll(Model map, @RequestParam(required = false) String message ) {
		map.addAttribute("list", service.fetchAllDoctor());
		map.addAttribute("message", message);
		return "DoctorAll";
	}

	@PostMapping("/create-doc")
	public String save(@ModelAttribute Doctor doctor,@RequestParam("docImg") MultipartFile multipartFile, Model map, RedirectAttributes attributes) {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

		doctor.setPhotos(fileName);

		Long id=service.saveDoctor(doctor);

		map.addAttribute("message", "Doctor created with ID: "+id);
		attributes.addAttribute("message", "Doctor created with ID: "+id);

		String uploadDir="user-photos/" + id;
		try {
			FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:all";
	}

	@GetMapping("/edit")
	public String displayEdit(@RequestParam Long id, Model map, RedirectAttributes attributes) {
		try {
			map.addAttribute("doctor", service.fetchDoctor(id));
			return "DoctorEdit";
		} catch (DoctorNotFoundException e) {
			attributes.addAttribute("message", e.getMessage());
			return "redirect:all";
		}

	}
	@PostMapping("/update")
	public String doctorUpdateAndRedirectAll(@ModelAttribute Doctor doctor, RedirectAttributes attributes) {
		service.updateDoctor(doctor);
		String message="Doctor("+doctor.getId()+")"+" "+"Updated Successfully";
		attributes.addAttribute("message", message);

		return "redirect:all";
	}

	@GetMapping("/delete")
	public String doctorDelete(@RequestParam Long id, RedirectAttributes attributes) {
		try {
			service.deleteDoctor(id);
			attributes.addAttribute("message", "Doctor("+id+") deleted successfully");
		} catch (DoctorNotFoundException e) {
			attributes.addAttribute("message", e.getMessage());
		}
		return "redirect:all";
	}

	//	check docName ajax validations
	@GetMapping("/check-doc-name")
	public @ResponseBody boolean docNameAjax(@RequestParam String docName) {
		return service.isDocNameExist(docName);
	}

	@GetMapping("/check-doc-addr")
	public @ResponseBody boolean docAddrAjax(@RequestParam String docAddr) {
		return service.isDocAddrExist(docAddr);
	}
}
