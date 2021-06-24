package com.adria.customerservice.repositories;

import com.adria.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
