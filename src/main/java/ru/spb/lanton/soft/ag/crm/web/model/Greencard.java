package ru.spb.lanton.soft.ag.crm.web.model;

import javax.enterprise.inject.Model;

@Model
public class Greencard {

    private Polis polis;
    
    private Client client;
    
    private Auto auto;
    
    public Greencard() {
    }
    
    public Polis getPolis() {
        return polis;
    }

    public void setPolis(Polis polis) {
        this.polis = polis;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    

}
