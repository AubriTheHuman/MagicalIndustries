package com.aubrithehuman.ami.datagen;

import com.aubrithehuman.ami.AMI;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AMI.MOD_ID, bus = Bus.MOD)
public class DataGenerators {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		
		generator.addProvider(true, new AMIRecipeProvider(generator));
		generator.addProvider(true, new AMILootTableProvider(generator));
		generator.addProvider(true, new AMIBlockStateProvider(generator, existingFileHelper));
		generator.addProvider(true, new AMIItemModelProvider(generator, existingFileHelper));
	}

}
