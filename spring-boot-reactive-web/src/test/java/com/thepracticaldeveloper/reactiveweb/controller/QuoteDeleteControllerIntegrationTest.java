package com.thepracticaldeveloper.reactiveweb.controller;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.thepracticaldeveloper.reactiveweb.domain.Quote;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuoteDeleteControllerIntegrationTest {

    // This one is not needed, but we need to override the real one to prevent the default behavior
    @MockBean
    private QuoteDeleteController quoteDeleteController;

    @LocalServerPort
    private int serverPort;

    private TestRestTemplate restTemplate;

    private String serverBaseUrl;    

    
    @Before
    public void setUp() {
    	serverBaseUrl = "http://localhost:" + serverPort;
        restTemplate = new TestRestTemplate(); 
   }
        
    @Test
    public void simpleDeleteRequest() throws Exception {
    	
        int id = 1;
        Quote quote = restTemplate.getForObject(serverBaseUrl + "/quote-delete/" + id, Quote.class);
        assertNotNull(quote);
        restTemplate.delete(serverBaseUrl + "/quote-delete/" + id);
        try {
             quote = restTemplate.getForObject(serverBaseUrl + "/quote-delete/" + id, Quote.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }  
     
}
