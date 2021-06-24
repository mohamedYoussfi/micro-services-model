package com.adria.billingservice.repository;

import com.adria.billingservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
}
