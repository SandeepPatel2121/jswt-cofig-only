/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

/**
 *
 * @author ABC
 */
@Component
public class JwtValidator {

    private String secret = "secret";

    public JwtUser validateToken(String token) {
        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            jwtUser = new JwtUser();

            jwtUser.setUsername(body.getSubject());
            jwtUser.setId((Long) body.get("userId"));
            jwtUser.setRole((String) body.get("role"));
        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
        }

        return jwtUser;
    }

}
