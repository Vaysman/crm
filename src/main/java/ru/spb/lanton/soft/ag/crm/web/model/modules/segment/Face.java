package ru.spb.lanton.soft.ag.crm.web.model.modules.segment;

import java.sql.ResultSet;
import java.sql.SQLException;
import ru.spb.lanton.soft.ag.crm.web.model.Table;

/**
 * Класс описывающий свойства объекта "Тип страхового лица".
 * @author antoxa
 */

public class Face extends Table implements GetMap {

    private int id;
    
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
            
    @Override
    public void setValue(ResultSet rs) throws SQLException {
        setId(rs.getInt("id"));
        setName(rs.getString("name"));
    }
    
    @Override
    public String getAllValueQuery() {
        return "SELECT * FROM segment_face";
    }

    @Override
    public void setKey(String key) {
        setId(Integer.parseInt(key));
    }

    @Override
    public String getKey() {
        return Integer.toString(getId());
    }

    @Override
    public void setValue(String value) {
        setName(value);
    }

    @Override
    public String getValue() {
        return getName();
    }
    
}
