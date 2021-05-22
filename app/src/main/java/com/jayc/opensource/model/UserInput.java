package com.jayc.opensource.model;

public class UserInput {

    private String paid;
    private String alternative;
    private String id;

    public UserInput(String paid, String alternative, String id) {
        this.paid = paid;
        this.alternative = alternative;
    }

    public UserInput(String paid, String alternative) {
        this.paid = paid;
        this.alternative = alternative;
    }

    public UserInput() {

    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
