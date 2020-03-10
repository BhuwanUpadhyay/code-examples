package io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain;

public interface EmployeeDomain {

    record UpdateEmployeeCommand(String name) {
    }

    record DeleteEmployeeCommand(String name) {
    }

    record Employee(EmployeeId employeeId, EmployeeName name) {

        public void update(UpdateEmployeeCommand changed) {

        }

        public void delete(DeleteEmployeeCommand changed) {

        }
    }

    record EmployeeId(String id) {
    }

    record EmployeeName(String name) {
    }

}