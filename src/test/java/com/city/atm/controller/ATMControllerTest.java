package com.city.atm.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.city.atm.model.ATM;

/**
 * Test case for {@link ATMController}.
 * 
 * @author Simon Njenga
 * @since 0.1
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@Transactional(transactionManager = "transactionManager")
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TestExecutionListeners(value = DependencyInjectionTestExecutionListener.class, inheritListeners = true)
public class ATMControllerTest {

    @Autowired
    private ATMController atmController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.atmController).build();
    }

    /**
     * This test should testControllerInCityOne.
     * 
     * @throws Exception If something goes wrong
     */
    @Test
    public void testControllerInCityOne() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/listATMsByCity?city=MAASTRICHT")
            .contentType(MediaType.APPLICATION_JSON_UTF8).content("{ }"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));

        ResponseEntity<List<ATM>> response = this.atmController.listATMsByCity("MAASTRICHT");

        Assert.assertTrue(response != null && response.hasBody() && !response.getBody().isEmpty());

        ATM atm = response.getBody().get(0);
        Assert.assertEquals("ING", atm.getType());
        Assert.assertEquals("MAASTRICHT", atm.getAddress().getCity());
    }

    /**
     * This test should testControllerInCityTwo.
     * 
     * @throws Exception If something goes wrong
     */
    @Test
    public void testControllerInCityTwo() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/listATMsByCity?city=AMSTERDAM")
            .contentType("application/json;charset=UTF-8").content("{ }"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));

        ResponseEntity<List<ATM>> response = this.atmController.listATMsByCity("AMSTERDAM");

        Assert.assertTrue(response != null && response.hasBody() && !response.getBody().isEmpty());

        ATM atm = response.getBody().get(0);
        Assert.assertTrue(atm.getType().equals("ING") && !atm.getType().equals("ALBERT_HEIJN"));
        Assert.assertEquals("AMSTERDAM", atm.getAddress().getCity());
    }

    /**
     * This test should testControllerInCityThree.
     * 
     * @throws Exception If something goes wrong
     */
    @Test
    public void testControllerInCityThree() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/listATMsByCity?city=ROTTERDAM")
            .contentType("application/json;charset=UTF-8").content("{ }"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));

        ResponseEntity<List<ATM>> response = this.atmController.listATMsByCity("ROTTERDAM");

        Assert.assertTrue(response != null && response.hasBody() && !response.getBody().isEmpty());

        ATM atm = response.getBody().get(0);
        Assert.assertTrue(atm.getType().equals("ING") && !atm.getType().equals("ALBERT_HEIJN"));
        Assert.assertEquals("ROTTERDAM", atm.getAddress().getCity());
    }

    /**
     * This test should testControllerInCityFour.
     * 
     * @throws Exception If something goes wrong
     */
    @Test
    public void testControllerInCityFour() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/listATMsByCity?city=EINDHOVEN")
            .contentType("application/json;charset=UTF-8").content("{ }"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));

        ResponseEntity<List<ATM>> response = this.atmController.listATMsByCity("EINDHOVEN");

        Assert.assertTrue(response != null && response.hasBody() && !response.getBody().isEmpty());

        ATM atm = response.getBody().get(0);
        Assert.assertTrue(atm.getType().equals("ING") && !atm.getType().equals("ALBERT_HEIJN"));
        Assert.assertEquals("EINDHOVEN", atm.getAddress().getCity());
    }
}
