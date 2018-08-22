package ru.spb.lanton.soft.ag.crm.web.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author antoxa
 */
public class IdList extends Table {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    @Override
    public void setValue(ResultSet rs) throws SQLException {
        setId(rs.getInt("id"));
    }

    @Override
    public String getAllValueQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
