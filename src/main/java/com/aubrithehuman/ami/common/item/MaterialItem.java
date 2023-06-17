package com.aubrithehuman.ami.common.item;

import java.util.List;

import javax.annotation.Nullable;

import com.aubrithehuman.ami.AMI;
import com.aubrithehuman.ami.api.item.BaseItem;
import com.aubrithehuman.ami.api.item.material.Material;
import com.aubrithehuman.ami.api.item.material.MaterialState;
import com.aubrithehuman.ami.api.item.material.properties.MaterialForm;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class MaterialItem extends BaseItem {
	
	final ResourceLocation materialDefinition;
	
	final MaterialForm form;
	MaterialState state;

	public MaterialItem(Properties properties, ResourceLocation material, MaterialForm form) {
		super(properties);
		this.materialDefinition = material;
		this.form = form;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> text, TooltipFlag flag) {
		//put our description in
				
		super.appendHoverText(stack, level, text, flag);
	}

	/**
	 * Give us a code for the shift description
	 */
	@Override
	public String[] getShiftDescKey() {
		return new String[] {
				"itemShiftLine.materialdesc",
				"itemShiftDesc." + AMI.MOD_ID + "." + form.getId()	
		};
	}
	
	/**
	 * Give us a code for the shift description
	 */
	@Override
	public String[] getControlDescKey() {
		return null;
	}
	
	@Override
	public String[] getAltDescKey() {
		return new String[] {
				"itemAltLine.materialproperties",
				""	
		};
	}
	
}
