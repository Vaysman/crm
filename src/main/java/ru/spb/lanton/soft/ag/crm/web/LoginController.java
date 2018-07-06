package ru.spb.lanton.soft.ag.crm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.spb.lanton.soft.ag.crm.web.model.User;

@Controller
public class LoginController {

    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute("user") User user) {
        if (user.getLogin().equals("admin") && user.getPassword().equals("111")) {
            user.setAuth(true);
            return "main";
        }
        else {
            user.setAuth(false);
            model.addAttribute("error", "Неверные учетные данные!");
            return "login";
        }
    }    

}
