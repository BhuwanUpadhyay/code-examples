package io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.infrastructure;


import io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain.EmployeeDomain.Employee;

import static io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain.EmployeeDomain.*;

class EmployeeData {

    private final Long id;

    private final Employee employee;

    public EmployeeData(Long id,
                        String employeeId,
                        String employeeName,
                        String employeeStatus) {
        this.id = id;
        this.employee = new Employee(new EmployeeId(employeeId), new EmployeeName(employeeName), EmployeeStatus.valueOf(employeeStatus));
    }

    public Employee getEmployee() {
        return employee;
    }
}