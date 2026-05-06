package lv.venta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.service.IStudentCRUDService;

@Controller
@RequestMapping("/student/crud")
public class StudentCRUDController {

	private IStudentCRUDService studCrudService;
	
	
	@GetMapping("/all")//localhost:8080/student/crud/all
	public String getAllStudent(Model model) {
		
		try {
			model.addAttribute("package", studCrudService.retrieveAll());
			return "show-all-students-page";
			
		}
		catch(Exception e ) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
		
		
		
	}
	
	@GetMapping("/delete/{id}")//localhost:8080/student/crud/delete/1
	public String getDeleteStudentById(@PathVariable(name = "id") long id , Model model) {
		
		try {
			studCrudService.deleteByID(id);
			model.addAttribute("package", studCrudService.retrieveAll());
			return "show-all-students-page";
			
		}
		catch(Exception e ) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
		
		
		
	}
	
	
}
