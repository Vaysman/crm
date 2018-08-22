package ru.spb.lanton.soft.ag.crm.web;

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
import ru.spb.lanton.soft.ag.crm.web.model.greencard.Auto;
import ru.spb.lanton.soft.ag.crm.web.model.greencard.Client;
import ru.spb.lanton.soft.ag.crm.web.model.greencard.Greencard;
import ru.spb.lanton.soft.ag.crm.web.model.greencard.Polis;;

@Controller
public class MainController {

    private final Greencard greencard = new Greencard();

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {        
        return "main";
    }

    @RequestMapping(value = "/greencard")
    public ModelAndView greencard(@RequestParam("p") String param, @ModelAttribute("polis") Polis polis, @ModelAttribute("client") Client client, @ModelAttribute("auto") Auto auto) {
        ModelAndView mav = new ModelAndView("greencard");
        switch (param) {
            case "1":
                mav.addObject("polis", new Polis());
                
                // TODO
                Map<Integer, String> companys = new HashMap<>();
                // сделать получение списка СК из БД
                //companys.putAll(db.getAllIC); db - объект для получения сведений из БД. getAllIC - метод для получения списка всех страховых компаний.
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
                //TODO
                // добавляем список с типом документа предьявляемого клиентом
                Map<Integer, String> documentType = new LinkedHashMap<>();
                documentType.put(1, "Паспорт РФ");
                documentType.put(2, "Загранпаспорт гражданина РФ");
                documentType.put(3, "Паспорт гражданина иностранного государства");
                mav.addObject("documentType", documentType);
                
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
                // TODO
                // добавляет типы ТС из БД
                Map<Integer, String> typeAuto = new LinkedHashMap<>();
                typeAuto.put(1, "Легковые автомобили");
                typeAuto.put(2, "Мотоциклы");
                typeAuto.put(3, "Автобусы");
                mav.addObject("typeAuto", typeAuto);
                
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

