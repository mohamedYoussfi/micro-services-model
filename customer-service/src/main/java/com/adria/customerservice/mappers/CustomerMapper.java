package com.adria.customerservice.mappers;

import com.adria.customerservice.dto.CustomerRequestDTO;
import com.adria.customerservice.dto.CustomerResponseDTO;
import com.adria.customerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerDTO(Customer customer);
    Customer customerRequestDtoToCustomer(CustomerRequestDTO customerRequestDTO);
}
