
package net.mcreator.testmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemShears;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;

import net.mcreator.testmod.ElementsTestMod;

@ElementsTestMod.ModElement.Tag
public class ItemCyanShears extends ElementsTestMod.ModElement {
	@GameRegistry.ObjectHolder("testmod:cyanshears")
	public static final Item block = null;
	public ItemCyanShears(ElementsTestMod instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemShears() {
			{
				setMaxDamage(0);
			}
			@Override
			public int getItemEnchantability() {
				return 2;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
				return 228f;
			}
		}.setUnlocalizedName("cyanshears").setRegistryName("cyanshears").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("testmod:cyanshears", "inventory"));
	}
}
