package com.aubrithehuman.ami;

import net.minecraftforge.common.ForgeConfigSpec;

public class AMIConfig {

	public static final ForgeConfigSpec.Builder BUILDER_COMMON = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec.Builder BUILDER_CLIENT = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec.Builder BUILDER_SERVER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC_COMMON;
	public static final ForgeConfigSpec SPEC_CLIENT;
	public static final ForgeConfigSpec SPEC_SERVER;
	
	

	// =============================================================================================================
	
//	public static final ForgeConfigSpec.ConfigValue<Boolean> common_doMalum; 
	
	// =============================================================================================================
	
	static {
		BUILDER_COMMON.push("Common Config for AMICore");
		 
		BUILDER_COMMON.comment("Config Version. Do not touch!").define("NO TOUCHIES", 1);
		
		BUILDER_COMMON.pop();
		SPEC_COMMON = BUILDER_COMMON.build();

		
		
		/*
		 * ================================================================================================================================================
		 */
		
		BUILDER_CLIENT.push("Client Config for AMICore");

		BUILDER_CLIENT.comment("Config Version. Do not touch!").define("NO TOUCHIES", 1);
		
		BUILDER_CLIENT.pop();
		SPEC_CLIENT = BUILDER_CLIENT.build();
		
		
		
		/*
		 * ================================================================================================================================================
		 */
		
		BUILDER_SERVER.push("Server Config for AMICore");

		BUILDER_SERVER.comment("Config Version. Do not touch!").define("NO TOUCHIES", 1);
		
		BUILDER_SERVER.pop();
		SPEC_SERVER = BUILDER_SERVER.build();
	}
	
}
