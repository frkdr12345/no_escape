
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noescape.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.noescape.block.LightBlock;
import net.mcreator.noescape.NoEscapeMod;

public class NoEscapeModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, NoEscapeMod.MODID);
	public static final RegistryObject<Block> LIGHT = REGISTRY.register("light", () -> new LightBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
