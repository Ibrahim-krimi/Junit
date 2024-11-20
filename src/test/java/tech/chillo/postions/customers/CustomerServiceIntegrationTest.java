package tech.chillo.postions.customers;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerServiceIntegrationTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() {
        Customer customer = new Customer(13,"sami2@gmail.com");
        Customer customer2 = new Customer(12,"antoine2@gmail.com");
        customerRepository.save(customer);
    }

    @Test
    void ShouldCreateCustomer() {
        //
        Customer customer = new Customer(11,"sami@gmail.com");
        customerRepository.save(customer);
        customerRepository.flush();
        //
        Customer customersaved = this.customerRepository.findByEmail(customer.getEmail());
        //
        assertNotNull(customersaved);
        assertEquals(customersaved.getEmail(), customer.getEmail());
    }
    @AfterEach
    public void tearDown() {
        customerRepository.deleteAll();
    }


}
