package com.aubrithehuman.ami.api.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public abstract class BaseItem extends Item {

	public BaseItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> text, TooltipFlag flag) {
		//put our description in
		
		if(this.getAltDescKey() != null) {
			if(Screen.hasAltDown()) {
				text.add(1, Component.translatable(this.getAltDescKey()[1]));
			} else {
				text.add(1, Component.translatable(this.getAltDescKey()[0]));
			} 
		}
		if(this.getControlDescKey() != null) {
			if(Screen.hasControlDown()) {
				text.add(1, Component.translatable(this.getControlDescKey()[1]));
			} else {
				text.add(1, Component.translatable(this.getControlDescKey()[0]));
			} 
		}
		if(this.getShiftDescKey() != null) {
			if(Screen.hasShiftDown()) {
				text.add(1, Component.translatable(this.getShiftDescKey()[1]));
			} else {
				text.add(1, Component.translatable(this.getShiftDescKey()[0]));
			} 			
		}
		
		super.appendHoverText(stack, level, text, flag);
	}
	
	@Nullable
	public abstract String[] getShiftDescKey();
	@Nullable
	public abstract String[] getControlDescKey() ;
	@Nullable
	public abstract String[] getAltDescKey();

}
