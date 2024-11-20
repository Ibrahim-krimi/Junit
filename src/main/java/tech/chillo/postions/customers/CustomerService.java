package tech.chillo.postions.customers;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    CustomerRepository customerRepository;

    public List<CustomerDTO> getCustomers() {
       List<CustomerDTO> customerDTOList  = this.customerRepository.findAll().stream().map(customer -> {
             return  new CustomerDTO(customer.getId(),customer.getEmail());
         }).toList();
       return customerDTOList;
    }



}
