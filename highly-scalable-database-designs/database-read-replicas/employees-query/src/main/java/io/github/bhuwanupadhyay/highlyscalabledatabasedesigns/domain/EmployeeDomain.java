package io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface EmployeeDomain {

    record EmployeeView(@JsonProperty("employeeId")String employeeId,
                        @JsonProperty("name")String name,
                        @JsonProperty("status")String status) {
    }

}
