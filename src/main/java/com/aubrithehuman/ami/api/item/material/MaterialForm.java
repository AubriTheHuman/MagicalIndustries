package com.aubrithehuman.ami.api.item.material;

public enum MaterialForm {

	INGOT("ingot", 0),
	NUGGET("nugget", 1),
	BLOCK("block", 2),
	CAKE("cake", 3),
	BAR_STOCK("bar_stock", 4),
	SHEET("sheet", 5),
	ROUNDED_SHEET("rounded_sheet", 6),
	LARGE_SHEET("large_sheet", 7),
	COIL("coil", 8),
	WIRE("wire", 9),
	ROD("rod", 10),
	BOLT("bolt", 11),
	GEAR("gear", 12),
	MECHANICAL_COMPONENT("mechanical_component", 13),
	DUST("dust", 14),
	TINY_DUST("tiny_dust", 15);
	
	String id;
	int key;
	MaterialForm[] sources;
	
	MaterialForm(String id, int key, MaterialForm... sources) {
		this.id = id;
		this.key = key;
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
	
	public int getKey() {
		return this.key;
	}
	
	public MaterialForm[] getSources() {
		return this.sources;
	}
}
