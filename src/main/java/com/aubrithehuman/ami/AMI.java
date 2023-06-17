package com.aubrithehuman.ami;

import org.slf4j.Logger;

import com.aubrithehuman.ami.api.item.material.Material;
import com.aubrithehuman.ami.api.item.material.registry.MaterialRegistry;
import com.aubrithehuman.ami.common.init.AMIBlockEntities;
import com.aubrithehuman.ami.common.init.AMIBlocks;
import com.aubrithehuman.ami.common.init.AMIItems;
import com.aubrithehuman.ami.common.init.AMIMaterialDefinitions;
import com.aubrithehuman.ami.common.init.AMITabs;
import com.mojang.logging.LogUtils;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AMI.MOD_ID)
public class AMI
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "ami";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    //Reload Listeners
    public static final MaterialRegistry MATERIALS = new AMIMaterialDefinitions(AMI.LOGGER);
	
    
    public AMI()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        //configs
    	ModLoadingContext.get().registerConfig(Type.COMMON, AMIConfig.SPEC_COMMON, "amicore-common.toml");
    	ModLoadingContext.get().registerConfig(Type.CLIENT, AMIConfig.SPEC_CLIENT, "amicore-client.toml");
    	ModLoadingContext.get().registerConfig(Type.SERVER, AMIConfig.SPEC_SERVER, "amicore-server.toml");

    	//registries!
    	//materials register way earlier
		AMIItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		new AMITabs();
		AMIBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		AMIBlockEntities.BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    	MinecraftForge.EVENT_BUS.addListener( this::onAddReloadListeners );
//    	MinecraftForge.EVENT_BUS.addListener( this::commonSetup );
		
		//register main class for whatever needs
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    private void commonSetup(final FMLCommonSetupEvent event)
    {
    	
    }

    
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    	
    }
    
    @SubscribeEvent
	public void onAddReloadListeners(final AddReloadListenerEvent event)
	{
		LOGGER.debug("Adding Reload Listeners!");
	}
}
