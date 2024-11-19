package tech.chillo.postions.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@JdbcTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CustomerDaoTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    CustomerDao customerDao;

    @Test
    void shouldReturnListOfCustomers() {
        //Arrange /Given
        customerDao = new CustomerDao(jdbcTemplate);
        //Act /when
        List<Customer> customers  =this.customerDao.findAll();
        //Assert / Then
        Assertions.assertEquals(7, customers.size());
        //Assertions.assertEquals(customers.get(0).getEmail(), "ibrahimkrimi2@gmail.com");
    }
}