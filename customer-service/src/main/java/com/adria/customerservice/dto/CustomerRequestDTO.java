package com.adria.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapping;
@Data @NoArgsConstructor @AllArgsConstructor
public class CustomerRequestDTO {
    private String id;
    private String name;
    private String email;

}
