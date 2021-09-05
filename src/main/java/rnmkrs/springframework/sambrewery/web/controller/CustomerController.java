package rnmkrs.springframework.sambrewery.web.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rnmkrs.springframework.sambrewery.services.CustomerService;
import rnmkrs.springframework.sambrewery.web.model.CustomerDto;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {


    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto>getCustomerById(@PathVariable("customerId") UUID customerId){

        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping("/api/v1/customer")
    public ResponseEntity<CustomerDto> handleSaveCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto saveCustomerDto = customerService.saveCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", customerDto.getCustomerId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> handleUpdateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody  CustomerDto customerDto){
        customerService.updateCustomerById(customerId, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity handleDeleteCustomer(@PathVariable("customerId") UUID customerId){
        customerService.deleteCustomerById(customerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
