package rnmkrs.springframework.sambrewery.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rnmkrs.springframework.sambrewery.web.model.CustomerDto;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .customerId(UUID.randomUUID())
                .name("Shahid")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .customerId(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDto customerDto) {
        log.debug("Customer Updating....");
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        log.debug("Deleting Customer...");
    }
}
