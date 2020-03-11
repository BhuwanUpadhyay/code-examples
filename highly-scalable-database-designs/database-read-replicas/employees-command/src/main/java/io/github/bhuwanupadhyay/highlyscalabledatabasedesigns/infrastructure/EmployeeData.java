package io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.infrastructure;


import io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain.EmployeeDomain;
import io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain.EmployeeDomain.Employee;

import static io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain.EmployeeDomain.*;

class EmployeeData {

    private final Long id;

    private final Employee employee;

    public EmployeeData(Long id,
                        String employeeId,
                        String employeeName) {
        this.id = id;
        this.employee = new Employee(new EmployeeId(employeeId), new EmployeeName(employeeName));
    }

    public Employee getEmployee() {
        return employee;
    }
}