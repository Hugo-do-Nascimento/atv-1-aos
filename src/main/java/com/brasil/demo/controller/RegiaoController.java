package com.brasil.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.brasil.demo.service.RegiaoService;

@RestController
public class RegiaoController {
    
    @Autowired
    private RegiaoService regiaoService;

    

}
