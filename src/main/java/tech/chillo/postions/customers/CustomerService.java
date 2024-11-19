package tech.chillo.postions.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final JdbcTemplate jdbcTemplate;

    private final String FIND_ALL = "select * from customers";

    private RowMapper<Customer> customerRowMapper=((rs, name)
            ->new Customer (rs.getInt("id"),rs.getString("email") ));

    public CustomerService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> findAll() {
        return jdbcTemplate.query(FIND_ALL, customerRowMapper);
    }
}
