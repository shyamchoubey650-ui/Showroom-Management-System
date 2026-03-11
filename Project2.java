

//********************************
// EMPLOYEE PAYROLL SYSTEM PROJECT
//********************************
//Payroll system is used  by company to manage employee details like salary,bonus etc.


//****************
// EMPLOYEE CLASS
//****************

import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name,int id){
        this.name = name;
        this.id = id;
    }

//    Here we use encapsulation for security purpose.
//    here we not provide direct access to user.
    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

//    Abstract Method
    public abstract double calSalary();

    @Override
    public String toString(){
        return "Employee[name="+name+", id="+id+", salary="+calSalary()+"]";
    }

}

//******************************************
// FULL TIME EMPLOYEE CLASS EXTENDS EMPLOYEE
//******************************************

class FullTimeEmp extends Employee{
    private double monthlySalary;

    public FullTimeEmp(String name,int id, double monthlySalary){
        super(name,id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calSalary(){
        return monthlySalary;
    }
}

//******************************************
// PART TIME EMPLOYEE CLASS EXTENDS EMPLOYEE
//******************************************

class partTimeEmp extends Employee{
    private int hoursWork;
    private double hourlyRate;

    public partTimeEmp(String name,int id,int hoursWork,double hourlyRate){
        super(name,id);
        this.hoursWork = hoursWork;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calSalary(){
        return hoursWork * hourlyRate;
    }
}

//*********************
// PAYROLL SYSTEM CLASS
//*********************

// ArrayList<Employee> employeesList = new ArrayList<>();

class PayrollSystem {
    private ArrayList<Employee> employeesList;

    public PayrollSystem(){
        employeesList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeesList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeRemove = null;
        for (Employee employee: employeesList){
            if (employee.getId()==id){
                employeeRemove = employee;
                break;
            }
        }
        if (employeeRemove != null){
            employeesList.remove(employeeRemove);
        }
    }

    public void DisplayEmp(){
        for (Employee employee: employeesList){
            System.out.println(employee);
        }
    }
}


public class Project2 {
    static void main(String[] args) {
        PayrollSystem ps = new PayrollSystem();
        FullTimeEmp emp1 = new FullTimeEmp("Shyam",253, 70000.0);
        FullTimeEmp emp2 = new FullTimeEmp("Raj",250, 72000.0);
        partTimeEmp emp3 = new partTimeEmp("Ram",254,40,100);

        ps.addEmployee(emp1);
        ps.addEmployee(emp2);
        ps.addEmployee(emp3);

        System.out.println("Initial Employee details: ");
        ps.DisplayEmp();

        System.out.println("Removing Employee");
        ps.removeEmployee(254);

        System.out.println("Remaining Employee: ");
        ps.DisplayEmp();


    }
}
