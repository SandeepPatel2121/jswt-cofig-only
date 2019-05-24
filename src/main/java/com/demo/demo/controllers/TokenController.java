/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demo.controllers;

import com.demo.demo.security.JwtGenerator;
import com.demo.demo.security.JwtUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ABC
 */
@RestController
@RequestMapping("/token")
public class TokenController {
    
    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }
    
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String generate(@RequestBody final JwtUser jwtUser) {
        JwtGenerator jwtGenerator = new JwtGenerator();
        return jwtGenerator.generate(jwtUser);
    }
    
}
