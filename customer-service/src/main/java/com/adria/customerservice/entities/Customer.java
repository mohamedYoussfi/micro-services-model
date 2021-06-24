package com.adria.customerservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
}
