package com.aubrithehuman.ami.common.item;

import java.util.List;

import javax.annotation.Nullable;

import com.aubrithehuman.ami.AMI;
import com.aubrithehuman.ami.api.item.BaseItem;
import com.aubrithehuman.ami.api.item.material.MaterialForm;
import com.aubrithehuman.ami.api.item.material.MaterialState;

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

	public MaterialItem(Properties properties, ResourceLocation materialDefinition, MaterialForm form) {
		super(properties);
		this.materialDefinition = materialDefinition;
		this.form = form;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> text, TooltipFlag flag) {
		//put our description in
		if(Screen.hasControlDown()) {
			text.add(0, Component.translatable(this.getControlDescKey()));
		} else {
			text.add(0, Component.literal("Press ").withStyle(ChatFormatting.DARK_GRAY).append("[ctrl]").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.GRAY).append(" for item description").withStyle(ChatFormatting.DARK_GRAY));
		}
		
		super.appendHoverText(stack, level, text, flag);
	}

	/**
	 * Give us a code for the shift description
	 */
	@Override
	public String getShiftDescKey() {
		return "itemShiftDesc." + AMI.MOD_ID + "." + form.getId();
	}
	
	/**
	 * Give us a code for the shift description
	 */
	@Override
	public String getControlDescKey() {
		return "itemShiftDesc." + AMI.MOD_ID + "." + materialDefinition.getPath().replace('/', '.');
	}
	
	@Override
	public String getAltDescKey() {
		return null;
	}
	
}
