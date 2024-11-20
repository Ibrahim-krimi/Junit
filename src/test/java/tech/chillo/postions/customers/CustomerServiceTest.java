package tech.chillo.postions.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
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

    @Test
    void shouldReturnCustomerById() {
        //given
        Customer customerOne = Customer.builder().id(1).email("ibrahimkrimi2@gmail.com").build();
        when(this.customerRepository.findById(1)).thenReturn(Optional.of(customerOne));
        //when
        CustomerDTO customer = this.customerService.getCustomer(1);
        //then
        Assertions.assertEquals(customer.getId(),customerOne.getId());
    }

    @Test
    void shouldReturnExceptionWhenCustomerNotFound() {
        //given
        when(this.customerRepository.findById(anyInt())).thenReturn(Optional.empty());
        //when
        final IllegalArgumentException excpetion=assertThrows(IllegalArgumentException.class, () -> this.customerService.getCustomer(1));

        //then
        //Assertions.assertThrows(IllegalArgumentException.class, () -> this.customerService.getCustomer(1));
        Assertions.assertEquals(excpetion.getMessage(),"No Customer With this Id");
    }
}