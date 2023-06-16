package com.aubrithehuman.ami.common.init;


import com.aubrithehuman.ami.AMI;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class AMITabs {

    // Tabs
	// =============================================================================================================

    public static final CreativeModeTab ORE_TAB = new OreTab();
	public static final CreativeModeTab METAL_TAB = new MetalTab();
	public static final CreativeModeTab MACHINE_TAB = new MachineTab();
	public static final CreativeModeTab MATERIAL_TAB = new MaterialTab();
	public static final CreativeModeTab FLUID_TAB = new FluidTab();
	public static final CreativeModeTab BIO_TAB = new BioTab();
	public static final CreativeModeTab PETRO_TAB = new PetroTab();
	public static final CreativeModeTab INTERMEDIATES_TAB = new IntermediatesTab();
	public static final CreativeModeTab TOOLS_TAB = new ToolsTab();

	// =============================================================================================================

	static {
		
	}
	
	public static class OreTab extends CreativeModeTab {
		public OreTab() {
			super(AMI.MOD_ID + ".oretab");
		}

		@Override
		public ItemStack makeIcon() {
			return AMIItems.DUMMY_ORE_ITEM.get().getDefaultInstance();
		}
	};
	
	public static class MetalTab extends CreativeModeTab {
		public MetalTab() {
			super(AMI.MOD_ID + ".metaltab");
		}

		@Override
		public ItemStack makeIcon() {
			return AMIItems.DUMMY_METAL_ITEM.get().getDefaultInstance();
		}
	};
		
	public static class MachineTab extends CreativeModeTab {
		public MachineTab() {
			super(AMI.MOD_ID + ".machinetab");
		}

		@Override
		public ItemStack makeIcon() {
			return AMIItems.DUMMY_MACHINE_ITEM.get().getDefaultInstance();
		}
	};
	
	public static class FluidTab extends CreativeModeTab {
		public FluidTab() {
			super(AMI.MOD_ID + ".fluidtab");
		}

		@Override
		public ItemStack makeIcon() {
			return AMIItems.DUMMY_FLUID_ITEM.get().getDefaultInstance();
		}
	};
	
	public static class MaterialTab extends CreativeModeTab {
		public MaterialTab() {
			super(AMI.MOD_ID + ".materialtab");
		}

		@Override
		public ItemStack makeIcon() {
			return AMIItems.DUMMY_MATERIAL_ITEM.get().getDefaultInstance();
		}
	};
	
	public static class BioTab extends CreativeModeTab {
		public BioTab() {
			super(AMI.MOD_ID + ".biotab");
		}

		@Override
		public ItemStack makeIcon() {
			return AMIItems.DUMMY_BIO_ITEM.get().getDefaultInstance();
		}
	};
	
	public static class PetroTab extends CreativeModeTab {
		public PetroTab() {
			super(AMI.MOD_ID + ".petrotab");
		}

		@Override
		public ItemStack makeIcon() {
			return AMIItems.DUMMY_PETRO_ITEM.get().getDefaultInstance();
		}
	};
	
	public static class IntermediatesTab extends CreativeModeTab {
		public IntermediatesTab() {
			super(AMI.MOD_ID + ".intermediatestab");
		}

		@Override
		public ItemStack makeIcon() {
			return AMIItems.DUMMY_INTERMEDIATES_ITEM.get().getDefaultInstance();
		}
	};
	
	public static class ToolsTab extends CreativeModeTab {
		public ToolsTab() {
			super(AMI.MOD_ID + ".toolstab");
		}

		@Override
		public ItemStack makeIcon() {
			return AMIItems.DUMMY_TOOLS_ITEM.get().getDefaultInstance();
		}
	};
	
}
