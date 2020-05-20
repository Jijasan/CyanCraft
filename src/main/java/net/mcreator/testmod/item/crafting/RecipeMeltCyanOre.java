
package net.mcreator.testmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.testmod.item.ItemCyan;
import net.mcreator.testmod.block.BlockCyanOre;
import net.mcreator.testmod.ElementsTestMod;

@ElementsTestMod.ModElement.Tag
public class RecipeMeltCyanOre extends ElementsTestMod.ModElement {
	public RecipeMeltCyanOre(ElementsTestMod instance) {
		super(instance, 73);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockCyanOre.block, (int) (1)), new ItemStack(ItemCyan.block, (int) (1)), 1F);
	}
}
