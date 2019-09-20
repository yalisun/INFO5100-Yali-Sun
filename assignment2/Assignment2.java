package Assignment2;

import javax.sql.rowset.FilteredRowSet;

/**
 * Submit it on or before 22nd September 2019 , 12:00 pm
 */
public class Assignment2 {
    /*
        This method should return the sum of salaries of employees having salary greater than 5000
        Note: Employee array is passed, not employee
     */
    public double salaryGreaterThanFiveThousand(Employee[] employees) {
        double sumSalaries = 0;
        if (employees == null) return sumSalaries;

        for (Employee employee : employees) {
            if (employee.getSalary() > 5000) {
                sumSalaries += employee.getSalary();
            }
        }
        return sumSalaries;
    }
    
    /*
        This method should print either "Fizz", "Buzz" or "FizzBuzz"
        "Fizz" - if id of employee is divisible by 3
        "Buzz" - if id of employee is divisible by 5
        "FizzBuzz" - if id of employee is divisible by both 3 and 5
     */
    public void fizzBuzz(Employee employee) {
        if (employee == null) return;

        int id = employee.getId();
        if (id % 3 == 0) {
            System.out.print("Fizz");
        }
        if (id % 5 == 0) {
            System.out.print("Buzz");
        }
    }

    /*
        This method should calculate tax for an employee in dollars
        If salary of employee is less than or equal to 2500, tax should be 10%
        If salary of employee is greater than 2500 but less than or equal to 5000, tax should be 25%
        If salary of employee is greater than 5000, tax should be 35%
    */
    public double calculateTax(Employee employee) {
        double salary = employee.getSalary();
        if (salary <= 2500) {
            return salary * 0.1;
        }
        if (salary <= 5000) {
            return (salary - 2500) * 0.25 + 250;
        }
        return (salary - 5000) * 0.35 + 875;
    }
    
    
    /*
        We are given two employee objects.
        Implement this method to swap salaries of employees
    */
    public void swap(Employee firstEmployee, Employee secondEmployee) {
        if (firstEmployee == null || secondEmployee == null) return;

        double tmp = firstEmployee.getSalary();
        firstEmployee.setSalary(secondEmployee.getSalary());
        secondEmployee.setSalary(tmp);
    }

    
    /*
        Return number of employees whose age is greater than 50
        Note: Employee array is passed, not employee
     */
    public int employeesAgeGreaterThan50(Employee[] employees) {
        int count = 0;
        if (employees == null) return count;

        for (Employee employee : employees) {
            if (employee.getAge() > 50) {
                count++;
            }
        }
        return count;
    }

    
    /*
        Implement this method to reverse firstName of employee.
        Ex. Before: employee.getFirstName() -> "John"
        After : employee.getFirstName() -> "nhoJ"
     */
    public void reverseFirstName(Employee employee) {
        if (employee == null || employee.getFirstName() == null) return;

        StringBuilder newNameBuilder = new StringBuilder(employee.getFirstName());
        newNameBuilder.reverse();
        employee.setFirstName(newNameBuilder.toString());
    }

    
    /*
        Print "true" if employee's first name contain one or more digits
        Print "false" if employee's first name doesn't contain any digit
        Ex: employee.getFirstName() -> "ha8l" == true
        employee.getFirstName() -> "hail" == false
     */
    public void isContainDigit(Employee employee) {
        if (employee == null || employee.getFirstName() == null) {
            printFalse();
            return;
        }

        String firstName = employee.getFirstName();
        for (char c : firstName.toCharArray()) {
            if (Character.isDigit(c)) {
                System.out.print("true");
            }
        }
        printFalse();
    }

    private void printFalse() {
        System.out.print("false");
    }

    
     /*
        Write a method to raise an employee's salary to three times of his/her original salary.
        Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
        DO NOT change the input in this method.
        Try to add a new method in Employee class: public void raiseSalary(double byPercent) 
        Call this new method.
     */
    public void tripleSalary(Employee employee) {
        if (employee == null) return;

        // triple -> raise by two-hundred percent
        employee.raiseSalary(2);
    }
    
    
    //Additional question for extra credit
    /*
        Implement this method to convert String[] to employees array.
        Ex: String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
        This String array of length 2 contains 2 employees in form of string, where
        id = 1
        firstName=John
        age=24
        salary=7500
        convert each string to employee object.
        Hint: Use String methods. Refer : https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
     */
    public Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees = new Employee[employeesStr.length];

        // for each string, convert it to employee object, save to employees array
        for(int i = 0; i < employeesStr.length; i++) {
            // parse string
            String[] data = employeesStr[i].split(",");
            if (data.length != 4) continue;

            int id = Integer.parseInt(data[0]);
            String firstName = data[1];
            int age = Integer.parseInt(data[2]);
            double salary = Double.parseDouble(data[3]);
            // build employee object, save to array
            employees[i] = new Employee(id, firstName, age, salary);
        }
        return employees;
    }
}
