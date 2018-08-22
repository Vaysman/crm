package ru.spb.lanton.soft.ag.crm.web;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.spb.lanton.soft.ag.crm.web.model.greencard.User;

@Controller
public class LoginController {

    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginForm() {
        
        ModelAndView mav = new ModelAndView("login");
        return mav;
    } 

}
