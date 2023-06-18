package com.aubrithehuman.ami.datagen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.jetbrains.annotations.Nullable;

import com.aubrithehuman.ami.AMI;
import com.aubrithehuman.ami.api.item.material.properties.MaterialForm;
import com.aubrithehuman.ami.common.init.AMIItemTags;
import com.aubrithehuman.ami.common.init.AMIItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AMIItemTagsProvider extends ItemTagsProvider {



	public AMIItemTagsProvider(DataGenerator p_126530_, BlockTagsProvider p_126531_, String modId,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(p_126530_, p_126531_, modId, existingFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
    protected void addTags() {
		AMI.LOGGER.info("Creating Material Tags");
		for (ResourceLocation material : AMI.MATERIALS.getData().keySet()) {
			for(MaterialForm form : AMI.MATERIALS.get(material).getProperties().getForms()) {
				//add to type specific and all to main tag
				this.tag(AMIItemTags.MATERIAL_TYPED_TAGS.get(material).get(form)).add(AMIItems.MATERIAL_ITEMS.get(material).get(form).get()).replace();
				
				this.tag(AMIItemTags.MATERIAL_TAGS.get(material)).add(AMIItems.MATERIAL_ITEMS.get(material).get(form).get());

				this.tag(AMIItemTags.TYPE_TAGS.get(form)).add(AMIItems.MATERIAL_ITEMS.get(material).get(form).get()).replace();
				
			}
		}
		
	}
}
