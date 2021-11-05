/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.com470.lab4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan Carlos
 */
@RestController
public class Principal {

    @RequestMapping(value = "/")
    public String hola() {
        return "Hola";
    }

}
