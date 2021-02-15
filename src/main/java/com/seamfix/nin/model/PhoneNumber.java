package com.seamfix.nin.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PhoneNumber extends AbstractEntity {

    @ManyToOne
    private Users user;

    String phoneNumber;

    private String ninLinkingStatus="N";


    public String getNinLinkingStatus() {
        return ninLinkingStatus;
    }

    public void setNinLinkingStatus(String ninLinkingStatus) {
        this.ninLinkingStatus = ninLinkingStatus;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
