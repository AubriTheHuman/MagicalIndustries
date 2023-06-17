package com.aubrithehuman.ami.datagen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.aubrithehuman.ami.AMI;
import com.aubrithehuman.ami.api.item.material.properties.MaterialForm;
import com.aubrithehuman.ami.common.init.AMIItemTags;
import com.aubrithehuman.ami.common.init.AMIItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.LanguageProvider;

public class AMILangProvider extends LanguageProvider {

	public AMILangProvider(DataGenerator gen, String modid, String locale) {
		super(gen, modid, locale);
	}

	@Override
	protected void addTranslations() {
		//prepare writing to file
		//this does not follow the lang provider system bc im doin wierd shit
		
		File lang = new File("C:\\Users\\aubri\\Desktop\\Modding\\MagicalIndustries\\src\\generated\\ami_en_us.txt");
		
	    try {
			if (lang.createNewFile()) {
			    System.out.println("File created: " + lang.getName());
			} else {
			    System.out.println("File already exists. clearing");
			    
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    FileWriter writer = null;
		try {
			writer = new FileWriter(lang);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(writer == null ) {
			throw new NullPointerException();
		}

		// ===========================================================================================================================================
		/**
		 * WRITING
		 */
		try {
			AMI.LOGGER.info("Creating Material Tags");
			for (ResourceLocation material : AMI.MATERIALS.getData().keySet()) {
				for(MaterialForm form : AMI.MATERIALS.get(material).getProperties().getForms()) {
					//add to type specific and all to main tag
					if(form == MaterialForm.NORMAL) continue;
					writer.write("	\"tag.item.forge." + material.getPath() + "." + form.getId() + "\": \"" + 
					AMI.MATERIALS.get(material).getProperties().getTranslation() + " " + form.getTranslation() + "s\",\n");
					
				}
			}
			
			for (ResourceLocation material : AMI.MATERIALS.getData().keySet()) {
				writer.write("	\"tag.item.forge." + material.getPath() + "\": \"" + 
						AMI.MATERIALS.get(material).getProperties().getTranslation() + " Parts and Materials\",\n");
			}

			for(MaterialForm form : MaterialForm.values()) {
				if(form == MaterialForm.NORMAL) continue;
				writer.write("	\"tag.item.forge." 
				+ form.getId() + "\": \"" 
				+ form.getTranslation() + "s\",\n");
			}
			
			writer.close();

		// ===========================================================================================================================================
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
