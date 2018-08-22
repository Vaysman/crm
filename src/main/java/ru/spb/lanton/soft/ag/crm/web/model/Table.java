package ru.spb.lanton.soft.ag.crm.web.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс описывающий таблицу с данными для получения и работе с данными из БД.
 * @author antoxa
 */
public abstract class Table {
        
    public abstract void setValue(ResultSet rs) throws SQLException;
    
    public abstract String getAllValueQuery();
        
    
}
