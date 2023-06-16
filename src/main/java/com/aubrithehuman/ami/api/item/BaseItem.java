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
		text.add(Component.literal("test1"));
		//shift and put desc first
		if(text.size() > 1) {
			for(int i = text.size() - 1; i >= 0 ; i--) {
				text.add(i+1, text.get(i));
			}
		}

		//put our description in
		if(Screen.hasShiftDown() && this.getShiftDescKey() != null) {
			text.add(0, Component.translatable(this.getShiftDescKey()));
		} else {
			text.add(0, Component.literal("Press ").withStyle(ChatFormatting.DARK_GRAY).append("[shift]").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.GRAY).append(" for item description.").withStyle(ChatFormatting.DARK_GRAY));
		} 
		if(Screen.hasControlDown() && this.getControlDescKey() != null) {
			text.add(0, Component.translatable(this.getControlDescKey()));
		} else {
			text.add(0, Component.literal("Press ").withStyle(ChatFormatting.DARK_GRAY).append("[ctrl]").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.GRAY).append(" for item properties.").withStyle(ChatFormatting.DARK_GRAY));
		} 
		if(Screen.hasAltDown() && this.getAltDescKey() != null) {
			text.add(0, Component.translatable(this.getAltDescKey()));
		} else {
			text.add(0, Component.literal("Press ").withStyle(ChatFormatting.DARK_GRAY).append("[alt]").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.GRAY).append(" for advanced information.").withStyle(ChatFormatting.DARK_GRAY));
		} 
		
		
		super.appendHoverText(stack, level, text, flag);
	}
	
	@Nullable
	public abstract String getShiftDescKey();
	@Nullable
	public abstract String getControlDescKey() ;
	@Nullable
	public abstract String getAltDescKey();

}
