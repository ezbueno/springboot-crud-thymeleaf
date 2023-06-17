package com.buenoezandro.crud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.buenoezandro.crud.dtos.EmployeeRecord;
import com.buenoezandro.crud.entities.Employee;
import com.buenoezandro.crud.services.EmployeeService;

@Controller
public class EmployeeController {
	private static final String MESSAGE = "message";
	private static final String REDIRECT_VIEW_EMPLOYEES = "redirect:/viewEmployees";

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping(value = { "/", "/viewEmployees" })
	public String viewEmployees(String message, Model model) {
		model.addAttribute("empList", this.employeeService.getAllEmployees());
		model.addAttribute(MESSAGE, message);
		return REDIRECT_VIEW_EMPLOYEES;
	}

	@GetMapping(value = "/addEmployee")
	public String newEmployee(@ModelAttribute(value = MESSAGE) String message, Model model) {
		model.addAttribute("emp", new Employee());
		model.addAttribute(MESSAGE, message);
		return "addEmployee";
	}

	@PostMapping(value = "/saveEmployee")
	public String saveEmployee(EmployeeRecord employeeRecord, RedirectAttributes redirectAttributes) {
		if (this.employeeService.saveOrUpdateEmployee(employeeRecord)) {
			redirectAttributes.addFlashAttribute(MESSAGE, "Save Success");
			return REDIRECT_VIEW_EMPLOYEES;
		}
		redirectAttributes.addFlashAttribute(MESSAGE, "Save Failure");
		return "redirect:/addEmployee";
	}

	@GetMapping(value = "/editEmployee/{id}")
	public String editEmployee(@PathVariable(value = "id") Integer id, String message, Model model) {
		model.addAttribute("emp", this.employeeService.getEmployeeById(id));
		model.addAttribute(MESSAGE, message);
		return "editEmployee";
	}

	@PostMapping(value = "/editSaveEmployee")
	public String editSaveEmployee(EmployeeRecord employeeRecord, RedirectAttributes redirectAttributes) {
		if (this.employeeService.saveOrUpdateEmployee(employeeRecord)) {
			redirectAttributes.addFlashAttribute(MESSAGE, "Edit Success");
			return REDIRECT_VIEW_EMPLOYEES;
		}
		redirectAttributes.addFlashAttribute(MESSAGE, "Edit Failure");
		return "redirect:/editEmployee/" + employeeRecord.id();
	}

	@GetMapping(value = "/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") Integer id, RedirectAttributes redirectAttributes) {
		if (this.employeeService.deleteEmployee(id)) {
			redirectAttributes.addFlashAttribute(MESSAGE, "Delete Success");
			return REDIRECT_VIEW_EMPLOYEES;
		}
		redirectAttributes.addFlashAttribute(MESSAGE, "Delete Failure");
		return REDIRECT_VIEW_EMPLOYEES;
	}
}
