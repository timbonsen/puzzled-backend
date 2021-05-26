package bonsen.nl.puzzled.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(MockitoExtension.class)
public class ExceptionControllerTest {

    @Autowired
    MockMvc mockMvc;

    /*@Test
    public void test_getSpecificException_AddressNotFound() throws Exception {
        String exceptionParam = "addressNotFound";

        mockMvc.perform(get("/exception/{exception-id}"), exceptionParam)
                .contentType(MediaType.APPLICATION_JSON)
                .andExpect(status().isNotFound())
                .andExpects(result -> Assertions.assertTrue(result.getResolvedException()));
    }*/
}
