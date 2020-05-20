
package net.mcreator.testmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.testmod.item.ItemCyanArmor;
import net.mcreator.testmod.item.ItemCyan;
import net.mcreator.testmod.ElementsTestMod;

@ElementsTestMod.ModElement.Tag
public class RecipeMeltCyanChestplate extends ElementsTestMod.ModElement {
	public RecipeMeltCyanChestplate(ElementsTestMod instance) {
		super(instance, 71);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemCyanArmor.body, (int) (1)), new ItemStack(ItemCyan.block, (int) (1)), 1F);
	}
}
