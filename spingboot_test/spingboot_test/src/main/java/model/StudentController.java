package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/findAll")
	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<Student>();
		students = studentService.getAllStudent();
		return students;
	}
	
	@GetMapping("/delete")
	public void deletStudent(@RequestParam String id) {
		studentService.deleteStudent(id);
	}
	
	@PostMapping("/add")
	public void addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
	}
	
	@PostMapping("/update")
	public void updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
	}
	
	@GetMapping("/findOne")
	public Student findById(@RequestParam String id) {
		return studentService.findById(id);
	}
	
	@GetMapping("/test")
	public String apiTest() {
		return "Works";
	}

}
