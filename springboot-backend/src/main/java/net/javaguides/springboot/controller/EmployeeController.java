package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.StudentDetails;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}	
	
//	// get all students
//		@GetMapping("/students")
//		public List<StudentDetails> getAllStudentss(){
//			return studentRepository.findAll();
//		}

	@PostMapping("/employees")
	public ResponseEntity<String> createEmployee(@Valid @RequestBody Employee employee) {
		employeeRepository.save(employee);
		return new ResponseEntity<String>("register_success", HttpStatus.CREATED);
		
		
	}

//
//	// create student rest api
//		@PostMapping("/students")
//		public StudentDetails createStudent(@Valid  @RequestBody StudentDetails student) {
//			return studentRepository.save(student);
//		}
//
		
//
//	// get employee by id rest api
//	@GetMapping("/employees/{id}")
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//		Employee employee = employeeRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		return ResponseEntity.ok(employee);
//	}
	
	
//	// get student by id rest api
//		@GetMapping("/students/{id}")
//		public ResponseEntity<StudentDetails> getStudentById(@PathVariable Long id) {
//			StudentDetails student = studentRepository.findById(id)
//					.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
//			return ResponseEntity.ok(student);
//		}
		
	// update employee rest api
	
//	@PutMapping("/employees/{id}")
//	public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
//		Employee employee = employeeRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//
//		employee.setOrg_Name(employeeDetails.getOrg_Name());
//		employee.setEmp_mail_Id(employeeDetails.getEmp_mail_Id());
//		employee.setStudent_id(employeeDetails.getStudent_id());
//		employee.setCerrtificate_Verify(employeeDetails.getCerrtificate_Verify());
//
//
//		Employee updatedEmployee = employeeRepository.save(employee);
//		return new ResponseEntity<String>("Updated Successfully", HttpStatus.ACCEPTED);
//	}
	
	
	// update employee rest api
	
//		@PutMapping("/students/{id}")
//		public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody StudentDetails studentDetails){
//			StudentDetails student = studentRepository.findById(id)
//					.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
//
//			student.setStud_Name(studentDetails.getStud_Name());
//			student.setUser_Id(studentDetails.getUser_Id());
//			student.setCenter_Name(studentDetails.getCenter_Name());
//			student.setBatch_Name(studentDetails.getBatch_Name());
//			student.setStart_date(studentDetails.getStart_date());
//			student.setEnd_date(studentDetails.getEnd_date());
//			student.setGrade(studentDetails.getGrade());
//			student.setAssesment_status(studentDetails.getAssesment_status());
//
//
//			StudentDetails updatedStudent= studentRepository.save(student);
//			return new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);
//		}
//
//
	// delete employee rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
//	// delete student rest api
//	@DeleteMapping("/students/{id}")
//	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id){
//		StudentDetails students = studentRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
//
//		studentRepository.delete(students);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
//
	
}
