package com.pragma.foodCourt.domain.model;


public class Restaurant {
    private Long idRestaurant;
    private String name;
    private String nit;
    private String adress;
    private String phoneNumber;
    private String urlLogo;
    private Long idOwner;

    public Restaurant(Long idRestaurant, String name, String nit, String adress, String phoneNumber, String urlLogo, Long idOwner) {
        this.idRestaurant = idRestaurant;
        this.name = name;
        this.nit = nit;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.urlLogo = urlLogo;
        this.idOwner = idOwner;
    }

    public Long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public Long getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Long idOwner) {
        this.idOwner = idOwner;
    }
}

