import java.util.ArrayList;

abstract class Employee
{
    private String name;
    private int id;

    public Employee(String name, int id)
    {
        this.name= name;
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public int getId()
    {
        return this.id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString()
    {
        return "Employee [name="+name+", id="+id+", salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee
{

    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary)
    {
        super(name,id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary()
    {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee
{
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate)
    {
        super(name,id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary()
    {
        return hourlyRate * hourlyRate;
    }

}

class PayrollSystem
{
    private ArrayList<Employee> employeeList;

    public PayrollSystem()
    {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee emp)
    {
        employeeList.add(emp);
    }

    public void removeEmployee(int id)
    {
        Employee employeeToRemove = null;

        for(Employee employee:employeeList)
        {
            if(employee.getId()==id)
            {
                employeeToRemove = employee;
                break;
            }
        }

        if(employeeToRemove!=null)
        {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees()
    {
        for(Employee employee:employeeList)
        {
            System.out.println(employee);
        }
    }
}


public class Main {
    public static void main(String[] args)
    {
        PayrollSystem payroll1 = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Ruchit",120,80000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Vikas",121,40,100);

         payroll1.addEmployee(emp1);
         payroll1.addEmployee(emp2);

        System.out.println("Initial Employee Details");
        payroll1.displayEmployees();

        System.out.println();
        System.out.println("Removing Employee with ID 121");
        payroll1.removeEmployee(121);
        System.out.println("Final Employee Details");
        payroll1.displayEmployees();

    }
}