package com.aubrithehuman.ami.api.item.material.properties;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.checkerframework.checker.nullness.qual.NonNull;

public class MaterialProperties {

	String name;
	String translation;
	int color;
	LinkedHashSet<MaterialForm> forms;
//	TagKey<Item> tag;
	
	/**
	 * predefined sets of forms can be found in MaterialForm.Groups
	 * @param name
	 * @param forms
	 */
	public MaterialProperties(String name, @NonNull LinkedHashSet<MaterialForm> forms) {
		this.name = name;
		this.forms = forms;
	}
	
	public MaterialProperties(String name) {
		this.name = name;
		this.forms = new LinkedHashSet<>();
	}
	
	public String getName() {
		return name;
	}

	public int getColor() {
		return color;
	}

	public Set<MaterialForm> getForms() {
		return forms;
	}

//	public TagKey<Item> getTag() {
//		return tag;
//	}
	
	public String getTranslation() { return this.translation; }

	
	
	
	// Builders
	
	
	public MaterialProperties withTranslation(String trans) {
		this.translation = trans;
		return this;
	}
	
	public MaterialProperties withColor(int color) {
		this.color = color;
		return this;
	}
	
	public MaterialProperties withForm(MaterialForm form) {
		this.forms.add(form);
		return this;
	}
	
	public MaterialProperties withForms(LinkedHashSet<MaterialForm> forms) {
		this.forms.addAll(forms);
		return this;
	}
	
	public MaterialProperties withForms(MaterialForm[] forms) {
		for (MaterialForm form : forms) this.forms.add(form);
		return this;
	}
	
	public MaterialProperties withForms(List<MaterialForm> forms) {
		for (MaterialForm form : forms) this.forms.add(form);
		return this;
	}
	
}