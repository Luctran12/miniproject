package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	StudentRepository students;

	public StudentService(StudentRepository students) {
		this.students = students;
	}
	
	public List<Student> getAllStudent() {
		return students.getAll();
	}
	
	public void deleteStudent(String id) {
		students.deleteStudent(id);
	}
	
	public void addStudent(Student student) {
		students.addStudent(student);
	}
	
	public void updateStudent(Student student) {
		students.updateStudent(student);
	}
	
	public Student findById(String id) {
		return students.findById(id);
	}
	
}
