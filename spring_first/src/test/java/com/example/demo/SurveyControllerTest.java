package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.SpringOnebasicsApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringOnebasicsApplication.class, webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerTest {

    @LocalServerPort
    private int port;
    @Test
    public void test(){
        System.out.println("PortNumber"+port);
    }
}
