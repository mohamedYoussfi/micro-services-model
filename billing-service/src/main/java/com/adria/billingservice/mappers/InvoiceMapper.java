package com.adria.billingservice.mappers;

import com.adria.billingservice.entities.Invoice;
import com.adria.billingservice.dto.InvoiceRequestDTO;
import com.adria.billingservice.dto.InvoiceResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    InvoiceResponseDTO invoiceToInvoiceDTO(Invoice invoice);
    Invoice invoiceDTOtoInvoice(InvoiceRequestDTO invoiceRequestDTO);
}
