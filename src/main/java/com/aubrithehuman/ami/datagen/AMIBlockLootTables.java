package com.aubrithehuman.ami.datagen;

import com.aubrithehuman.ami.common.init.AMIBlocks;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class AMIBlockLootTables extends BlockLoot {
	
	// Used to create a factory method for the wrapp	ing Supplier
	  public AMIBlockLootTables() {}

//	  // The method used to generate the loot tables
//	  @Override
//	  public void accept(BiConsumer<ResourceLocation, LootTable.Builder> writer) {
//	    // Generate loot tables here by calling writer#accept
//	  }

	  @Override
	   protected void addTables() { 
		  dropSelf(AMIBlocks.TEMPERED_JAR.get());
	   }
	  
	  @Override
	  protected Iterable<Block> getKnownBlocks() {
	    return AMIBlocks.BLOCKS.getEntries() // Get all registered entries
	      .stream() // Stream the wrapped objects
	      .flatMap(RegistryObject::stream) // Get the object if available
	      ::iterator; // Create the iterable
	  }
}
