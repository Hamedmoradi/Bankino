package com.bankino.training.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ELECTRICITY_PRICE")
public class ElectricityPrice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "TOTAL_HOURS_USAGE")
    private Integer totalHoursUsage;

    @Column(name = "ELECTRICITY_USAGE")
    private BigDecimal electricityUsage;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "CALCULATED")
    private boolean calculated;

    public ElectricityPrice() {

    }

    public ElectricityPrice(Date startDate, Date endDate, Integer totalHoursUsage, BigDecimal electricityUsage, BigDecimal amount, boolean calculated) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalHoursUsage = totalHoursUsage;
        this.electricityUsage = electricityUsage;
        this.amount = amount;
        this.calculated = calculated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getTotalHoursUsage() {
        return totalHoursUsage;
    }

    public void setTotalHoursUsage(Integer totalHoursUsage) {
        this.totalHoursUsage = totalHoursUsage;
    }

    public BigDecimal getElectricityUsage() {
        return electricityUsage;
    }

    public void setElectricityUsage(BigDecimal electricityUsage) {
        this.electricityUsage = electricityUsage;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isCalculated() {
        return calculated;
    }

    public void setCalculated(boolean calculated) {
        this.calculated = calculated;
    }
}
