package com.app.springboot;

import com.app.springboot.model.Employee;
import com.app.springboot.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@SpringBootApplication
public class SpringbootBackendApplication {

	private final EmployeeRepository employeeRepository;

	public SpringbootBackendApplication(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	record NewEmployeeRequest(
			String first_name,
			String last_name,
			String email_id
	){}


	@PostMapping("/employee")
	public void addEmployee(@RequestBody NewEmployeeRequest request){
		Employee employee = new Employee();
		employee.setEmailId(request.email_id());
		employee.setFirstName(request.first_name());
		employee.setLastName(request.last_name());
		employeeRepository.save(employee);
	}

}
