package com.rest.controller;

import com.rest.entity.Cards;
import com.rest.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardsController {

    @Autowired
    private CardRepository cardRepository;

    @PostMapping
    public ResponseEntity<Void> addCards(@RequestBody Cards cards) {
        List<Cards> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Cards cards1 = new Cards();
            cards1.setCardType(cards.getCardType());
            cards1.setCardNumber(cards.getCardNumber());
            cards1.setAmountUsed(cards.getAmountUsed());
            cards1.setCustomerId(cards.getCustomerId());
            cards1.setTotalLimit(cards.getTotalLimit());
            cardRepository.save(cards1);
        }
//        cardRepository.saveAll(list);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("cardNumber", "");
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Cards cards) {
        Cards cards1 = cardRepository.saveAndFlush(cards);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("cardNumber", cards1.getCardNumber().toString());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public List<Cards> getCards(@PathVariable Integer id) {
        try {
            Thread.sleep(10000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return cardRepository.findByCustomerId(id);
    }

}
