package com.seamfix.nin.model;

import com.seamfix.nin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Users extends  AbstractEntity{

    private String ninNumber;

    private String customerName;


    public String getNinNumber() {
        return ninNumber;
    }

    public void setNinNumber(String ninNumber) {
        this.ninNumber = ninNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
