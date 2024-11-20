package tech.chillo.postions.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;
    @Test
    public void shouldReturnAllCustomers() {
        //Given
        Customer customerOne = Customer.builder().id(1).email("ibrahimkrimi2@gmail.com").build();
        Customer customerTwo = Customer.builder().id(2).email("accueil@gmail.com").build();
        this.customerRepository.saveAll(List.of(customerOne,customerTwo));
        //when
        final List<Customer> customerList = this.customerRepository.findAll();
        //Then
        assertEquals(customerList.size(), 2);
    }

    @Test
    public void shouldReturnCustomerByemail() {
        Customer customerOne = Customer.builder().email("ibrahimkrimi2@gmail.com").id(1).build();
        Customer customerTwo = Customer.builder().email("accueil@gmail.com").id(2).build();
        this.customerRepository.saveAll(List.of(customerOne,customerTwo));
        final  Customer customer = this.customerRepository.findByEmail("accueil@gmail.com");
        Assertions.assertEquals(customer.getEmail(), customerTwo.getEmail());
        //Assertions.assertEquals(customer.getId(), customerTwo.getId());
    }
}