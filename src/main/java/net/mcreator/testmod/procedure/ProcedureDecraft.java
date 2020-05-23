package net.mcreator.testmod.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.tileentity.TileEntity;

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
import org.lwjgl.Sys;

@ElementsTestMod.ModElement.Tag
public class ProcedureDecraft extends ElementsTestMod.ModElement {
	public ProcedureDecraft(ElementsTestMod instance) {
		super(instance, 77);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Decraft!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Decraft!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Decraft!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Decraft!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		ItemStack is = ((new Object() {
			public ItemStack getItemStack(BlockPos pos, int sltid) {
				TileEntity inv = world.getTileEntity(pos);
				if (inv instanceof TileEntityLockableLoot)
					return ((TileEntityLockableLoot) inv).getStackInSlot(sltid);
				return ItemStack.EMPTY;
			}
		}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))));
		if(is==ItemStack.EMPTY){
			System.out.println("Slot 0 is empty!");
			return;
		}
		List<IRecipe> recipes = ForgeRegistries.RECIPES.getValues();
		for(int i = 0; i<recipes.size(); i++){
			IRecipe recipe = recipes.get(i);
			if(recipe.getRecipeOutput().getItem()==is.getItem()){
				List<Ingredient> items = (List)recipe.getIngredients();
				for(int j = 0; j<items.size(); j++){
					TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (inv != null && (inv instanceof TileEntityLockableLoot)) {
						Ingredient ing = items.get(j);
						ItemStack[] is1 = ing.getMatchingStacks();
						if(is1.length>0){
							ItemStack _setstack = is1[0];
							_setstack.setCount((new Object() {
								public int getAmount(BlockPos pos, int sltid) {
									TileEntity inv = world.getTileEntity(pos);
									if (inv instanceof TileEntityLockableLoot) {
										ItemStack stack = ((TileEntityLockableLoot) inv).getStackInSlot(sltid);
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))));
							((TileEntityLockableLoot) inv).setInventorySlotContents((int) (j+1), _setstack);
						}
					}
				}
				{
					TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (inv instanceof TileEntityLockableLoot)
						((TileEntityLockableLoot) inv).removeStackFromSlot((int) (0));
				}
				break;
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
		}*/
	}
}