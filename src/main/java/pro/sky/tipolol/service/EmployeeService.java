package pro.sky.tipolol.service;

import org.springframework.stereotype.Service;
import pro.sky.tipolol.Employee;
import pro.sky.tipolol.exceptions.EmployeeAlreadyAddedException;
import pro.sky.tipolol.exceptions.EmployeeNotFoundException;
import pro.sky.tipolol.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();

    public void add(Employee employee) {
        if(employeeList.size() > 1){
            throw new EmployeeStorageIsFullException();
        }
        for (Employee em: employeeList) {
            if(em.equals(employee)){
                throw new EmployeeAlreadyAddedException();
            }
        }
        employeeList.add(employee);

    }

    public Employee find(Employee employee) {
        for (Employee el : employeeList) {
            if (el.equals(employee)) {
                return el;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Employee remove(Employee employee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).equals(employee)) {
                employeeList.remove(i);
            }else{
                throw new EmployeeNotFoundException();
            }
        }
        return employee;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}