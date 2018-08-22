package ru.spb.lanton.soft.ag.crm.web.data.modules.segment;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ru.spb.lanton.soft.ag.crm.web.data.DataAccessLayer;
import ru.spb.lanton.soft.ag.crm.web.model.IdList;
import ru.spb.lanton.soft.ag.crm.web.model.Table;
import ru.spb.lanton.soft.ag.crm.web.model.modules.segment.GetMap;
import ru.spb.lanton.soft.ag.crm.web.model.modules.segment.Segment;
import ru.spb.lanton.soft.ag.crm.web.model.modules.segment.SegmentView;

/**
 * Класс для работы с БД.
 * @author antoxa
 */
public class DataContex extends DataAccessLayer {
    
    
    
    public DataContex() {
        
    }
    
    /**
     * Получить карту всех значений id и name из БД по переданному классу.
     * @param <T>
     * @return
     * @throws SQLException
     * @throws ReflectiveOperationException 
     */
    public <T extends Table & GetMap> Map<String, String> getMapIdName(Class<T> t) throws SQLException, ReflectiveOperationException {
        Constructor<T> constructor = t.getDeclaredConstructor();
        constructor.setAccessible(true);
        T obj = constructor.newInstance();
        Map<String, String> map = new HashMap<>();
        List<T> list = parse(obj.getAllValueQuery(), t);
        for (T t1 : list) {
            map.put(t1.getKey(), t1.getValue());
        }
        return map;
    }

    public List<SegmentView> findBestPrice(Segment segment) throws SQLException, ReflectiveOperationException {
        String query = new StringBuilder()
                .append("SELECT * FROM segment WHERE ")
                .append("(face_id=? OR face_id=0) ")
                .append("AND ")
                .append("(status_id=? OR status_id=0) ")
                .append("AND ")
                .append("(license_id=? OR license_id=0) ")
                .append("AND ")
                .append("(category_id=? OR category_id=0) ")
                .append("AND ")
                .append("(territory_id=? OR territory_id=0) ")
                .append("AND ")
                .append("(yearauto<=? OR yearauto=0) ")
                .append("AND ")
                .append("(fromauto_id=? OR fromauto_id=0) ")
                .append("AND ")
                .append("(powerauto<=? OR powerauto=0) ")
                .append("AND ")
                .append("(countdriver_id=? OR countdriver_id=0) ")
                .append("AND ")
                .append("(yearold<=? OR yearold=0) ")
                .append("AND ")
                .append("(yearlicense<=? OR yearlicense=0) ")
                .append("AND ")
                .append("(kbm<=? OR kbm=0) ")
                .toString();
        Object[] params = new Object[]{
            segment.getFace_id(), segment.getStatus_id(), segment.getLicense_id(), segment.getCategory_id(), segment.getTerritory_id(),
            segment.getYearAuto(), segment.getFromAuto_id(), segment.getPowerAuto(), segment.getCountDriver(), segment.getYearOld(), 
            segment.getYearLicense(), segment.getKbm()};
        List<IdList> list = parse(query, params, IdList.class);
        query = "SELECT * FROM SegmentView WHERE ";
        for (Iterator<IdList> iterator = list.iterator(); iterator.hasNext();) {
            query += "id=" + iterator.next().getId();
            if (iterator.hasNext()) query += " OR ";
        }
        query += " ORDER BY kv DESC";
        return parse(query, SegmentView.class);
    }

    public Boolean addNewSegment(Segment segment) throws SQLException, ReflectiveOperationException {
        String query = new StringBuilder()
                .append("INSERT INTO segment(")
                .append("face_id, status_id, license_id, category_id, territory_id, ")
                .append("yearauto, fromauto_id, powerauto, countdriver_id, yearold, ")
                .append("yearlicense, kbm, company_id, kv, comment) ")
                .append("VALUES ")
                .append("(")
                .append(segment.getFace_id()) .append(", ") .append(segment.getStatus_id()) .append(", ") .append(segment.getLicense_id()) .append(", ") .append(segment.getCategory_id()) .append(", ") .append(segment.getTerritory_id()) .append(", ")
                .append(segment.getYearAuto()) .append(", ") .append(segment.getFromAuto_id()) .append(", ") .append(segment.getPowerAuto()) .append(", ") .append(segment.getCountDriver()) .append(", ") .append(segment.getYearOld()) .append(", ")
                .append(segment.getYearLicense()) .append(", ") .append(segment.getKbm()) .append(", ") .append(segment.getCompany_id()) .append(", ") .append(segment.getKv()) .append(", ") .append("'" + segment.getComment() +"'")
                .append(")")
                .toString();
        executeQuery(query);
        return true;
    }
    
    public List<SegmentView> allPrice() throws SQLException, ReflectiveOperationException {
        String query = "SELECT * FROM SegmentView ORDER BY company";
        return parse(query, SegmentView.class);
    }
    
}
