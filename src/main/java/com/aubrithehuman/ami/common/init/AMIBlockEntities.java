package com.aubrithehuman.ami.common.init;

import com.aubrithehuman.ami.AMI;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AMIBlockEntities {
	
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES,
			AMI.MOD_ID);
	
	// =============================================================================================================
    
//	public static final RegistryObject<Block> TEMPERED_JAR = BLOCKS
//			.register("tempered_jar",
//					() -> new TemperedSpiritJar(Properties.create(Material.GLASS).sound(SoundType.GLASS).hardnessAndResistance(5.0f, 10.0f).harvestTool(ToolType.PICKAXE).variableOpacity()));
//	
	// =============================================================================================================
    
	@OnlyIn(Dist.CLIENT)
	public static void onClientSetup() {
//		ClientRegistry.bindTileEntityRenderer(TEMPERED_JAR.get(), TemperedJarRenderer::new);
	}
}
