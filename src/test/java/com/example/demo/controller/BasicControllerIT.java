package com.example.demo.controller;

import com.example.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Mehdi on 10/14/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicControllerIT {

    private static final String LOCAL_HOST="http://localhost:";
    @LocalServerPort
    private int port;
    private TestRestTemplate template=new TestRestTemplate();

    @Test
    public void welcome() throws Exception{
        ResponseEntity<String> response = template.getForEntity(createURL("/welcome"),String.class);
        assertThat(response.getBody(), equalTo("Hello World"));
    }

    private String createURL(String uri){
        return LOCAL_HOST + port + uri;
    }
    @Test
    public void welcomeWithObject() throws Exception{
        ResponseEntity<String> response = template.getForEntity(createURL("/welcome-with-object"),String.class);
        assertThat(response.getBody(), containsString("Hello World"));
    }
    @Test
    public void welcomeWithParameter() throws Exception{
        ResponseEntity<String> response = template.getForEntity(createURL("/welcome-with-parameter/name/Buddy"),String.class);
        assertThat(response.getBody(),containsString("Hello World, Buddy"));
    }
}
