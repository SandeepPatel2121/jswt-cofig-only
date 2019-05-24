/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demo.security;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author ABC
 */
@Component

public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    
    @Autowired
    private JwtValidator jwtValidator;
    
    @Override
    public boolean supports(Class<?> type) {
        return (JwtAuthenticationToken.class.isAssignableFrom(type));
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails ud, UsernamePasswordAuthenticationToken upat) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken jwtToken) throws AuthenticationException {
        JwtAuthenticationToken authToken = (JwtAuthenticationToken) jwtToken;
        String token = authToken.getToken();
        
        JwtUser jwtUser = jwtValidator.validateToken(token);
        if (jwtUser == null) {
            throw new RuntimeException("Getting User Null");
        } 
        List<GrantedAuthority> grantedAuthority = AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRole());
        return new JwtUserDetails(jwtUser.getUsername(),jwtUser.getId(),token,grantedAuthority);
    }

    
}
