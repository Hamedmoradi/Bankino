package com.bankino.training.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "COUNTER_ALARM")
public class CounterAlarm implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Column(name = "ALARM_NAME")
private String alarmName;

@Column(name = "ALARM_TYPE")
private String alarmType;

@Column(name = "COUNTER_ID")
private Counter counter;

@Column(name = "ALARM_DATE")
private Date alarmDate;

public CounterAlarm(String alarmName, String alarmType, Counter counter, Date alarmDate) {
	this.alarmName = alarmName;
	this.alarmType = alarmType;
	this.counter = counter;
	this.alarmDate = alarmDate;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getAlarmName() {
	return alarmName;
}

public void setAlarmName(String alarmName) {
	this.alarmName = alarmName;
}

public String getAlarmType() {
	return alarmType;
}

public void setAlarmType(String alarmType) {
	this.alarmType = alarmType;
}

public Counter getCounter() {
	return counter;
}

public void setCounter(Counter counter) {
	this.counter = counter;
}

public Date getAlarmDate() {
	return alarmDate;
}

public void setAlarmDate(Date alarmDate) {
	this.alarmDate = alarmDate;
}
}
