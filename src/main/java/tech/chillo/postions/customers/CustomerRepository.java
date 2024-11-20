package tech.chillo.postions.customers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    Customer findByEmail(String email);
}
