/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demo.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 *
 * @author ABC
 */
@Getter
@Setter
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {
    
    private String token;
    
    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getCredentials() {
        return null; //To change body of generated methods, choose Tools | Templates.
    }
    
}
