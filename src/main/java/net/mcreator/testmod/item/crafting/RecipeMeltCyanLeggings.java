
package net.mcreator.testmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.testmod.item.ItemCyanArmor;
import net.mcreator.testmod.item.ItemCyan;
import net.mcreator.testmod.ElementsTestMod;

@ElementsTestMod.ModElement.Tag
public class RecipeMeltCyanLeggings extends ElementsTestMod.ModElement {
	public RecipeMeltCyanLeggings(ElementsTestMod instance) {
		super(instance, 70);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemCyanArmor.legs, (int) (1)), new ItemStack(ItemCyan.block, (int) (1)), 1F);
	}
}
