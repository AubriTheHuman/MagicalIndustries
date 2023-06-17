package com.aubrithehuman.ami.common.init;

import org.slf4j.Logger;

import com.aubrithehuman.ami.AMI;
import com.aubrithehuman.ami.api.item.material.properties.MetalProperties;
import com.aubrithehuman.ami.api.item.material.registry.MaterialRegistry;

import net.minecraft.resources.ResourceLocation;

public class AMIMaterialDefinitions extends MaterialRegistry {

	public AMIMaterialDefinitions(Logger logger) {
		super(logger);
	}

	@Override
	public void addMaterials(Logger logger) {
		//metals
		build(new ResourceLocation(AMI.MOD_ID, "iron"), new MetalProperties(), logger);		
		//nonmetal
		
	}

}
