package net.mcreator.testmod.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.NonNullList;

import net.mcreator.testmod.item.ItemCyanStick;
import net.mcreator.testmod.item.ItemCyanHoe;
import net.mcreator.testmod.item.ItemCyan;
import net.mcreator.testmod.ElementsTestMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraft.item.crafting.Ingredient;

@ElementsTestMod.ModElement.Tag
public class ProcedureDecrafting extends ElementsTestMod.ModElement {
	public ProcedureDecrafting(ElementsTestMod instance) {
		super(instance, 66);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Decrafting!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack is = (new Object() {
			public ItemStack getItemStack(int sltid) {
				if (entity instanceof EntityPlayerMP) {
					Container _current = ((EntityPlayerMP) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (0)));
		List<IRecipe> recipes = ForgeRegistries.RECIPES.getValues();
		for(int i = 0; i<recipes.size(); i++){
			IRecipe recipe = recipes.get(i);
			if(recipe.getRecipeOutput().getItem()==is.getItem()){
				List<Ingredient> items = (List)recipe.getIngredients();
				for(int j = 0; j<items.size(); j++){
					if (entity instanceof EntityPlayerMP) {
						Container _current = ((EntityPlayerMP) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								Ingredient ing = items.get(j);
								ItemStack[] is1 = ing.getMatchingStacks();
								if(is1.length>0){
									ItemStack _setstack = is1[0];
									((Slot) ((Map) invobj).get((int) (j+1))).putStack(_setstack);
									_current.detectAndSendChanges();
								}
							}
						}
					}
				}
				if (entity instanceof EntityPlayerMP) {
					Container _current = ((EntityPlayerMP) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
							_current.detectAndSendChanges();
						}
					}
				}
			}
		}
		return;
		/*if (((new Object() {
			public ItemStack getItemStack(int sltid) {
				if (entity instanceof EntityPlayerMP) {
					Container _current = ((EntityPlayerMP) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (0))).getItem() == new ItemStack(ItemCyanHoe.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayerMP) {
				Container _current = ((EntityPlayerMP) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(ItemCyan.block, (int) (1));
						_setstack.setCount(1);
						((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (entity instanceof EntityPlayerMP) {
				Container _current = ((EntityPlayerMP) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(ItemCyan.block, (int) (1));
						_setstack.setCount(1);
						((Slot) ((Map) invobj).get((int) (2))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (entity instanceof EntityPlayerMP) {
				Container _current = ((EntityPlayerMP) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(ItemCyanStick.block, (int) (1));
						_setstack.setCount(1);
						((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (entity instanceof EntityPlayerMP) {
				Container _current = ((EntityPlayerMP) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(ItemCyanStick.block, (int) (1));
						_setstack.setCount(1);
						((Slot) ((Map) invobj).get((int) (8))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (entity instanceof EntityPlayerMP) {
				Container _current = ((EntityPlayerMP) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
						_current.detectAndSendChanges();
					}
				}
			}
		}*/
	}
}
