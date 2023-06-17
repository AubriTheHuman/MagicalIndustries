package com.aubrithehuman.ami.api.item.material.registry;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;

import com.aubrithehuman.ami.api.item.material.Material;
import com.aubrithehuman.ami.api.item.material.properties.MaterialProperties;

import net.minecraft.resources.ResourceLocation;

public abstract class MaterialRegistry {
		
		
	private static Map<ResourceLocation, Material> data = new HashMap<>();
	
	/**
	 * When extending, the materials get added by the superconstructor
	 * @param logger
	 */
	public MaterialRegistry(Logger logger) {
		addMaterials(logger);	
	}
	
	/**
	 * This is where you register a material
	 * @param logger
	 */
	public abstract void addMaterials(Logger logger);
	
	public void build(ResourceLocation namespace, MaterialProperties properties, Logger logger) {
		data.put(namespace, create(namespace.toString(), properties, logger));
	}
	
	/**
	 * Create a material from a properties class
	 * @param name
	 * @param properties
	 * @param logger
	 * @return
	 */
	public Material create(String name, MaterialProperties properties, Logger logger) {
		return new Material(name, properties, logger);
	}

	/**
	 * Reference this from your material registry instance
	 * @return
	 */
	public Map<ResourceLocation, Material> getData() {
		return data;
	}
	
}
