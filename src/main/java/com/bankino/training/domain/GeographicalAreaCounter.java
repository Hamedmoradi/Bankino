package com.bankino.training.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GEOGRAPHICAL_AREA_COUNTER")
@EntityListeners(AuditingEntityListener.class)
public class GeographicalAreaCounter implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Column(name = "province", columnDefinition = "VARCHAR")
private String province;

@Column(name = "city", columnDefinition = "VARCHAR")
private String city;

@Column(name = "county", columnDefinition = "VARCHAR")
private String county;

@Column(name = "village", columnDefinition = "VARCHAR")
private String village;

@Column(name = "municipality", columnDefinition = "VARCHAR")
private String municipality;

@Column(name = "neighborhood", columnDefinition = "VARCHAR")
private String neighborhood;

	public GeographicalAreaCounter() {
	}

	public GeographicalAreaCounter(String province, String city, String county, String village, String municipality, String neighborhood) {
	this.province = province;
	this.city = city;
	this.county = county;
	this.village = village;
	this.municipality = municipality;
	this.neighborhood = neighborhood;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getProvince() {
	return province;
}

public void setProvince(String province) {
	this.province = province;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getCounty() {
	return county;
}

public void setCounty(String county) {
	this.county = county;
}

public String getVillage() {
	return village;
}

public void setVillage(String village) {
	this.village = village;
}

public String getMunicipality() {
	return municipality;
}

public void setMunicipality(String municipality) {
	this.municipality = municipality;
}

public String getNeighborhood() {
	return neighborhood;
}

public void setNeighborhood(String neighborhood) {
	this.neighborhood = neighborhood;
}
}
