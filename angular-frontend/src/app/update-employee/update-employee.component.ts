import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent {
  employee : Employee = new Employee();
  id : number = -1;

  constructor(private employeeService : EmployeeService, private route : ActivatedRoute, private router : Router){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe(
      data => this.employee=data,
      error => console.log(error)
    );
  }

  updateEmployee(){
    this.employeeService.updateEmployee(this.id,this.employee).subscribe(
      data => {
         this.router.navigate(["/employees"]);
      },
      error => console.log(this.employee)
    );
  }

  onSubmit(){
    this.updateEmployee();
  }
}
