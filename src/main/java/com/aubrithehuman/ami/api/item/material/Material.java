package com.aubrithehuman.ami.api.item.material;

import org.slf4j.Logger;

import com.aubrithehuman.ami.api.item.material.properties.MaterialProperties;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;

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
	
	public MaterialProperties getProperties() {
		return this.properties;
	}	
}
