package io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain;

import io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain.EmployeeDomain.Employee;

import java.util.Optional;

import static io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain.EmployeeDomain.EmployeeId;

public interface EmployeeRepository {

    Optional<Employee> find(EmployeeId employeeId);

    Employee save(Employee employee);

    class EmployeeDataException extends RuntimeException {

        public EmployeeDataException(Throwable cause) {
            super(cause);
        }
    }
}
