package com.adria.billingservice.webapi;
import com.adria.billingservice.dto.InvoiceRequestDTO;
import com.adria.billingservice.dto.InvoiceResponseDTO;
import com.adria.billingservice.services.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestAPI {
    private InvoiceService invoiceService;

    public InvoiceRestAPI(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO> invoices(){
        return invoiceService.listInvoices();
    }
    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDTO invoice(@PathVariable String id){
        return invoiceService.getInvoice(id);
    }
    @PostMapping(path="/invoices")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return invoiceService.newInvoice(invoiceRequestDTO);
    }
}
