package com.jayc.opensource;

public class MainDatabaseModel {
    private String paid;
    private String id;
    private String alternative1;
    private String alternative2;
    private String alternative3;

    public MainDatabaseModel(String paid, String alternative1, String alternative2, String alternative3) {
        this.paid = paid;
        this.alternative1 = alternative1;
        this.alternative2 = alternative2;
        this.alternative3 = alternative3;
    }

    public MainDatabaseModel(String paid, String alternative1, String alternative2) {
        this.paid = paid;
        this.alternative1 = alternative1;
        this.alternative2 = alternative2;
    }

    public MainDatabaseModel(String paid, String alternative1) {
        this.paid = paid;
        this.alternative1 = alternative1;
    }

    public MainDatabaseModel() {

    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlternative1() {
        return alternative1;
    }

    public void setAlternative1(String alternative1) {
        this.alternative1 = alternative1;
    }

    public String getAlternative2() {
        return alternative2;
    }

    public void setAlternative2(String alternative2) {
        this.alternative2 = alternative2;
    }

    public String getAlternative3() {
        return alternative3;
    }

    public void setAlternative3(String alternative3) {
        this.alternative3 = alternative3;
    }
}

