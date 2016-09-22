package com.city.atm.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CityATMListController {

    @RequestMapping(value = "/loginPage.htm", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    @RequestMapping(value = "/homePage.htm", method = RequestMethod.GET)
    public ModelAndView getHomePage(ModelMap model, HttpServletRequest request) {
        return new ModelAndView("/cityHomePageATM", "username", this.getPrincipal(request));
    }

    private String getPrincipal(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();

        // get and return the logged in username
        return (principal != null ? principal.getName() : "ANONYMOUS");
        // return (principal == null ? "ANONYMOUS" : principal.getName());
    }
}
