package com.bankino.training.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CONFIG")
public class Config implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Column(name = "CONFIG_TYPE")
private String configType;

@Column(name = "CONFIG_KEY")
private String configKey;

@Column(name = "CONFIG_VALUE")
private String configValue;

public Config(String configType, String configKey, String configValue) {
	this.configType = configType;
	this.configKey = configKey;
	this.configValue = configValue;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getConfigType() {
	return configType;
}

public void setConfigType(String configType) {
	this.configType = configType;
}

public String getConfigKey() {
	return configKey;
}

public void setConfigKey(String configKey) {
	this.configKey = configKey;
}

public String getConfigValue() {
	return configValue;
}

public void setConfigValue(String configValue) {
	this.configValue = configValue;
}
}
