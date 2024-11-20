package tech.chillo.postions.customers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {
    private final JdbcTemplate jdbcTemplate;

    private final String FIND_ALL = "select * from customers";

    private RowMapper<CustomerDTO> customerRowMapper=((rs, name)
            ->new CustomerDTO(rs.getInt("id"),rs.getString("email") ));

    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CustomerDTO> findAll() {
        return jdbcTemplate.query(FIND_ALL, customerRowMapper);
    }
}
