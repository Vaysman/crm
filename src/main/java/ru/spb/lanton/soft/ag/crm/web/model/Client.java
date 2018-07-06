package ru.spb.lanton.soft.ag.crm.web.model;

public class Client {
    
    private int id;
    
    private String name;

    private String lastName;
    
    private String fatherName;
    
    private String name_ENG;

    private String lastName_ENG;

    private int pasport_seria;

    private int pasport_number;

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

    public int getPasport_seria() {
        return pasport_seria;
    }

    public void setPasport_seria(int pasport_seria) {
        this.pasport_seria = pasport_seria;
    }

    public int getPasport_number() {
        return pasport_number;
    }

    public void setPasport_number(int pasport_number) {
        this.pasport_number = pasport_number;
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
