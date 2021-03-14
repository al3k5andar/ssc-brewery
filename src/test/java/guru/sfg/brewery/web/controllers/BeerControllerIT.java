package guru.sfg.brewery.web.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
class BeerControllerIT extends BaseIT {


//    Not so good solution -> inside brackets we can specified a random username and the test will pass
//    @WithMockUser("spring") //tell spring to login with username: spring
    @Test
    void findBeers() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/beers/find"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("beers/findBeers"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("beer"));
    }

//    Better solution -> create authorization header and send data
    @Test
    void findBeersWithHttpBasic() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/beers/find")
//                    .with(SecurityMockMvcRequestPostProcessors.httpBasic("spring","guru"))
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("beers/findBeers"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("beer"));
    }
}