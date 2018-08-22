package ru.spb.lanton.soft.ag.crm.web.model.greencard;

public class Client {
    
    private int id;
    
    private String name;

    private String lastName;
    
    private String fatherName;
    
    private String name_ENG;

    private String lastName_ENG;

    private int passport_rf_id;

    private int passport_rf_intern_id;

    private int passport_foreing_id;
    
    private String address_RUS;
    
    private String address_ENG;
    
    private int phone_mobile;

    private int phone_home;

    private int phone_job;

    private String email;

    private boolean married;

    private boolean child;

    public Client() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getName_ENG() {
        return name_ENG;
    }

    public void setName_ENG(String name_ENG) {
        this.name_ENG = name_ENG;
    }

    public String getLastName_ENG() {
        return lastName_ENG;
    }

    public void setLastName_ENG(String lastName_ENG) {
        this.lastName_ENG = lastName_ENG;
    }

    public int getPassport_rf_id() {
        return passport_rf_id;
    }

    public void setPassport_rf_id(int passport_rf_id) {
        this.passport_rf_id = passport_rf_id;
    }

    public int getPassport_rf_intern_id() {
        return passport_rf_intern_id;
    }

    public void setPassport_rf_intern_id(int passport_rf_intern_id) {
        this.passport_rf_intern_id = passport_rf_intern_id;
    }

    public int getPassport_foreing_id() {
        return passport_foreing_id;
    }

    public void setPassport_foreing_id(int passport_foreing_id) {
        this.passport_foreing_id = passport_foreing_id;
    }

    public int getPhone_mobile() {
        return phone_mobile;
    }

    public void setPhone_mobile(int phone_mobile) {
        this.phone_mobile = phone_mobile;
    }

    public int getPhone_home() {
        return phone_home;
    }

    public void setPhone_home(int phone_home) {
        this.phone_home = phone_home;
    }

    public int getPhone_job() {
        return phone_job;
    }

    public void setPhone_job(int phone_job) {
        this.phone_job = phone_job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public boolean isChild() {
        return child;
    }

    public void setChild(boolean child) {
        this.child = child;
    }
   
    

}
