package ru.spb.lanton.soft.ag.crm.web.model.greencard;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.spb.lanton.soft.ag.crm.web.exceptions.NotPeriodException;

public class Polis {
    
    private int id;
    
    private int type_id;
    
    private int insurance_id;
    
    private int number;
    
    private int seria;
    
    private int status_id;    
            
    private Date date_sale;
    
    private int period; // период страхования: 15 дней, 1-12 месяцев.
    
    private int territory_id;
            
    private int staff_id;
            
    private int client_id;
            
    private int vehicle_id;
    
    private List<Integer> periods;

    public Polis() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15};
        periods = Arrays.asList(arr);
    }
    
    public boolean validate() {
        // TODO
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getInsurance_id() {
        return insurance_id;
    }

    public void setInsurance_id(int insurance_id) {
        this.insurance_id = insurance_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSeria() {
        return seria;
    }

    public void setSeria(int seria) {
        this.seria = seria;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public Date getDate_sale() {
        return date_sale;
    }

    public void setDate_sale(Date date_sale) {
        this.date_sale = date_sale;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) throws NotPeriodException {
        if (periods.contains(period)) {
            this.period = period;
        }
        else {
            this.period = 1;
            throw new NotPeriodException("Piriod is wrong! Period can be: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15. Default set id 1 month.");
        }
    }

    public int getTerritory_id() {
        return territory_id;
    }

    public void setTerritory_id(int territory_id) {
        this.territory_id = territory_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }
    
    
    
}
