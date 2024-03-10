package com.app.employeemanagementsystem.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long houseRentAllowance;
    private Long fixedAmount;
    private Long providentFund;
    private Long professionalTax;
    private Long incomeTax;
    private Long specialAllowance;
    private LocalDate dateOfPayment = LocalDate.now();
    private String month;
    private Long year;
    private Boolean paid = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Salary() {
    }

    public Salary(Long id, Long houseRentAllowance, Long fixedAmount, Long providentFund, Long professionalTax, Long incomeTax, Long specialAllowance, LocalDate dateOfPayment, String month, Long year, Boolean paid) {
        this.id = id;
        this.houseRentAllowance = houseRentAllowance;
        this.fixedAmount = fixedAmount;
        this.providentFund = providentFund;
        this.professionalTax = professionalTax;
        this.incomeTax = incomeTax;
        this.specialAllowance = specialAllowance;
        this.dateOfPayment = dateOfPayment;
        this.month = month;
        this.year = year;
        this.paid = paid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHouseRentAllowance() {
        return houseRentAllowance;
    }

    public void setHouseRentAllowance(Long houseRentAllowance) {
        this.houseRentAllowance = houseRentAllowance;
    }

    public Long getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(Long fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    public Long getProvidentFund() {
        return providentFund;
    }

    public void setProvidentFund(Long providentFund) {
        this.providentFund = providentFund;
    }

    public Long getProfessionalTax() {
        return professionalTax;
    }

    public void setProfessionalTax(Long professionalTax) {
        this.professionalTax = professionalTax;
    }

    public Long getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(Long incomeTax) {
        this.incomeTax = incomeTax;
    }

    public Long getSpecialAllowance() {
        return specialAllowance;
    }

    public void setSpecialAllowance(Long specialAllowance) {
        this.specialAllowance = specialAllowance;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", houseRentAllowance=" + houseRentAllowance +
                ", fixedAmount=" + fixedAmount +
                ", providentFund=" + providentFund +
                ", professionalTax=" + professionalTax +
                ", incomeTax=" + incomeTax +
                ", specialAllowance=" + specialAllowance +
                ", dateOfPayment=" + dateOfPayment +
                ", month='" + month + '\'' +
                ", year=" + year +
                ", paid=" + paid +
                ", user=" + user +
                '}';
    }
}
