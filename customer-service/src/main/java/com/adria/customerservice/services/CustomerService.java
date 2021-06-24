package com.adria.customerservice.services;

import com.adria.customerservice.dto.CustomerRequestDTO;
import com.adria.customerservice.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO getCustomer(String id);
    List<CustomerResponseDTO> getCustomers();
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    void deleteCustomer(String id);
}
