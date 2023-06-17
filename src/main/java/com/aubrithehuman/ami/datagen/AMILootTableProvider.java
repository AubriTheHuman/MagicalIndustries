package com.aubrithehuman.ami.datagen;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class AMILootTableProvider extends LootTableProvider{

	public AMILootTableProvider(DataGenerator p_124437_) {
		super(p_124437_);
	}
	
	@Override 
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
		return ImmutableList.of(
			    Pair.of(AMIBlockLootTables::new, LootContextParamSets.BLOCK) // Loot table builder for the 'empty' parameter set
			    //...
			  );
	}
	
//	@Override
//	protected Iterable<Block> getKnownBlocks() {
//		return AMIBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
//	}
//	
	@Override
	protected void validate(Map<ResourceLocation, LootTable> tables, ValidationContext ctx) {
	  tables.forEach((name, table) -> LootTables.validate(ctx, name, table));
	}

}
