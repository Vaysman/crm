package ru.spb.lanton.soft.ag.crm.web;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.spb.lanton.soft.ag.crm.web.model.modules.segment.Segment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.spb.lanton.soft.ag.crm.web.data.modules.segment.DataContex;
import ru.spb.lanton.soft.ag.crm.web.model.modules.segment.Category;
import ru.spb.lanton.soft.ag.crm.web.model.modules.segment.Company;
import ru.spb.lanton.soft.ag.crm.web.model.modules.segment.CountDriver;
import ru.spb.lanton.soft.ag.crm.web.model.modules.segment.Face;
import ru.spb.lanton.soft.ag.crm.web.model.modules.segment.FromAuto;
import ru.spb.lanton.soft.ag.crm.web.model.modules.segment.License;
import ru.spb.lanton.soft.ag.crm.web.model.modules.segment.SegmentView;
import ru.spb.lanton.soft.ag.crm.web.model.modules.segment.Status;
import ru.spb.lanton.soft.ag.crm.web.model.modules.segment.Territory;

/**
 * Modules controller.
 *
 * @author antoxa
 */
@Controller
public class ModulesController {

    private final DataContex dataContex = new DataContex();

    @Secured("ROLE_USER")
    @RequestMapping(value = "/modules/segment", method = RequestMethod.GET)
    public ModelAndView segment_inputForm_user() {
        ModelAndView mav = new ModelAndView("segment");
        Segment segment = new Segment();
        // подготавливаем данные для отображения на странице
        Map<String, String> face_id = null;
        Map<String, String> status_id = null;
        Map<String, String> license_id = null;
        Map<String, String> fromAuto_id = null;
        Map<String, String> category_id = null;
        Map<String, String> territory_id = null;
        Map<String, String> countDriver_id = null;
        Map<String, String> company_id = null;
        try {
            face_id = dataContex.getMapIdName(Face.class);

            status_id = dataContex.getMapIdName(Status.class);

            license_id = dataContex.getMapIdName(License.class);

            fromAuto_id = dataContex.getMapIdName(FromAuto.class);

            category_id = new TreeMap<>(new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return Integer.parseInt(s1) - Integer.parseInt(s2);
                }
            });
            category_id.putAll(dataContex.getMapIdName(Category.class));

            territory_id = dataContex.getMapIdName(Territory.class);

            countDriver_id = dataContex.getMapIdName(CountDriver.class);

            company_id = dataContex.getMapIdName(Company.class);
        } catch (SQLException ex) {
        } catch (ReflectiveOperationException ex) {
        }

        mav.addObject("target", "inputForm");
        face_id.remove("0");
        status_id.remove("0");
        license_id.remove("0");
        fromAuto_id.remove("0");
        category_id.remove("0");
        territory_id.remove("0");
        countDriver_id.remove("0");
        // устанавливаем занчения по умолчанию
        segment.setFace_id(1);
        segment.setStatus_id(1);
        segment.setLicense_id(1);
        segment.setFromAuto_id(1);
        segment.setCategory_id(3);
        segment.setTerritory_id(1);
        segment.setYearOld(0);
        segment.setYearLicense(0);
        segment.setCountDriver(1);

        mav.addObject("face_id", face_id);
        mav.addObject("status_id", status_id);
        mav.addObject("license_id", license_id);
        mav.addObject("fromAuto_id", fromAuto_id);
        mav.addObject("category_id", category_id);
        mav.addObject("territory_id", territory_id);
        mav.addObject("countDriver", countDriver_id);

        mav.addObject("segment", segment);
        return mav;
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/admin/modules/segment", method = RequestMethod.GET)
    public ModelAndView segment_inputForm_admin() {
        ModelAndView mav = new ModelAndView("segment");
        Segment segment = new Segment();
        // подготавливаем данные для отображения на странице
        Map<String, String> face_id = null;
        Map<String, String> status_id = null;
        Map<String, String> license_id = null;
        Map<String, String> fromAuto_id = null;
        Map<String, String> category_id = null;
        Map<String, String> territory_id = null;
        Map<String, String> countDriver_id = null;
        Map<String, String> company_id = null;
        try {
            face_id = dataContex.getMapIdName(Face.class);

            status_id = dataContex.getMapIdName(Status.class);

            license_id = dataContex.getMapIdName(License.class);

            fromAuto_id = dataContex.getMapIdName(FromAuto.class);

            category_id = new TreeMap<>(new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return Integer.parseInt(s1) - Integer.parseInt(s2);
                }
            });
            category_id.putAll(dataContex.getMapIdName(Category.class));

            territory_id = dataContex.getMapIdName(Territory.class);

            countDriver_id = dataContex.getMapIdName(CountDriver.class);

            company_id = dataContex.getMapIdName(Company.class);
        } catch (SQLException ex) {
        } catch (ReflectiveOperationException ex) {
        }

        mav.addObject("target", "admins");

        // устанавливаем занчения по умолчанию
        segment.setCountDriver(1);
        segment.setCompany_id(1); // Ресо

        mav.addObject("company_id", company_id);

        mav.addObject("face_id", face_id);
        mav.addObject("status_id", status_id);
        mav.addObject("license_id", license_id);
        mav.addObject("fromAuto_id", fromAuto_id);
        mav.addObject("category_id", category_id);
        mav.addObject("territory_id", territory_id);
        mav.addObject("countDriver", countDriver_id);

        mav.addObject("segment", segment);
        return mav;
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/modules/segment", method = RequestMethod.POST)
    public ModelAndView segment_result_user(@ModelAttribute("segment") Segment segment) throws SQLException, ReflectiveOperationException {
        ModelAndView mav = new ModelAndView("segment");
        mav.addObject("target", "result");
        mav.addObject("user", "user");
        List<SegmentView> listBestPrice = dataContex.findBestPrice(segment);
        Set<String> set = new HashSet<>();
        for (Iterator<SegmentView> iterator = listBestPrice.iterator(); iterator.hasNext();) {
            if (!set.add(iterator.next().getCompany())) {
                iterator.remove();
            }
        }
        set.clear();
        mav.addObject("listBestPrice", listBestPrice);
        return mav;
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/admin/modules/segment", method = RequestMethod.POST)
    public ModelAndView segment_result_admin(@ModelAttribute("segment") Segment segment) throws SQLException, ReflectiveOperationException {
        ModelAndView mav = new ModelAndView("segment");
        mav.addObject("target", "result");
        Boolean answer = dataContex.addNewSegment(segment);
        List<SegmentView> listAllPrice = dataContex.allPrice();
        mav.addObject("listAllPrice", listAllPrice);
        mav.addObject("user", "admin");
        return mav;
    }

}
