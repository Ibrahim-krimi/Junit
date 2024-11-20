package tech.chillo.postions.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;
    @Test
    void shouldReturnAllCustomers() {
        //given
        Customer customerOne = Customer.builder().id(1).email("ibrahimkrimi2@gmail.com").build();
        Customer customerTwo = Customer.builder().id(3).email("ibrahimkrimi3@gmail.com").build();
        when(this.customerRepository.findAll()).thenReturn(List.of(customerOne,customerTwo));
        //when
        List<CustomerDTO> customerList = this.customerService.getCustomers();
        //then
        Assertions.assertEquals(customerList.size(), 2);
    }
}