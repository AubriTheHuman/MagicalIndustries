package com.aubrithehuman.ami.common.tag;

import com.aubrithehuman.ami.AMI;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagGenerator {
	
	public static TagKey<Item> item(String location) {
        return ItemTags.create(new ResourceLocation(AMI.MOD_ID, location));
    }
	
	public static TagKey<Item> itemForge(String location) {
        return ItemTags.create(new ResourceLocation("forge", location));
    }
	
	public static TagKey<Item> itemMinecraft(String location) {
        return ItemTags.create(new ResourceLocation(location));
    }
	
	public static TagKey<Block> block(String location) {
        return BlockTags.create(new ResourceLocation(AMI.MOD_ID, location));
    }
	
	public static TagKey<Block> blockForge(String location) {
        return BlockTags.create(new ResourceLocation("forge", location));
    }
	
	public static TagKey<Block> blockMinecraft(String location) {
        return BlockTags.create(new ResourceLocation(location));
    }
	
}
