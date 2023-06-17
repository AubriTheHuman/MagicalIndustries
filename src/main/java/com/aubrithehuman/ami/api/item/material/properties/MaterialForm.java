package com.aubrithehuman.ami.api.item.material.properties;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum MaterialForm {

	//Metals
	NORMAL("", ""),
	INGOT("ingot", "Ingot"),
	NUGGET("nugget", "Nugget"),
	BLOCK("block", "Block"),
	CAKE("cake", "Cake"),
	BAR_STOCK("bar_stock", "Bar Stock"),
	SHEET("sheet", "Sheet"),
	ROUNDED_SHEET("rounded_sheet", "Rounded Sheet"),
	LARGE_SHEET("large_sheet", "Large Sheet"),
	COIL("coil", "Coil"),
	WIRE("wire", "Wire"),
	ROD("rod", "Rod"),
	SPRING("spring", "Spring"),
	SCREW("screw", "Screw"),
	BOLT("bolt", "Bolt"),
	GEAR("gear", "Gear"),
	MECHANICAL_COMPONENT("mechanical_component", "Mechanical Component"),
	DUST("dust", "Dust"),
	TINY_DUST("tiny_dust", "Tiny Piles of Dust");
	
	String id;
	String translation;
	MaterialForm[] sources;
	
	/**
	 * Translation only exists for datagen, it serves no purpose
	 * @param id
	 * @param translation
	 * @param sources
	 */
	MaterialForm(String id, String translation, MaterialForm... sources) {
		this.id = id;
		this.translation = translation;
		this.sources = sources;
	}
	
	public static MaterialForm getByID(String in) {
		for(MaterialForm form : MaterialForm.values()) {
			if(form.id.equalsIgnoreCase(in)) return form;
		}
		return MaterialForm.INGOT;
	}
	
	public String getId() {
		return this.id;
	}
	public String getTranslation() {
		return this.translation;
	}
	
	public MaterialForm[] getSources() {
		return this.sources;
	}
	
	public static enum Groups {
		
		METALS(MaterialForm.INGOT, MaterialForm.NUGGET, MaterialForm.BLOCK, MaterialForm.CAKE, MaterialForm.BAR_STOCK, MaterialForm.SHEET, 
				MaterialForm.ROUNDED_SHEET, MaterialForm.LARGE_SHEET, MaterialForm.COIL, MaterialForm.WIRE, MaterialForm.ROD, MaterialForm.SPRING, 
				MaterialForm.SCREW, MaterialForm.BOLT, MaterialForm.GEAR, MaterialForm.MECHANICAL_COMPONENT, MaterialForm.DUST, MaterialForm.TINY_DUST);
		
		final Set<MaterialForm> types;
		
		Groups(MaterialForm... types) {
			this.types = Arrays.stream(types).collect(Collectors.toSet());
		}
		
		public Set<MaterialForm> getContainedTypes() {
			return this.types;
		}
		
		
	}
}
