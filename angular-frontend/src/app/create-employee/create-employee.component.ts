import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent {
  employee : Employee = new Employee();

  ngOnInit(): void { 
  }
  constructor(private employeeService : EmployeeService, private router : Router){}

  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe(
      data => {
        this.router.navigate(['/employees'])
      },
      error => {
        console.log(error);
      }
    )
  }

  onSubmit(){
    this.saveEmployee()
  }
}
