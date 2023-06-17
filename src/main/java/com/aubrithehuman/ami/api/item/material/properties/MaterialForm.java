package com.aubrithehuman.ami.api.item.material.properties;

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
}
