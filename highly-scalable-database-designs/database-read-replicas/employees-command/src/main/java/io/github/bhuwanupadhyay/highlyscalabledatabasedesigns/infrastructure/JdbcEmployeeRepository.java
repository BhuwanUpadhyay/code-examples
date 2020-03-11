package io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.infrastructure;

import io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain.EmployeeDomain.Employee;
import io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain.EmployeeDomain.EmployeeId;
import io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain.EmployeeRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
class JdbcEmployeeRepository implements EmployeeRepository {

    private final JdbcTemplate jdbc;

    JdbcEmployeeRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Optional<Employee> find(EmployeeId employeeId) {
        try {
            return Optional.ofNullable(findByRef(employeeId)).map(EmployeeData::getEmployee);
        } catch (Exception ex) {
            throw new EmployeeDataException(ex);
        }
    }

    @Override
    public Employee save(Employee employee) {
        try {

            Optional<EmployeeId> optional = Optional.ofNullable(employee.employeeId());

            EmployeeId employeeId;

            if (optional.isEmpty()) {

                employeeId = new EmployeeId(UUID.randomUUID().toString());

                jdbc.update("INSERT INTO employee e (e.emp_id, e.name) values (?, ?)", employeeId.id(), employee.name().name());

            } else {

                employeeId = optional.get();

                jdbc.update("UPDATE employee e SET e.name = ? where e.emp_id = ?", employee.name().name(), employeeId.id());
            }

            return findByRef(employeeId).getEmployee();

        } catch (Exception ex) {
            throw new EmployeeDataException(ex);
        }
    }

    private EmployeeData findByRef(EmployeeId employeeId) {
        return jdbc.query(
                "SELECT * FROM employee e where e.emp_id = ?",
                new Object[]{employeeId.id()},
                (ResultSetExtractor<EmployeeData>) rs -> new EmployeeData()
        );
    }

}
