package com.bankino.training.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ELECTRICITY_RATE")
public class ElectricityRate implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@JoinColumn(name = "GEOGRAPHICAL_AREA_COUNTER_ID")
@OneToOne
private GeographicalAreaCounter geographicalAreaCounter;

@Column(name = "PRICE")
private BigDecimal price;

	public ElectricityRate() {

	}

public ElectricityRate(GeographicalAreaCounter geographicalAreaCounter, BigDecimal price) {
	this.geographicalAreaCounter = geographicalAreaCounter;
	this.price = price;
}



	public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public GeographicalAreaCounter getGeographicalAreaCounter() {
	return geographicalAreaCounter;
}

public void setGeographicalAreaCounter(GeographicalAreaCounter geographicalAreaCounter) {
	this.geographicalAreaCounter = geographicalAreaCounter;
}

public BigDecimal getPrice() {
	return price;
}

public void setPrice(BigDecimal price) {
	this.price = price;
}
}
