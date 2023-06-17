package com.aubrithehuman.ami.api.item.material;

public enum MaterialState {

	FROZEN("Frozen"),
	SOLID("Solid"),
	HEATED_PLASTIC("Heated"),
	HEATED_ELASTIC("Heated"),
	LIQUID("Liquid"),
	MOLTEN("Molten"),
	VAPOR("Vapor"),
	GASEOUS("Gaseous"),
	PLASMA("Plasma");
	
	String displayName;
	
	MaterialState(String disp) {
		displayName = disp;
	}
	
	public String getDisplayName() {
		return displayName;
	}
}
