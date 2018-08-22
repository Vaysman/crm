package ru.spb.lanton.soft.ag.crm.web.model.modules.segment;

import java.sql.ResultSet;
import java.sql.SQLException;
import ru.spb.lanton.soft.ag.crm.web.model.Table;

/**
 *
 * @author antoxa
 */
public class Segment extends Table {

    private int id;

    private int face_id;
    
    private int status_id;
    
    private int license_id;
    
    private int category_id;
    
    private int territory_id;
    
    private int yearAuto;
    
    private int fromAuto_id;
    
    private int powerAuto;
    
    private int countDriver;
    
    private int yearOld;
    
    private int yearLicense;
    
    private double kbm;
    
    private int company_id;
    
    private double kv;
    
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFace_id() {
        return face_id;
    }

    public void setFace_id(int face_id) {
        this.face_id = face_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getLicense_id() {
        return license_id;
    }

    public void setLicense_id(int license_id) {
        this.license_id = license_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getTerritory_id() {
        return territory_id;
    }

    public void setTerritory_id(int territory_id) {
        this.territory_id = territory_id;
    }

    public int getYearAuto() {
        return yearAuto;
    }

    public void setYearAuto(int yearAuto) {
        this.yearAuto = yearAuto;
    }

    public int getFromAuto_id() {
        return fromAuto_id;
    }

    public void setFromAuto_id(int fromAuto_id) {
        this.fromAuto_id = fromAuto_id;
    }

    public int getPowerAuto() {
        return powerAuto;
    }

    public void setPowerAuto(int powerAuto) {
        this.powerAuto = powerAuto;
    }

    public int getCountDriver() {
        return countDriver;
    }

    public void setCountDriver(int countDriver) {
        this.countDriver = countDriver;
    }

    public int getYearOld() {
        return yearOld;
    }

    public void setYearOld(int yearOld) {
        this.yearOld = yearOld;
    }

    public int getYearLicense() {
        return yearLicense;
    }

    public void setYearLicense(int yearLicense) {
        this.yearLicense = yearLicense;
    }

    public double getKbm() {
        return kbm;
    }

    public void setKbm(double kbm) {
        this.kbm = kbm;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public double getKv() {
        return kv;
    }

    public void setKv(double kv) {
        this.kv = kv;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public void setValue(Segment segment) {
    id = segment.getId();
    face_id = segment.getFace_id();
    status_id = segment.getStatus_id();    
    license_id = segment.getLicense_id();    
    category_id = segment.getCategory_id();    
    territory_id = segment.getTerritory_id();    
    yearAuto = segment.getYearAuto();    
    fromAuto_id = segment.getFromAuto_id();    
    powerAuto = segment.getPowerAuto();    
    countDriver = segment.getCountDriver();
    yearOld = segment.getYearOld();    
    yearLicense = segment.getYearLicense();    
    kbm = segment.getKbm();    
    company_id = segment.getCompany_id();    
    kv = segment.getKv();    
    comment = segment.getComment();
    }

    @Override
    public void setValue(ResultSet rs) throws SQLException {
        setId(rs.getInt("id"));
        setFace_id(rs.getInt("face_id"));
        setStatus_id(rs.getInt("status_id"));
        setLicense_id(rs.getInt("license_id"));
        setCategory_id(rs.getInt("category_id"));
        setTerritory_id(rs.getInt("territory_id"));
        setYearAuto(rs.getInt("yearauto"));
        setFromAuto_id(rs.getInt("fromauto_id"));
        setPowerAuto(rs.getInt("powerauto"));
        setCountDriver(rs.getInt("countdriver_id"));
        setYearOld(rs.getInt("yearold"));
        setYearLicense(rs.getInt("yearlicense"));
        setKbm(rs.getDouble("kbm"));
        setCompany_id(rs.getInt("company_id"));
        setKv(rs.getDouble("kv"));
        setComment(rs.getString("comment"));
    }    

    @Override
    public String getAllValueQuery() {
        return "SELECT * FROM segment";
    }
    

}
