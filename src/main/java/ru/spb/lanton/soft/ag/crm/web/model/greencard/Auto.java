package ru.spb.lanton.soft.ag.crm.web.model.greencard;

public class Auto {
    
    private int id;

    private String brand;
    
    private String model;
    
    private int type_id;
    
    private int year_builder;
    
    private int power;
    
    private String vin;
    
    private String color;
    
    private long price;
    
    private String reg_number;
    
    private int client_id;
        
    public Auto() {
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

    public int getYear_builder() {
        return year_builder;
    }

    public void setYear_builder(int year_builder) {
        this.year_builder = year_builder;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getReg_number() {
        return reg_number;
    }

    public void setReg_number(String reg_number) {
        this.reg_number = reg_number;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }        

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    

}
