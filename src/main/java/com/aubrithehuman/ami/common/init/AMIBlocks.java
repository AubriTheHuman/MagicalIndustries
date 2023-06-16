package com.aubrithehuman.ami.common.init;

import com.aubrithehuman.ami.AMI;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AMIBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			AMI.MOD_ID);
	
	// =============================================================================================================
    
//	public static final RegistryObject<Block> TEMPERED_JAR = BLOCKS
//			.register("tempered_jar",
//					() -> new TemperedSpiritJar(Properties.create(Material.GLASS).sound(SoundType.GLASS).hardnessAndResistance(5.0f, 10.0f).harvestTool(ToolType.PICKAXE).variableOpacity()));
//	
	// =============================================================================================================
    
	@OnlyIn(Dist.CLIENT)
	public static void onClientSetup() {
//		RenderTypeHelper.setRenderLayer(TEMPERED_JAR.get(), RenderType.getTranslucent());
	}
	
}
