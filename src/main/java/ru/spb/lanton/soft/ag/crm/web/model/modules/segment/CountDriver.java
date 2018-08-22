package ru.spb.lanton.soft.ag.crm.web.model.modules.segment;

import java.sql.ResultSet;
import java.sql.SQLException;
import ru.spb.lanton.soft.ag.crm.web.model.Table;

/**
 *
 * @author antoxa
 */
public class CountDriver extends Table implements GetMap {
    
    private int id;
    
    private String name;
    
    private String comment;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }    

    @Override
    public void setValue(ResultSet rs) throws SQLException {
        id = Integer.parseInt(rs.getString("id"));
        name = rs.getString("name");
        comment = rs.getString("comment");
    }

    @Override
    public String getAllValueQuery() {
        return "SELECT * FROM segment_countdriver";
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