package com.aubrithehuman.ami.common.init;

import java.util.HashMap;
import java.util.Map;

import com.aubrithehuman.ami.AMI;
import com.aubrithehuman.ami.api.item.material.properties.MaterialForm;
import com.aubrithehuman.ami.common.tag.TagGenerator;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class AMIItemTags {

//	 public static final TagKey<Block> NEEDS_EXAMPLE_TOOL = create("mineable/needs_example_tool");

	public static final Map<ResourceLocation, Map<MaterialForm, TagKey<Item>>> MATERIAL_TYPED_TAGS = new HashMap<>();
	public static final Map<ResourceLocation, TagKey<Item>> MATERIAL_TAGS = new HashMap<>();
	public static final Map<MaterialForm, TagKey<Item>> TYPE_TAGS = new HashMap<>();
	
	public AMIItemTags() {
		
		AMI.LOGGER.info("Creating Material Tags");
		for (ResourceLocation material : AMI.MATERIALS.getData().keySet()) {
			Map<MaterialForm, TagKey<Item>> materialFormsMap = new HashMap<>();
			for(MaterialForm form : MaterialForm.values()) {
				materialFormsMap.put(form, TagGenerator.itemForge(material.getPath() + "/" + form.getId()));
			}
			MATERIAL_TAGS.put(material, TagGenerator.itemForge(material.getPath()));
			MATERIAL_TYPED_TAGS.put(material, materialFormsMap);	
		}
		for(MaterialForm form : MaterialForm.values()) {
			TYPE_TAGS.put(form, TagGenerator.itemForge(form.getId()));
		}
		
	}
}
