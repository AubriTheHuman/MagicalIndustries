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

public abstract class AMIItem extends Item {

	public AMIItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> text, TooltipFlag flag) {
		//put our description in
		
		if(this.getAltDescKey() != null) {
			if(Screen.hasAltDown()) {
				String[] split = Component.translatable(this.getAltDescKey()[1]).getString().split(";");
				for (int i = split.length - 1; i >= 0; i--) text.add(1, Component.literal(split[i]));
			} else {
				text.add(1, Component.translatable(this.getAltDescKey()[0]));
			} 
		}
		if(this.getControlDescKey() != null) {
			if(Screen.hasControlDown()) {
				String[] split = Component.translatable(this.getControlDescKey()[1]).getString().split(";");
				for (int i = split.length - 1; i >= 0; i--) text.add(1, Component.literal(split[i]));
			} else {
				text.add(1, Component.translatable(this.getControlDescKey()[0]));
			} 
		}
		if(this.getShiftDescKey() != null) {
			if(Screen.hasShiftDown()) {
				String[] split = Component.translatable(this.getShiftDescKey()[1]).getString().split(";");
				for (int i = split.length - 1; i >= 0; i--) text.add(1, Component.literal(split[i]));
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
