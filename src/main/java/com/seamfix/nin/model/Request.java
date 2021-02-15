package com.seamfix.nin.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Request extends AbstractEntity {

    Date  requestDateAndTime;

    @Enumerated(EnumType.ORDINAL)
    protected RequestStatus requestStatus;

    @ManyToOne
    Users user;

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Date getRequestDateAndTime() {
        return requestDateAndTime;
    }

    public void setRequestDateAndTime(Date requestDateAndTime) {
        this.requestDateAndTime = requestDateAndTime;
    }
}
