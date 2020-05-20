
package net.mcreator.testmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.testmod.item.ItemCyanArmor;
import net.mcreator.testmod.item.ItemCyan;
import net.mcreator.testmod.ElementsTestMod;

@ElementsTestMod.ModElement.Tag
public class RecipeMeltCyanHelmet extends ElementsTestMod.ModElement {
	public RecipeMeltCyanHelmet(ElementsTestMod instance) {
		super(instance, 72);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemCyanArmor.helmet, (int) (1)), new ItemStack(ItemCyan.block, (int) (1)), 1F);
	}
}
