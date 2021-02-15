package com.seamfix.nin.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RequestDto {


    @NotEmpty(message = "PhoneNumber is Mandatory")
    @NotBlank(message = "PhoneNumber is Mandatory")
    @Size(min=3, message="Phone Number Entered Does not Match the Numbers of characters required")
    private String phoneNumber;

    @Size(min=3, message="Nin Number Entered Does not Match the Numbers of characters required")
    private String ninNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNinNumber() {
        return ninNumber;
    }

    public void setNinNumber(String ninNumber) {
        this.ninNumber = ninNumber;
    }
}
