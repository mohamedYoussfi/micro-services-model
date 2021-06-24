package com.adria.billingservice.services;

import com.adria.billingservice.entities.Customer;
import com.adria.billingservice.entities.Invoice;
import com.adria.billingservice.feign.CustomerServiceRestClient;
import com.adria.billingservice.mappers.InvoiceMapper;
import com.adria.billingservice.repository.InvoiceRepository;
import com.adria.billingservice.dto.InvoiceRequestDTO;
import com.adria.billingservice.dto.InvoiceResponseDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final CustomerServiceRestClient customerServiceRestClient;
    private final InvoiceMapper invoiceMapper;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, CustomerServiceRestClient customerServiceRestClient, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.customerServiceRestClient = customerServiceRestClient;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public InvoiceResponseDTO getInvoice(String id) {
        Invoice invoice=invoiceRepository.findById(id).orElse(null);
        if(invoice==null) throw new RuntimeException("Invoice Not found");
        Customer customer=customerServiceRestClient.customerById(invoice.getCustomerID());
        invoice.setCustomer(customer);
        return invoiceMapper.invoiceToInvoiceDTO(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> listInvoices() {
        List<Invoice> invoices=invoiceRepository.findAll();
        for(Invoice invoice:invoices){
            Customer customer=customerServiceRestClient.customerById(invoice.getCustomerID());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map((inv)->invoiceMapper.invoiceToInvoiceDTO(inv)).collect(Collectors.toList());
    }

    @Override
    public InvoiceResponseDTO newInvoice(InvoiceRequestDTO invoiceRequestDTO) {
        Customer customer;
        try {
            customer=customerServiceRestClient.customerById(invoiceRequestDTO.getCustomerID());
        } catch (Exception e){
         throw new RuntimeException(e.getMessage());
        }
        Invoice invoice=invoiceMapper.invoiceDTOtoInvoice(invoiceRequestDTO);
        invoice.setCustomer(customer);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        Invoice savedInvoice=invoiceRepository.save(invoice);
        savedInvoice.setCustomer(customerServiceRestClient.customerById(savedInvoice.getCustomerID()));
        return invoiceMapper.invoiceToInvoiceDTO(savedInvoice);
    }
}
