package com.great.learning.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.great.learning.entity.Student;
import com.great.learning.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		String returnVal = "";

		List<Student> theStudents = studentService.findAll();

		theModel.addAttribute("Students", theStudents);

		return "list-Students";
	}

	@RequestMapping("/addStudent")
	public String showFormForAdd(Model theModel) {

		// create model to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("Student", theStudent);

		return "Student-form";
	}

	@RequestMapping("/updateStudent")
	public String showFormForUpdate(@RequestParam("student_id") int theId, Model theModel) {

		// get the Student from the service
		Student theStudent = studentService.findById(theId);

		// set Student as a model to pre-populate the form
		theModel.addAttribute("Student", theStudent);

		// send over to our form
		return "Student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		Student theStudent;
		String returnVal = "";

		if (name.equals("") || department.equals("") || country.equals("")) {
			returnVal = "no-data";
		} else {
			if (id != 0) {
				theStudent = studentService.findById(id);
				theStudent.setName(name);
				theStudent.setDepartment(department);
				theStudent.setCountry(country);
			} else
				theStudent = new Student(name, department, country);
			// save the Student
			studentService.save(theStudent);
			returnVal = "redirect:/students/list";

		}
		// use a redirect to prevent duplicate submissions
		return returnVal;

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("student_id") int theId) {

		// delete the Student
		studentService.deleteById(theId);

		// redirect to /students/list
		return "redirect:/students/list";

	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
}
