package com.seamfix.nin.model;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;


@Entity
public class NairaWallet extends AbstractEntity {

    private String     walletRequestId;
    private BigDecimal chargeAmount;
    private BigDecimal debitAmount;
    private BigDecimal debitCurrency;
    private BigDecimal creditAmount;
    private BigDecimal availableAmount;


   @OneToOne
   private Users users;

    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public BigDecimal getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
    }


    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public BigDecimal getDebitCurrency() {
        return debitCurrency;
    }

    public void setDebitCurrency(BigDecimal debitCurrency) {
        this.debitCurrency = debitCurrency;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }


    public String getWalletRequestId() {
        return walletRequestId;
    }

    public void setWalletRequestId(String walletRequestId) {
        this.walletRequestId = walletRequestId;
    }



}
