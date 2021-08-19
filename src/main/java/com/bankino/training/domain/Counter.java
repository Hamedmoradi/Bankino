package com.bankino.training.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "COUNTER")
@EntityListeners(AuditingEntityListener.class)
public class Counter implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Column(name = "COUNTER_NO", nullable = false, columnDefinition = "VARCHAR")
private String counterNo;

@JoinColumn(name = "GEOGRAPHICAL_AREA_COUNTER_ID")
@ManyToOne
private GeographicalAreaCounter geographicalAreaCounter;

@Column(name = "COUNTER_CREATE_DATE", nullable = false, updatable = false)
//@CreatedDate
private Date counterCreateDate;

@Column(name = "STATUS")
private Integer status;


public Counter() {
}

public Counter(String counterNo, com.bankino.training.domain.GeographicalAreaCounter geographicalAreaCounter,
               Date counterCreateDate, Integer status) {
	this.counterNo = counterNo;
	this.geographicalAreaCounter = geographicalAreaCounter;
	this.counterCreateDate = counterCreateDate;
	this.status = status;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getCounterNo() {
	return counterNo;
}

public void setCounterNo(String counterNo) {
	this.counterNo = counterNo;
}

public GeographicalAreaCounter getGeographicalAreaCounter() {
	return geographicalAreaCounter;
}

public void setGeographicalAreaCounter(GeographicalAreaCounter geographicalAreaCounter) {
	this.geographicalAreaCounter = geographicalAreaCounter;
}

public Date getCounterCreateDate() {
	return counterCreateDate;
}

public void setCounterCreateDate(Date counterCreateDate) {
	this.counterCreateDate = counterCreateDate;
}

public Integer getStatus() {
	return status;
}

public void setStatus(Integer status) {
	this.status = status;
}
}
