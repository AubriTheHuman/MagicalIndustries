package com.aubrithehuman.ami.api.item.material.properties;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum MaterialForm {

	//Metals
	NORMAL(""),
	INGOT("ingot"),
	NUGGET("nugget"),
	BLOCK("block"),
	CAKE("cake"),
	BAR_STOCK("bar_stock"),
	SHEET("sheet"),
	ROUNDED_SHEET("rounded_sheet"),
	LARGE_SHEET("large_sheet"),
	COIL("coil"),
	WIRE("wire"),
	ROD("rod"),
	SPRING("spring"),
	SCREW("screw"),
	BOLT("bolt"),
	GEAR("gear"),
	MECHANICAL_COMPONENT("mechanical_component"),
	DUST("dust"),
	TINY_DUST("tiny_dust");
	
	String id;
	MaterialForm[] sources;
	
	MaterialForm(String id, MaterialForm... sources) {
		this.id = id;
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
