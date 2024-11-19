package tech.chillo.postions.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    CustomerDao customerDao;

    public List<Customer> getCustomers() {
        return this.customerDao.findAll();
    }



}
