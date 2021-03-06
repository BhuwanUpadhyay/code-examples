package io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain;

public interface EmployeeDomain {

    enum EmployeeStatus {
        JOINED,
        RESIGNED
    }

    record Employee(EmployeeId employeeId, EmployeeName name, EmployeeStatus status) {
    }

    record EmployeeId(String id) {
    }

    record EmployeeName(String name) {
    }

}