
package net.mcreator.testmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.testmod.ElementsTestMod;

@ElementsTestMod.ModElement.Tag
public class ItemCyanArmor extends ElementsTestMod.ModElement {
	@GameRegistry.ObjectHolder("testmod:cyanarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("testmod:cyanarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("testmod:cyanarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("testmod:cyanarmorboots")
	public static final Item boots = null;
	public ItemCyanArmor(ElementsTestMod instance) {
		super(instance, 49);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("CYANARMOR", "testmod:cyan_", 228, new int[]{228, 228, 228, 228}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("block.slime.hit")), 4f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("cyanarmorhelmet")
				.setRegistryName("cyanarmorhelmet").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("cyanarmorbody")
				.setRegistryName("cyanarmorbody").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("cyanarmorlegs")
				.setRegistryName("cyanarmorlegs").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("cyanarmorboots")
				.setRegistryName("cyanarmorboots").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("testmod:cyanarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("testmod:cyanarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("testmod:cyanarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("testmod:cyanarmorboots", "inventory"));
	}
}
