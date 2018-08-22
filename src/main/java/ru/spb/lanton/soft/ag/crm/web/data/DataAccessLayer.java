package ru.spb.lanton.soft.ag.crm.web.data;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import ru.spb.lanton.soft.ag.crm.web.model.Table;

/**
 * Класс описывающий доступ к БД.
 *
 * @author antoxa
 */
public abstract class DataAccessLayer implements AutoCloseable {

    private final SimpleDriverDataSource datasource;

    private final JdbcTemplate jdbcTemplate;

    public DataAccessLayer() {
        datasource = new SimpleDriverDataSource();
        loadConnectionProperties();
        jdbcTemplate = new JdbcTemplate(datasource);
    }

    private void loadConnectionProperties() {
        ResourceBundle rb = ResourceBundle.getBundle("db");
        String sw = rb.getString("db.driver");
        Driver driver = null;
        switch (sw) {
            case "jdbc:postgresql":
                driver = new org.postgresql.Driver();
                break;
            case "jdbc:mysql": // пока не реализовано
                driver = null;
                break;
        }
        datasource.setDriver(driver);
        String url = loadDBUrl(rb);
        datasource.setUrl(url);
        datasource.setUsername(rb.getString("db.userName"));
        datasource.setPassword(rb.getString("db.password"));
    }

    /**
     * Класс для представления данных полученых из БД в виде списка определенного типа.
     * @param <T extends Table>
     * @param rs ResultSet
     * @param cls тип данных.
     * @return list<T>
     * @throws SQLException
     * @throws InvocationTargetException
     * @throws ReflectiveOperationException 
     */
    protected <T extends Table> List<T> parse(String query, Class<T> cls) throws SQLException, InvocationTargetException, ReflectiveOperationException {
        final Constructor<T> constructor = cls.getDeclaredConstructor();
        constructor.setAccessible(true);
        List<T> list = new ArrayList<>();
        return jdbcTemplate.query(query, new RowMapper<T>() {
            @Override
            public T mapRow(ResultSet rs, int i) throws SQLException {
                T obj = null;
                try {
                    obj = constructor.newInstance();
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
                }
                obj.setValue(rs);
                return obj;
            }
        });
    }
    
    protected <T extends Table> List<T> parse(String query, Object[] params, Class<T> cls) throws SQLException, InvocationTargetException, ReflectiveOperationException {
        final Constructor<T> constructor = cls.getDeclaredConstructor();
        constructor.setAccessible(true);
                
        return jdbcTemplate.query(query, params, new RowMapper<T>() {
            @Override
            public T mapRow(ResultSet rs, int i) throws SQLException {
                T obj = null;
                try {
                    obj = constructor.newInstance();
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
                }
                obj.setValue(rs);
                return obj;
            }
        });
    }
    

    /**
     * Формируем URL для подключения к БД.
     * @param rb ResourceBundle с файлом с параметрами подключения.
     * @return строка подключения.
     */
    private String loadDBUrl(ResourceBundle rb) {
        return new StringBuilder()
                .append(rb.getString("db.driver"))
                .append("://")
                .append(rb.getString("db.host"))
                .append(":")
                .append(rb.getString("db.port"))
                .append("/")
                .append(rb.getString("db.name"))
                .toString();
    }

    protected void executeQuery(String sql) {
        jdbcTemplate.execute(sql);
    }
    
    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
