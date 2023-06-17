package com.aubrithehuman.ami.common.init;

import com.aubrithehuman.ami.AMI;

import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AMIBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			AMI.MOD_ID);
	
	// =============================================================================================================
    
	public static final RegistryObject<Block> TEMPERED_JAR = BLOCKS
			.register("tempered_jar",
					() -> new Block(BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.GLASS).strength(5.0f, 10.0f).noOcclusion()));
//	
	// =============================================================================================================
    
	@OnlyIn(Dist.CLIENT)
	public static void onClientSetup() {
//		RenderTypeHelper.setRenderLayer(TEMPERED_JAR.get(), RenderType.getTranslucent());
	}
	
}
