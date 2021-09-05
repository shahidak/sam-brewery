package rnmkrs.springframework.sambrewery.services;


import rnmkrs.springframework.sambrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveCustomer(CustomerDto customerDto);

    void updateCustomerById(UUID customerId, CustomerDto customerDto);

    void deleteCustomerById(UUID customerId);
}
