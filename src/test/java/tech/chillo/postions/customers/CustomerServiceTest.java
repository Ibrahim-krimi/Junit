package tech.chillo.postions.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@JdbcTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CustomerServiceTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    CustomerService customerService;

    @Test
    void shouldReturnListOfCustomers() {
        //Arrange /Given
        customerService = new CustomerService(jdbcTemplate);
        //Act /when
        List<Customer> customers  =this.customerService.findAll();
        //Assert / Then
        Assertions.assertEquals(7, customers.size());
        //Assertions.assertEquals(customers.get(0).getEmail(), "ibrahimkrimi2@gmail.com");
    }
}