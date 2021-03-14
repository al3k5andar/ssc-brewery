package guru.sfg.brewery.web.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class BeerRestControllerIT extends BaseIT
{
    @Test
    void findBeers() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findBeerById() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/72eaf270-3f11-4903-ad5c-627e60e29b16"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
