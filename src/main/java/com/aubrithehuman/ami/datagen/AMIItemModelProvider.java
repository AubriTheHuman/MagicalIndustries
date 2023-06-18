package com.aubrithehuman.ami.datagen;

import com.aubrithehuman.ami.AMI;
import com.aubrithehuman.ami.api.item.material.properties.MaterialForm;
import com.aubrithehuman.ami.common.init.AMIItemTags;
import com.aubrithehuman.ami.common.init.AMIItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class AMIItemModelProvider extends ItemModelProvider {

	public AMIItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, AMI.MOD_ID, existingFileHelper);
		
	}

	@Override
	protected void registerModels() {	
		//dummy
		simpleItem(AMIItems.DUMMY_BIO_ITEM);
		simpleItem(AMIItems.DUMMY_FLUID_ITEM);
		simpleItem(AMIItems.DUMMY_INTERMEDIATES_ITEM);
		orientable(AMIItems.DUMMY_MACHINE_ITEM.getId().getPath(), 
				new ResourceLocation(AMI.MOD_ID,"item/" + AMIItems.DUMMY_MACHINE_ITEM.getId().getPath() + "_side"), 
				new ResourceLocation(AMI.MOD_ID,"item/" + AMIItems.DUMMY_MACHINE_ITEM.getId().getPath() + "_front"), 
				new ResourceLocation(AMI.MOD_ID,"item/" + AMIItems.DUMMY_MACHINE_ITEM.getId().getPath() + "_side"));
		simpleItem(AMIItems.DUMMY_MATERIAL_ITEM);
		simpleItem(AMIItems.DUMMY_ORE_ITEM);
		simpleItem(AMIItems.DUMMY_PETRO_ITEM);
		simpleItem(AMIItems.DUMMY_TOOLS_ITEM);
		simpleItem(AMIItems.DUMMY_WORKINGTREE_ITEM);
		
		for(MaterialForm form : MaterialForm.values()) {
			//add to type specific and all to main tag
			basicItem(new ResourceLocation(AMI.MOD_ID, "material/templates/" + form.getId()));
		}
		
		AMI.LOGGER.info("Creating Material models");
		for (ResourceLocation material : AMI.MATERIALS.getData().keySet()) {
			for(MaterialForm form : AMI.MATERIALS.get(material).getProperties().getForms()) {
				//add to type specific and all to main tag
				AMI.LOGGER.debug("doing: " + material.getPath() + "_" + form.getId());
				withExistingParent(material.getPath() + "_" + form.getId(), new ResourceLocation(AMI.MOD_ID, "material/templates/" + form.getId()));
			}
		}
	}

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AMI.MOD_ID,"item/" + item.getId().getPath()));
    }
    
    public ItemModelBuilder tintedItem(ResourceLocation item)
    {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", new ResourceLocation(item.getNamespace(), "item/" + item.getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(AMI.MOD_ID,"item/" + item.getId().getPath()));
    }

}
