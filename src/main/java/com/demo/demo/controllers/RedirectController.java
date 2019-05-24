package com.demo.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ABC
 */
@RestController
public class RedirectController {
    
    @RequestMapping(value = "/rest/hello", method = RequestMethod.GET)
    public ModelAndView getView() {
        return new ModelAndView("home");
    }
    
}
