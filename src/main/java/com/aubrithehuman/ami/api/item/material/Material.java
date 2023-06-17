package com.aubrithehuman.ami.api.item.material;

import org.slf4j.Logger;

import com.aubrithehuman.ami.api.item.material.properties.MaterialProperties;

public class Material {	
	
	public final String name;
	public final MaterialProperties properties;
	
	public Material(String nameIn, MaterialProperties propertiesIn, Logger logger) {
		this.name = nameIn;
		this.properties = propertiesIn;
		logger.debug("Registered material [name:\"" + name + "\"]");
	}
	
	public String getName() {
		return name;
	}
	
}
