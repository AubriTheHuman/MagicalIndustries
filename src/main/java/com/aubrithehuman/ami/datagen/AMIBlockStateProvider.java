package com.aubrithehuman.ami.datagen;

import com.aubrithehuman.ami.AMI;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class AMIBlockStateProvider extends BlockStateProvider {

	public AMIBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, AMI.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
//		blockWithItem(AMIBlocks.)
	}
	
	private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
		simpleBlockItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
	}

}
