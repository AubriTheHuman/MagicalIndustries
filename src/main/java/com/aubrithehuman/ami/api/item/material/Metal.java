package com.aubrithehuman.ami.api.item.material;

import org.slf4j.Logger;

import com.aubrithehuman.ami.api.item.material.properties.MetalProperties;

public class Metal extends Material {

	public Metal(String nameIn, MetalProperties propertiesIn, Logger logger) {
		super(nameIn, propertiesIn, logger);
	}
}
