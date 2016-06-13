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
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Class description to be done later!
 *
 * @author Simon Njenga
 * @since 0.1
 */
@Controller
public class CityATMListController {

    @RequestMapping(value = "/loginPage.htm", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    @RequestMapping(value = "/homePage.htm", method = RequestMethod.GET)
    public ModelAndView getHomePage(ModelMap model, HttpServletRequest request) {
        model.addAttribute("username", this.getPrincipal(request));
        return new ModelAndView("/cityHomePageATM", model);
    }

    @RequestMapping(value = "/loginError.htm", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("error", "Invalid username or password! Please try again.");
        return "login";
    }

    @RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession(true).invalidate();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
            logoutHandler.logout(request, response, auth);
        }
        // return new ModelAndView(UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/loginPage.htm");
        return new ModelAndView(new RedirectView("/loginPage.htm", true));
    }

    private String getPrincipal(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();

        // get and return the logged in username
        return (principal != null ? principal.getName() : "ANONYMOUS");
        // return (principal == null ? "ANONYMOUS" : principal.getName());
    }
}
