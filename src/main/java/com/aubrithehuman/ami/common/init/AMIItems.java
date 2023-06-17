package com.aubrithehuman.ami.common.init;

import java.util.HashMap;
import java.util.Map;

import com.aubrithehuman.ami.AMI;
import com.aubrithehuman.ami.api.item.material.Material;
import com.aubrithehuman.ami.api.item.material.properties.MaterialForm;
import com.aubrithehuman.ami.common.item.MaterialItem;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagBuilder;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AMIItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AMI.MOD_ID);

    // Items
	// =============================================================================================================

	//Tab items
	
	public static final RegistryObject<Item> DUMMY_ORE_ITEM = ITEMS.register("dummy_ore_item", 
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> DUMMY_METAL_ITEM = ITEMS.register("dummy_metal_item", 
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> DUMMY_MACHINE_ITEM = ITEMS.register("dummy_machine_item", 
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> DUMMY_FLUID_ITEM = ITEMS.register("dummy_fluid_item", 
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> DUMMY_MATERIAL_ITEM = ITEMS.register("dummy_material_item", 
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> DUMMY_BIO_ITEM = ITEMS.register("dummy_bio_item", 
			() -> new Item(new Item.Properties()));		
	public static final RegistryObject<Item> DUMMY_PETRO_ITEM = ITEMS.register("dummy_petro_item", 
			() -> new Item(new Item.Properties()));	
	public static final RegistryObject<Item> DUMMY_INTERMEDIATES_ITEM = ITEMS.register("dummy_intermediates_item", 
			() -> new Item(new Item.Properties()));	
	public static final RegistryObject<Item> DUMMY_TOOLS_ITEM = ITEMS.register("dummy_tools_item", 
			() -> new Item(new Item.Properties()));	
	public static final RegistryObject<Item> DUMMY_WORKINGTREE_ITEM = ITEMS.register("dummy_workingtree_item", 
			() -> new Item(new Item.Properties()));	
	
	//Material Items
	public static final Map<ResourceLocation, Map<MaterialForm, RegistryObject<Item>>> MATERIAL_ITEMS = new HashMap<>();
	 
	static {
		//Generate Materials
    	AMI.LOGGER.info("Generating Material Items");
		for (ResourceLocation material : AMI.MATERIALS.getData().keySet()) {
			Map<MaterialForm, RegistryObject<Item>> materialFormsMap = new HashMap<>();
			for(MaterialForm form : MaterialForm.values()) {
				materialFormsMap.put(form, 
						ITEMS.register(material.getPath() + "_" + form.getId(), 
								() -> new MaterialItem(new Item.Properties().tab(AMITabs.MATERIAL_TAB), material, form)));
			}		
			MATERIAL_ITEMS.put(material, materialFormsMap);	
		}
		
	}
	
    // BlockItems
    // =============================================================================================================
	
	
	
	// =============================================================================================================
	
	
	
	    
	@OnlyIn(Dist.CLIENT)
	public static void onClientSetup() {
//			RenderTypeHelper.setRenderLayer(TEMPERED_JAR.get(), RenderType.getTranslucent());
	}
	
}
