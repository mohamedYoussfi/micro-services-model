package com.adria.billingservice.services;

import com.adria.billingservice.dto.InvoiceRequestDTO;
import com.adria.billingservice.dto.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
 InvoiceResponseDTO getInvoice(String id);
 List<InvoiceResponseDTO> listInvoices();
 InvoiceResponseDTO newInvoice(InvoiceRequestDTO invoiceRequestDTO);
}
