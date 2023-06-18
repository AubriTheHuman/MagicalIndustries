package com.aubrithehuman.ami.common.init;

import com.aubrithehuman.ami.AMI;
import com.aubrithehuman.ami.common.item.MaterialItem;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;


@Mod.EventBusSubscriber(modid = "ami", bus = Bus.MOD)
public class AMIColors {

	
	
	@SubscribeEvent
	public static void registerBlockColors(RegisterColorHandlersEvent.Block event){
//	  event.register(myBlockColor, coloredBlock1, coloredBlock2, ...);
	}
	

    @SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void registerItemColors(RegisterColorHandlersEvent.Item event){
//	  event.register(new ItemColor, coloredItem1, coloredItem2, ...);
		AMI.LOGGER.debug("Registering colors for");
		for(ResourceLocation materialItemMap : AMIItems.MATERIAL_ITEMS.keySet()) {
			AMI.LOGGER.debug("Registering color for: " + materialItemMap.toString());
//			ArrayList<ItemLike> items = new ArrayList<ItemLike>();
//			for (RegistryObject<Item> item : AMIItems.MATERIAL_ITEMS.get(materialItemMap).values()) {
//				items.add(item.get());
//			}
			
			AMIItems.MATERIAL_ITEMS.get(materialItemMap).values().forEach(materialItem ->
		            event.register((stack, layer) -> AMI.MATERIALS.get(((MaterialItem) materialItem.get()).getMaterialDefinition()).getProperties().getColor(), materialItem.get())
		    );
			
//			event.register(
//					(ItemStack pStack, int pTintIndex) ->
//	                pTintIndex == 0 && (pStack.getItem() instanceof MaterialItem material) ? 
//	                        		AMI.MATERIALS.get(material.getMaterialDefinition()).getProperties().getColor() : 
//	                        			-1, (ItemLike[]) items.toArray()
//	        );
		}
	}
	
}
