package tech.chillo.postions.customers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerRestController.class)
class CustomerRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    @DisplayName("[Controller Test sur liste des utilisateurs]")
    @Test
    void shouldReturnListOfCustomers() throws Exception {
        //arrange
        CustomerDTO customerOne = new CustomerDTO(1,"ibrahim@gmail.com");
        CustomerDTO customerTwo = new CustomerDTO(2,"ibrahim2@gmail.com");
        when(this.customerService.getCustomers()).thenReturn(List.of(customerOne, customerTwo));
        //act & assert
        this.mockMvc
                .perform(get("/cutomers"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}