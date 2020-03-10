package io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.infrastructure;


import io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain.EmployeeDomain.Employee;

class EmployeeData {

    private Long id;

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }
}