package fr.orsys.tp10.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.orsys.tp10.domain.Employe;
import fr.orsys.tp10.service.EmployeService;

@Controller
@RequestMapping("/employees")
public class EmployeController {
	
	private EmployeService employeService;

	@GetMapping("/list")
	public String homePage(Model model) {
		List<Employe> employees = employeService.getAllEmployees();
		
		model.addAttribute("employees", employees);
		
		return "employees";
	}
	
	@GetMapping
	public String employeById(@RequestParam("id") Long id, Model model) {
		Employe employe = employeService.getById(id);
		
		model.addAttribute("employe", employe);
		
		return "employeDetail";
	}

	@Autowired
	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}
	
}
