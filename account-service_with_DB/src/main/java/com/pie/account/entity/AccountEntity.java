package com.pie.account.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import java.time.LocalDate;

@Entity
@Table(name="Account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "accountNo")
    private Long accountNo;

    // @Column(name = "account_type")
    private String 	accountType;

    //@Column(name = "opening_date")
    private LocalDate  openingDate;

    private double balance;

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountEntity(String accountType, LocalDate openingDate, double balance) {
        super();
        this.accountType = accountType;
        this.openingDate = openingDate;
        this.balance = balance;
    }

    public AccountEntity() {

    }

    @Override
    public String toString() {
        return "AccountEntity [accountNo=" + accountNo + ", accountType=" + accountType + ", openingDate="
                + openingDate + ", balance=" + balance + "]";
    }

}
