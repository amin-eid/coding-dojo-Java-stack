package com.codingdojo.driverLicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.driverLicense.models.License;
import com.codingdojo.driverLicense.models.Person;
import com.codingdojo.driverLicense.services.LicenseService;
import com.codingdojo.driverLicense.services.PersonService;

@Controller
public class LicenseController {
	private final LicenseService licenseService;
	
	public LicenseController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}

	@Autowired
	private PersonService personService;
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons", persons);
		return "newLicense.jsp";
	}
	@RequestMapping("/licenses")
    public String index(Model model) {
        List<License> licenses = licenseService.alllicenses();
        model.addAttribute("licenses", licenses);
        return "/showlic.jsp";
    }
	@RequestMapping(value="/licenses", method=RequestMethod.POST)
	public String addlicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "newLicense.jsp";
		}
		else {
			String number = licenseService.generateLicenseNumber();
			license.setNumber(number);
			licenseService.addLicense(license);
			return "redirect:/licenses";
		}
	}
}