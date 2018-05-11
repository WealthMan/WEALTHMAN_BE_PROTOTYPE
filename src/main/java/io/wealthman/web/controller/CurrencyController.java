package io.wealthman.web.controller;

import io.wealthman.db.entity.Currency;
import io.wealthman.db.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/curr")
public class CurrencyController {

    @Autowired
    CurrencyRepository currencyRepository;

    @GetMapping("/all")
    List<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }
}
