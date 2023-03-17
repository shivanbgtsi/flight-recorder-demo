package com.example.demo.service;

import com.example.demo.DemoApplication;
import com.example.demo.model.Cards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class DemoService {

        private RestTemplate restTemplate;
        @Autowired
        public DemoService(RestTemplate restTemplate){
                this.restTemplate = restTemplate;
        }

        public List<Cards> getCardsDetails(){
                ResponseEntity<Cards[]> responseEntity = restTemplate.
                        getForEntity("http://localhost:5060/cards/1", Cards[].class);
                Cards[] body = responseEntity.getBody();
                System.out.println(body.length);
                return Arrays.asList(body);
        }
}
