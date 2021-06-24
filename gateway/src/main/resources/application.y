spring:
  cloud:
    gateway:
      routes:
        - id : r1
          uri : http://localhost:8082/
          predicates :
            - Path= /api/customers/**
