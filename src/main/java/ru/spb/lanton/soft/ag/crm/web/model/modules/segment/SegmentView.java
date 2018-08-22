package ru.spb.lanton.soft.ag.crm.web.model.modules.segment;

import java.sql.ResultSet;
import java.sql.SQLException;
import ru.spb.lanton.soft.ag.crm.web.model.Table;

/**
 *
 * @author antoxa
 */
public class SegmentView extends Table {
    
    private Integer id;

    private String face;
    
    private String status;
    
    private String license;
    
    private String category;
    
    private String territory;
    
    private Integer yearAuto;
    
    private String fromAuto;
    
    private Integer powerAuto;
    
    private String countDriver;
    
    private Integer yearOld;
    
    private Integer yearLicense;
    
    private Double kbm;
    
    private String company;
    
    private Double kv;
    
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public Integer getYearAuto() {
        return yearAuto;
    }

    public void setYearAuto(Integer yearAuto) {
        this.yearAuto = yearAuto;
    }

    public String getFromAuto() {
        return fromAuto;
    }

    public void setFromAuto(String fromAuto) {
        this.fromAuto = fromAuto;
    }

    public Integer getPowerAuto() {
        return powerAuto;
    }

    public void setPowerAuto(Integer powerAuto) {
        this.powerAuto = powerAuto;
    }

    public String getCountDriver() {
        return countDriver;
    }

    public void setCountDriver(String countDriver) {
        this.countDriver = countDriver;
    }

    public Integer getYearOld() {
        return yearOld;
    }

    public void setYearOld(Integer yearOld) {
        this.yearOld = yearOld;
    }

    public Integer getYearLicense() {
        return yearLicense;
    }

    public void setYearLicense(Integer yearLicense) {
        this.yearLicense = yearLicense;
    }

    public Double getKbm() {
        return kbm;
    }

    public void setKbm(Double kbm) {
        this.kbm = kbm;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getKv() {
        return kv;
    }

    public void setKv(Double kv) {
        this.kv = kv;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public void setValue(ResultSet rs) throws SQLException {
        setId(rs.getInt("id"));
        setFace(rs.getString("face"));
        setStatus(rs.getString("status"));
        setLicense(rs.getString("license"));
        setCategory(rs.getString("category"));
        setTerritory(rs.getString("territory"));
        setYearAuto(rs.getInt("yearauto"));
        setFromAuto(rs.getString("fromauto"));
        setPowerAuto(rs.getInt("powerauto"));
        setCountDriver(rs.getString("countdriver"));
        setYearOld(rs.getInt("yearold"));
        setYearLicense(rs.getInt("yearlicense"));
        setKbm(rs.getDouble("kbm"));
        setCompany(rs.getString("company"));
        setKv(rs.getDouble("kv"));
        setComment(rs.getString("comment"));
    }

    @Override
    public String getAllValueQuery() {
        return "SELECT * FROM SegmentView";
    }
    
    
    
}
