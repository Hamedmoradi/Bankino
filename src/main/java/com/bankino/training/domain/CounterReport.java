package com.bankino.training.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "COUNTER_REPORT")
public class CounterReport implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Column(name = "START_DATE")
private Date startDate;

@Column(name = "END_DATE")
private Date endDate;

@Column(name = "HOUR")
private Integer hour;

@JoinColumn(name = "GEOGRAPHICAL_AREA_COUNTER_ID")
@ManyToOne
private GeographicalAreaCounter geographicalAreaCounter;

@JoinColumn(name = "COUNTER_ID")
@ManyToOne
private Counter counter;

@Column(name = "USAGE")
private BigDecimal usage;

@Column(name = "SEND_CONFIRMATION_DATA")
private boolean sendConfirmationData;

	public CounterReport() {
	}

	public CounterReport(Date startDate, Date endDate, Integer hour, GeographicalAreaCounter geographicalAreaCounter,
						 Counter counter, BigDecimal usage, boolean sendConfirmationData) {
	this.startDate = startDate;
	this.endDate = endDate;
	this.hour = hour;
	this.geographicalAreaCounter = geographicalAreaCounter;
	this.counter = counter;
	this.usage = usage;
	this.sendConfirmationData = sendConfirmationData;
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

public Integer getHour() {
	return hour;
}

public void setHour(Integer hour) {
	this.hour = hour;
}

public GeographicalAreaCounter getGeographicalAreaCounter() {
	return geographicalAreaCounter;
}

public void setGeographicalAreaCounter(GeographicalAreaCounter geographicalAreaCounter) {
	this.geographicalAreaCounter = geographicalAreaCounter;
}

public Counter getCounter() {
	return counter;
}

public void setCounter(Counter counter) {
	this.counter = counter;
}

public BigDecimal getUsage() {
	return usage;
}

public void setUsage(BigDecimal usage) {
	this.usage = usage;
}

public boolean isSendConfirmationData() {
	return sendConfirmationData;
}

public void setSendConfirmationData(boolean sendConfirmationData) {
	this.sendConfirmationData = sendConfirmationData;
}
}
