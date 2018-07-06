package ru.spb.lanton.soft.ag.crm.web;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.spb.lanton.soft.ag.crm.web.data.DateFormat;
import ru.spb.lanton.soft.ag.crm.web.model.Auto;
import ru.spb.lanton.soft.ag.crm.web.model.Client;
import ru.spb.lanton.soft.ag.crm.web.model.Greencard;
import ru.spb.lanton.soft.ag.crm.web.model.Polis;
import ru.spb.lanton.soft.ag.crm.web.model.User;

@Controller
public class MainController {

    private final Greencard greencard = new Greencard();

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(@ModelAttribute("user") User user) {

        return "main";
    }

//    @RequestMapping(value = "/greencard", method = RequestMethod.GET)
//    public String greencard() {
//        
//        return "greencard";
//    }

    @RequestMapping(value = "/greencard")
    public ModelAndView greencard(@RequestParam("p") String param, @ModelAttribute("polis") Polis polis, @ModelAttribute("client") Client client, @ModelAttribute("auto") Auto auto) {
        ModelAndView mav = new ModelAndView("greencard");
        switch (param) {
            case "1":
                mav.addObject("polis", new Polis());
                
                // TODO
                // сделать получение списка СК из БД
                Map<Integer, String> companys = new HashMap<>();
                companys.put(1, "Ресо-Гарантия");
                companys.put(2, "Альфа страхование");
                companys.put(3, "РосГосСтрах");
                mav.addObject("companys", companys);
                
                Map<String, String> period = new LinkedHashMap<>();
                period.put("15", "15 дней");
                period.put("1", "1 месяц");
                period.put("2", "2 месяца");
                period.put("3", "3 месяца");
                period.put("4", "4 месяца");
                period.put("5", "5 месяцев");
                period.put("6", "6 месяцев");
                period.put("7", "7 месяцев");
                period.put("8", "8 месяцев");
                period.put("9", "9 месяцев");
                period.put("10", "10 месяцев");
                period.put("11", "11 месяцев");
                period.put("12", "12 месяцев");
                mav.addObject("period", period);
                
                Map<Integer, String> territory = new HashMap<>();
                territory.put(1, "Все страны Системы Зеленая карта");
                territory.put(2, "Только Азербайджан, Беларусь, Молдова, Украина");
                mav.addObject("territory", territory);
                
                // TODO
                // надо будет переделать чтобы брал данные из БД
                String polis_type = "Зеленая карта";
                                
                String date_sale = DateFormat.getDate(1);
                mav.addObject("polis_type", polis_type);
                mav.addObject("date_sale", date_sale);
                
                return mav;
            case "2":
                // проверяем валидность полученных данных о полисе
                if (polis.validate()) {
                    greencard.setPolis(polis);
                } else {
                    // TODO
                    // сделать страницу для обработки ошибок ввода
                    return new ModelAndView("Error");
                }
                mav.addObject("client", new Client());
                return mav;
            case "3":
                // проверяем валидность полученных данных о клиенте
                if (client.validate()) {
                    greencard.setClient(client);
                } else {
                    // TODO
                    // сделать страницу для обработки ошибок ввода
                    return new ModelAndView("Error");
                }
                mav.addObject("auto", new Auto());                
                return mav;
            case "end":
                // проверяем валидность полученных данных о авто
                if (auto.validate()) {
                    greencard.setAuto(auto);
                } else {
                    // TODO
                    // сделать страницу для обработки ошибок ввода
                    return new ModelAndView("Error");
                }
                mav.addObject("polis", greencard.getPolis());
                mav.addObject("client", greencard.getClient());                
                mav.addObject("auto", greencard.getAuto());
                return mav;
            default:
                return new ModelAndView("404");
        }
    }
    
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ModelAndView order() {
        // GOTO
        ModelAndView mav = new ModelAndView("order");
        mav.addObject("greencard", greencard);
        return mav;        
    }

}

